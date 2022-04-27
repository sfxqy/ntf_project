package com.ntf.ntf_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.ntf.ntf_project.common.CommonResult;
import com.ntf.ntf_project.model.LoginResponse;
import com.ntf.ntf_project.model.User;
import io.swagger.annotations.ApiOperation;
import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sfx
 * @Description
 */
public class UserController {




  /**
   * 手机号登录接口
   */
  @ApiOperation(value = "手机号登录接口")
  @RequestMapping(value = "/mobile", method = RequestMethod.POST)
  public CommonResult<Void> phoneLogin(@RequestBody @Validated User user) {/*
    String phone = loginRequest.getPhone();
    String captcha = loginRequest.getCaptcha();
    String areaCode = loginRequest.getAreaCode();
    Object o = redisUtil.get(YiouConstants.IYIOU_TEST_ACCOUNT + phone);
    if (null!=o){
      JSONObject json = JSONObject.parseObject(o.toString());
      TestAccount testAccount = JSONObject.toJavaObject(json, TestAccount.class);
      if (!Objects.equals(captcha,testAccount.getVerificationCode())){
        return CommonResult.captchaFailed("验证码错误，请重新输入");
      }
    }else {
      if (!ValidateFormUtil.checkPhone(phone, areaCode)) {
        return CommonResult.mobileFailed("请输入正确的手机号");
      }
      if (!ValidateFormUtil.checkCaptcha(captcha)) {
        return CommonResult.captchaFailed("验证码格式错误，验证码必须为6位数字");
      }
      if (!smsService.checkValidateCode(areaCode + phone, captcha)) {
        return CommonResult.captchaFailed("验证码错误，请重新输入");
      }
    }
    RegisterRequest registerRequest = new RegisterRequest();
    BeanUtils.copyProperties(loginRequest, registerRequest);
    return CommonResult.success(userService.login(registerRequest, Constants.LOGIN_BY_PHONE));*/
    return null;
  }

}
