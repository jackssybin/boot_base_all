package com.jk.modules.wechat.controller;

import com.jk.common.entity.R;
import com.jk.modules.wechat.utils.Ognl;
import com.jk.modules.wechat.utils.PayConfigUtil;
import com.jk.modules.wechat.utils.WeixinHelper;
import com.jk.modules.wechat.utils.WxOauth2Token;
import com.jk.modules.wechat.entity.WxUserEntity;
import com.jk.modules.wechat.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jk.modules.sys.controller.AbstractController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/12/28.
 * 内容：微信端测试
 */
@RestController
@RequestMapping("/wx")
public class LoginController extends AbstractController{
    @Autowired
    WxUserService wxUserService;

//    先进来玩一下
@RequestMapping(value = {"",""},method = RequestMethod.GET)
    public ModelAndView login(Model model){
        System.out.println("--------------登录成功---------------");
            ModelAndView mv = new ModelAndView("/wechat/success");
            return mv;
        }


//登陆注册的加密方式  new ToMD5().getMD5(your pwd)
//    System.out.println(new ToMD5().getMD5("123456"));


    //    先进来玩一下
    @RequestMapping(value = {"/selectOne",""},method = RequestMethod.GET)
    public ModelAndView login(Model model,Long id){
        R r = wxUserService.getWxUserById(id);
        WxUserEntity userEntity = (WxUserEntity) r.get(1);
        System.out.println("--------------登录成功---------------");
        ModelAndView mv = new ModelAndView("/wechat/success");
        model.addAttribute("user",userEntity);
        return mv;
    }



//    微信授权
    /**
     * 微信登录页面
     *
     * @return
     */
    @RequestMapping("/wx_login")
    public String wx_login(HttpSession session, String code, String state, Model model) {
        System.out.println("code:" + code + "    state:" + state);
        // 用户同意授权
        if (code != null && !"authdeny".equals(code) && !code.equals("")) {
            System.out.println("code:" + code + "    state:" + state);
            // 获取网页授权access_token
            WxOauth2Token oauth2Token = WeixinHelper.getOauth2AccessToken(PayConfigUtil.APP_ID, PayConfigUtil.APP_SECRET, code);
            if (Ognl.isNotEmpty(oauth2Token)) {//token不为空
                System.out.println("---------oauth2Token.getOpenId():" + oauth2Token.getOpenId());
                if (Ognl.isNotEmpty(oauth2Token.getAccessToken())) {
                    session.setAttribute("OpenId", oauth2Token.getOpenId());
                    // 判断openid存在否，存在直接进入主界面   不存在返回注册页面
                    System.out.println("---------微信key:" + oauth2Token.getOpenId());
                    return "/wechat/success";
                }
                session.setAttribute("oauth2Token", oauth2Token.toString());
            }
        }
        // 不同意授权   返回注册页面
        return "/wechat/wechat";
    }





}
