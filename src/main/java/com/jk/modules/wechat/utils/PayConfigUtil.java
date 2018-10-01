package com.jk.modules.wechat.utils;

/**
 * 微信授权登录  消息通知 及 支付 测试Demo
 *
 * @author makeit
 */
public class PayConfigUtil {
	//初始化
	public final static String APP_ID = "wx024f6de48cf83505"; //公众账号appid（改为自己实际的）
	public final static String APP_SECRET = "1469606b7d0e79a0286dcd22fa8fd224";
	public final static String MCH_ID = "1284133501"; //商户号（改为自己实际的）
	public final static String API_KEY = "11178910132139087808241315057777"; //（改为自己实际的）key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
	
	//有关url
	public final static String UFDODER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
//	public final static String NOTIFY_URL = "http://vip.aswk.cn/computer/wxpay/weixin_notify"; //微信支付回调接口，就是微信那边收到（改为自己实际的）
	public final static String NOTIFY_URL = "http://beta.j.anssy.com/computer/wxpay/weixin_notify"; //微信支付回调接口，就是微信那边收到（改为自己实际的）
//	public final static String NOTIFY_URL = "http://122.114.69.76/computer/wxpay/weixin_notify"; //微信支付回调接口，就是微信那边收到（改为自己实际的）
	//企业向个人账号付款的URL
	public final static String SEND_EED_PACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
//	public final static String CREATE_IP = "119.147.115.108";//发起支付ip（改为自己实际的）
	public final static String CREATE_IP = "47.128.149.97";//发起支付ip（改为自己实际的）

}
