package com.ntf.ntf_project.constants;

/**
 * 系统常量
 */
public interface IFrameworkConstants {

  /**
   * 接口请求成功，正确返回
   */
  int SYSTEM_SUCCESS = 0;
  /**
   * 接口请求失败，直接返回
   */
  int SYSTEM_FAIL = 1;
  /**
   * 请求数据为空或不存在
   */
  int DATA_NULL = -1;
  /**
   * 接口参数错误，直接返回
   */
  int SYSTEM_PARAM_ERROR = 2;
  /**
   * 用户登录过期，token无效
   */
  int SYSTEM_TOKEN_ERROR_CODE = 3;
  /**
   * 权限不足
   */
  int SYSTEM_ROLE_ERROR_CODE = 999;
  /**
   * 服务内部错误，异常返回
   */
  int SYSTEM_ERROR_CODE = 9999;

  String SYSTEM_OPENID = "1234567890";
  String SYSTEM_CHARSET = "UTF-8";
  String SYSTEM = "SYSTEM";
  String GUEST = "GUEST";

  String FOLDER_SEPARATOR = "/";
  String CURRENT_PATH = ".";

  String ZERO = "0";
  String ONE = "1";
  String TWO = "2";
  String THREE = "3";
  String FOUR = "4";
  String FIVE = "5";
  String SIX = "6";
  String SEVEN = "7";
  String EIGHT = "8";
  String NINE = "9";
  String TEN = "10";
  String ELEVEN = "11";
  String TWELVE = "12";

  String MESSAGE_ROLE_ERROR = "权限不足，请联系管理员！！！";
  String MESSAGE_LOGIN_FAIL = "登录失效，请重新登录！！！";
  String MESSAGE_SECURITY_CODE = "验证码输入错误！！！";
  String MESSAGE_TOKEN_ERROR = "Token已经失效，请重新登录。";
  String MESSAGE_ERROR_SYNC = "System internal error";
  String MESSAGE_OK = "OK";
  String MESSAGE_FIAL = "FAIL";

  /**
   * 用户TONKEN
   */
  String CONSTANT_SESSION_ID = "sessionid";
  String CONSTANT_USER_TOKEN = "token";
  String CONSTANT_LOGINER = "loginer";
  String CONSTANT_USER = "user";
  String CONSTANT_PASSWORD = "password";
  String CONSTANT_COMPANY = "company";
  String CONSTANT_USER_MAIN = "USERMAIN";
  String CONSTANT_SQL_SESSION = "sqlsession";

  /**
   * 系统拦截错误页面
   */
  String SYSTEM_ROOT = "/error";

  /**
   * 防伪码
   */
  String CONSTANT_SECURITY_CODE = "CACHE:SecurityCode:";

  /**
   * 手机验证码redis前缀
   */
  String PHONE_SECURITY_CODE = "PHONENUM:SecurityCode";
  /**
   * 管理员权限缓存
   */
  String MANAGER_ROLE_KEY = "CACHE:MANAGER:ROLE:";

  /**
   * 空字符串
   */
  String EMPTY = "";
  /**
   * 半角空格
   */
  String BLANK = " ";
  /**
   * 半角冒号
   */
  String COLON = ":";

  /**
   * 数据锁
   */
  String LOCK = ".LOCK";

  String SEMICOLON = ";";
  String QUOTES = "'";
  String AND = "&";
  String QUMARK = "?";

  String BACKSLASH = "/";
  String BACKSLASH2 = "//";
  String FILE_URI = "file://";

  String DOT = ".";
  char DOT2 = '.';
  String COMMA = ",";
  String TRANSVERSE_LINE = "-";
  String DOWN_LINE = "_";
  char DOWN_LINE2 = '_';

}
