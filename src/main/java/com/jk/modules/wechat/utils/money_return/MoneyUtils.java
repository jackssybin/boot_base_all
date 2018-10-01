package com.jk.modules.wechat.utils.money_return;

import com.jk.modules.wechat.utils.Ognl;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.*;

//import org.apache.commons.lang3.StringUtils;


public class MoneyUtils {
	private static String appid = "wx024f6de48cf83505";// 应用ID
	private static String appsecret = "1469606b7d0e79a0286dcd22fa8fd224";// 应用密钥
	private static String partner = "1284133501";// 微信支付商户号
	private static String partnerkey = "11178910132139087808241315057777";// 财付通初始密码
	private static String charset = "UTF-8";
	private static  String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
//url
	public static String getUrl()
	{
		return url;
	}
//	商户号
	public static String getMch_id()
	{
		return partner;
	}
	//商户appid
	public static String getWxAppid()
	{
		return appid;
	}
	/**
	 * 随机16为数值
	 * 
	 * @return
	 */
	public static String buildRandom() {
		String currTime = TenpayUtil.getCurrTime();
		String strTime = currTime.substring(8, currTime.length());
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < 4; i++) {
			num = num * 10;
		}
		return (int) ((random * num)) + strTime;
	}

	/**
	 * 获取ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("PRoxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (null == ip) {
			ip = "";
		}
//		if (StringUtils.isNotEmpty(ip)) {
		if (Ognl.isNotEmpty(ip)) {
			String[] ipArr = ip.split(",");
			if (ipArr.length > 1) {
				ip = ipArr[0];
			}
		}
		return ip;
	}

	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。 sign
	 */
	public static String createSign(Map<String, Object> map) {
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		for (Map.Entry<String, Object> m : map.entrySet()) {
			packageParams.put(m.getKey(), m.getValue().toString());
		}

		StringBuffer sb = new StringBuffer();
		Set<?> es = packageParams.entrySet();
		Iterator<?> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (!Ognl.isEmpty(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + partnerkey);
		 
		
		String sign = MD5Util.MD5Encode(sb.toString(), charset).toUpperCase();
		return sign;
	}

	public static String getOrderNo() {
		String order = partner
				+ new SimpleDateFormat("yyyyMMdd").format(new Date());
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			order += r.nextInt(9);
		}
		return order;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getOrderNo()); }
	 */

	final static String KEYSTORE_FILE = "D:/zs/apiclient_cert.p12";
	final static String KEYSTORE_PASSWORD = "1284133501";
	
	public static String doSendMoney(String url, String data) throws Exception {
		KeyStore keyStore  = KeyStore.getInstance("PKCS12");
		  FileInputStream instream = new FileInputStream(new File(KEYSTORE_FILE));//P12文件目录
//		InputStream instream = MoneyUtils.class.getResourceAsStream("/apiclient_cert.p12");
        try {
            keyStore.load(instream, KEYSTORE_PASSWORD.toCharArray());//这里写密码..默认是你的MCHID
        } finally {
            instream.close();
        }
        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, KEYSTORE_PASSWORD.toCharArray())//这里也是写密码的
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
        		SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {
        	HttpPost httpost = new HttpPost(url); // 设置响应头信息
        	httpost.addHeader("Connection", "keep-alive");
        	httpost.addHeader("Accept", "*/*");
        	httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        	httpost.addHeader("Host", "api.mch.weixin.qq.com");
        	httpost.addHeader("X-Requested-With", "XMLHttpRequest");
        	httpost.addHeader("Cache-Control", "max-age=0");
        	httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
    		httpost.setEntity(new StringEntity(data, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpost);
            try {
                HttpEntity entity = response.getEntity();
                String jsonStr = toStringInfo(response.getEntity(),"UTF-8");
                
                //微信返回的报文时GBK，直接使用httpcore解析乱码
              //  String jsonStr = EntityUtils.toString(response.getEntity(),"UTF-8");
                EntityUtils.consume(entity);
               return jsonStr;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
	}
	
	private static String toStringInfo(HttpEntity entity, String defaultCharset) throws Exception, IOException{
		final InputStream instream = entity.getContent();
	    if (instream == null) {
	        return null;
	    }
	    try {
	        Args.check(entity.getContentLength() <= Integer.MAX_VALUE,
	                "HTTP entity too large to be buffered in memory");
	        int i = (int)entity.getContentLength();
	        if (i < 0) {
	            i = 4096;
	        }
	        Charset charset = null;
	        
	        if (charset == null) {
	            charset = Charset.forName(defaultCharset);
	        }
	        if (charset == null) {
	            charset = HTTP.DEF_CONTENT_CHARSET;
	        }
	        final Reader reader = new InputStreamReader(instream, charset);
	        final CharArrayBuffer buffer = new CharArrayBuffer(i);
	        final char[] tmp = new char[1024];
	        int l;
	        while((l = reader.read(tmp)) != -1) {
	            buffer.append(tmp, 0, l);
	        }
	        return buffer.toString();
	    } finally {
	        instream.close();
	    }
	}
	
	public static String createXML(Map<String, Object> map){
		String xml = "<xml>";
		Set<String> set = map.keySet();
		Iterator<String> i = set.iterator();
		while(i.hasNext()){
			String str = i.next();
			xml+="<"+str+">"+"<![CDATA["+map.get(str)+"]]>"+"</"+str+">";
		}
		xml+="</xml>";
		return xml;
	}
}
