package com.ntf.ntf_project.common;


import com.ntf.ntf_project.exception.ExceptionCodeEnum;
import com.ntf.ntf_project.exception.ExceptionHandler;

public class CommonResult<T> {

  private long code;
  private String message;
  private T data;

  public CommonResult() {
  }

  protected CommonResult(long code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * 成功返回结果
   */
  public static <T> CommonResult<T> success() {
    return new CommonResult<T>(ExceptionCodeEnum.SUCCESS.getCode(),
        ExceptionCodeEnum.SUCCESS.getMessage(), null);
  }

  /**
   * 成功返回结果
   */
  public static <T> CommonResult<T> success(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.SUCCESS.getCode(), message, null);
  }

  /**
   * 成功返回结果
   *
   * @param data 获取的数据
   */
  public static <T> CommonResult<T> success(T data) {
    return new CommonResult<T>(ExceptionCodeEnum.SUCCESS.getCode(),
        ExceptionCodeEnum.SUCCESS.getMessage(), data);
  }

  /**
   * 成功返回结果
   *
   * @param data 获取的数据
   * @param message 提示信息
   */
  public static <T> CommonResult<T> success(T data, String message) {
    return new CommonResult<T>(ExceptionCodeEnum.SUCCESS.getCode(), message, data);
  }

  /**
   * 失败返回结果
   *
   * @param errorCode 错误码
   */
  public static <T> CommonResult<T> failed(ExceptionHandler errorCode) {
    System.out.println("errorCode1:" + errorCode);
    return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
  }

  /**
   * 失败返回结果
   *
   * @param errorCode 错误码
   * @param message 错误信息
   */
  public static <T> CommonResult<T> failed(ExceptionHandler errorCode, String message) {
    System.out.println("errorCode2:" + errorCode);
    return new CommonResult<T>(errorCode.getCode(), message, null);
  }

  /**
   * 失败返回结果
   *
   * @param errorCode 错误码
   * @param message 错误信息
   */
  public static <T> CommonResult<T> failed(Long errorCode, String message) {
    return new CommonResult<T>(errorCode, message, null);
  }

  /**
   * 失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> failed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.FAILED.getCode(), message, null);
  }

  /**
   * 失败返回结果
   */
  public static <T> CommonResult<T> failed() {
    return failed(ExceptionCodeEnum.FAILED);
  }

  /**
   * 参数验证失败返回结果
   */
  public static <T> CommonResult<T> validateFailed() {
    return failed(ExceptionCodeEnum.VALIDATE_FAILED);
  }

  /**
   * 参数验证失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> validateFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.VALIDATE_FAILED.getCode(), message, null);
  }

  /**
   * 未登录返回结果
   */
  public static <T> CommonResult<T> unauthorized(T data) {
    return new CommonResult<T>(ExceptionCodeEnum.UNAUTHORIZED.getCode(),
        ExceptionCodeEnum.UNAUTHORIZED.getMessage(), data);
  }

  /**
   * 未登录返回结果
   */
  public static <T> CommonResult<T> unauthorized() {
    return new CommonResult<T>(ExceptionCodeEnum.UNAUTHORIZED.getCode(),
        ExceptionCodeEnum.UNAUTHORIZED.getMessage(), null);
  }

  /**
   * 没有权限查看
   */
  public static <T> CommonResult<T> forbidden() {
    return new CommonResult<T>(ExceptionCodeEnum.FORBIDDEN.getCode(),
        ExceptionCodeEnum.FORBIDDEN.getMessage(), null);
  }

  /**
   * 未授权返回结果
   */
  public static <T> CommonResult<T> forbidden(T data) {
    return new CommonResult<T>(ExceptionCodeEnum.FORBIDDEN.getCode(),
        ExceptionCodeEnum.FORBIDDEN.getMessage(), data);
  }

  /**
   * 未登录返回结果
   */
  public static <T> CommonResult<T> userUnChecked(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.UNAUTHORIZED.getCode(),
        message, null);
  }

  /**
   * 手机号校验失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> mobileFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.MOBILE_FAILED.getCode(), message, null);
  }

  /**
   * 邮箱校验失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> emailFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.EMAIL_FAILED.getCode(), message, null);
  }

  /**
   * 微信登录参数错误
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> wxLoginParamFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.WX_LOGIN_PARAM_FAILED.getCode(), message, null);
  }

  /**
   * 谷歌校验失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> googleFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.GOOGLE_FAILED.getCode(), message, null);
  }

  /**
   * 验证码校验失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> captchaFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.CAPTCHA_FAILED.getCode(), message, null);
  }

  /**
   * 商品信息校验失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> productsFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.PRODUCTS_FAILED.getCode(), message, null);
  }

  /**
   * 订单信息校验失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> orderFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.ORDER_FAILED.getCode(), message, null);
  }

  /**
   * 报告信息校验失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> reportFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.REPORT_FAILED.getCode(), message, null);
  }

  /**
   * 报告不存在返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> reportEmpty(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.REPORT_NULL.getCode(), message, null);
  }

  /**
   * 报告信息校验失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> redirectFailed(String message) {
    return new CommonResult<T>(ExceptionCodeEnum.REDIRECT_PARAM_FAILED.getCode(), message, null);
  }

  public long getCode() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
