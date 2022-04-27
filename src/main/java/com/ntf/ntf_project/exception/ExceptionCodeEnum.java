package com.ntf.ntf_project.exception;

public enum ExceptionCodeEnum implements ExceptionHandler {
  // 数据操作错误定义
  SUCCESS(200, "操作成功"),
  PRAM_NOT_MATCH(400, "参数不正确"),
  VALIDATE_FAILED(400, "参数检验失败"),
  UNAUTHORIZED(401, "未登录或token过期，请登录！"),
  FORBIDDEN(403, "没有相关权限"),
  NOT_FOUND(404, "没有找到相关数据"),
  MOBILE_FAILED(405, "手机号错误"),
  EMAIL_FAILED(406, "邮箱错误"),
  CAPTCHA_FAILED(407, "验证码错误"),
  GOOGLE_FAILED(408, "谷歌错误"),
  WX_LOGIN_PARAM_FAILED(409, "邮箱错误"),
  LOGIN_PHONE_EXISTED(410, "绑定的手机号已存在"),
  FAILED(500, "操作失败"),
  ERROR(500, "系统异常"),
  PRODUCTS_FAILED(501, "商品信息错误"),
  REPORT_FAILED(502, "报告信息错误"),
  ORDER_FAILED(503, "订单信息错误"),
  REDIRECT_PARAM_FAILED(504, "回调参数错误"),
  REPORT_NULL(505, "报告不存在或已删除"),
  ;

  private long code;
  private String message;

  private ExceptionCodeEnum(long code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public long getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
