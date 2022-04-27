package com.ntf.ntf_project.constants;

public class Constants {

  //接口返回正确码
  public static final Integer AUTH_SUC_CODE = 200;

  public static final long TOKEN_EXPRESS_MINUTES = (60); //1小时

  public static final String SEPARATOR_COMMA = ",";

  public static final int NUM_ZERO = 0;
  public static final int NUM_ONE_HUNDRED = 100;

  public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

  public static final String UTF_8 = "UTF-8";

  public static final String SHA_1 = "SHA-1";

  //用户登token redis存储前缀
  public static final String USER_TOKEN_REDIS_KEY_PREFIX = "TOKEN_USER_";

  //默认分页
  public static final int DEFAULT_PAGE = 1;

  //默认分页
  public static final int DEFAULT_LIMIT = 20;

  //登录方式
  public static final int LOGIN_BY_PHONE = 1; //手机登录
  public static final int LOGIN_BY_EMAIL = 2; //邮箱登录
  public static final int LOGIN_BY_GOOGLE = 3; //谷歌登录
  public static final int LOGIN_BY_WECHAT = 4; //微信登录

  //支付方式
  public static final String PAYMENT_TYPE="PAYMENT_TYPE";
  public static final Integer PAY_TYPE_WE_CHAT = 1; //微信支付
  public static final String PAY_TYPE_WE_CHAT_NAME = "wx_pay"; //微信支付

  public static final Integer PAY_TYPE_APPLE_PAY = 3; //苹果支付
  public static final String PAY_TYPE_APPLE_PAY_NAME = "apple_pay"; //苹果支付

  public static final String SYSTEM_USER_REDIS_KEY = "_user_info_";

  //降序
  public static final String SORT_TYPE_DESC="desc";

  //升序
  public static final String SORT_TYPE_ASC="asc";
}
