package com.ntf.ntf_project.utils;

import com.ntf.ntf_project.constants.IFrameworkConstants;
import java.util.List;
import java.util.Map;

/**
 * 判断一个对象是不是空
 */
public class EmptyHelper implements IFrameworkConstants {

  /**
   * <p>
   * Checks if a String is whitespace, empty ("") or null.
   * </p>
   *
   * <pre>
   * StringUtils.isBlank(null)      = true
   * StringUtils.isBlank("")        = true
   * StringUtils.isBlank(" ")       = true
   * StringUtils.isBlank("bob")     = false
   * StringUtils.isBlank("  bob  ") = false
   * </pre>
   *
   * @param str the String to check, may be null
   * @return <code>true</code> if the String is null, empty or whitespace
   */
  public static boolean isBlank(String str) {
    int strLen;
    if (str == null || (strLen = str.length()) == 0) {
      return true;
    }
    for (int i = 0; i < strLen; i++) {
      if ((Character.isWhitespace(str.charAt(i)) == false)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Determine whether the given array is empty: i.e. {@code null} or of zero length.
   *
   * @param array the array to check
   */
  public static boolean isEmpty(Object[] array) {
    return (array == null || array.length == 0);
  }

  public static boolean isEmpty(List<?> array) {
    return (array == null || array.size() == 0);
  }

  public static boolean isEmpty(Map<?, ?> map) {
    return (map == null || map.size() == 0);
  }

  /**
   * Check whether the given String is empty.
   * <p>
   * This method accepts any Object as an argument, comparing it to {@code null} and the empty
   * String. As a consequence, this method will never return {@code true} for a non-null non-String
   * object.
   * <p>
   * The Object signature is useful for general attribute handling code that commonly deals with
   * Strings but generally has to iterate over Objects since attributes may e.g. be primitive value
   * objects as well.
   *
   * @param str the candidate String
   */
  public static boolean isEmpty(Object str) {
    return (str == null || "".equals(str));
  }

  /**
   * <p>
   * Checks if a String is empty ("") or null.
   * </p>
   *
   * <pre>
   * StringUtils.isEmpty(null)      = true
   * StringUtils.isEmpty("")        = true
   * StringUtils.isEmpty(" ")       = false
   * StringUtils.isEmpty("bob")     = false
   * StringUtils.isEmpty("  bob  ") = false
   * </pre>
   *
   * <p>
   * NOTE: This method changed in Lang version 2.0. It no longer trims the String. That
   * functionality is available in isBlank().
   * </p>
   *
   * @param str the String to check, may be null
   * @return <code>true</code> if the String is empty or null
   */
  public static boolean isEmpty(String str) {
    return str == null || str.length() == 0;
  }

  /**
   * <p>
   * Checks if a String is whitespace, empty ("") or null.
   * </p>
   *
   * <pre>
   * StringUtils.isBlank(null)      = true
   * StringUtils.isBlank("")        = true
   * StringUtils.isBlank(" ")       = true
   * StringUtils.isBlank("bob")     = false
   * StringUtils.isBlank("  bob  ") = false
   * </pre>
   *
   * @param str the String to check, may be null
   * @return <code>true</code> if the String is null, empty or whitespace
   */
  public static boolean isNotBlank(String str) {
    return !isBlank(str);
  }

  /**
   * Determine whether the given array is empty: i.e. {@code null} or of zero length.
   *
   * @param array the array to check
   */
  public static boolean isNotEmpty(Object[] array) {
    return !isEmpty(array);
  }

  /**
   * Check whether the given String is empty.
   * <p>
   * This method accepts any Object as an argument, comparing it to {@code null} and the empty
   * String. As a consequence, this method will never return {@code true} for a non-null non-String
   * object.
   * <p>
   * The Object signature is useful for general attribute handling code that commonly deals with
   * Strings but generally has to iterate over Objects since attributes may e.g. be primitive value
   * objects as well.
   *
   * @param str the candidate String
   */
  public static boolean isNotEmpty(Object str) {
    return !isEmpty(str);
  }

  /**
   * <p>
   * Checks if a String is empty ("") or null.
   * </p>
   *
   * <pre>
   * StringUtils.isEmpty(null)      = true
   * StringUtils.isEmpty("")        = true
   * StringUtils.isEmpty(" ")       = false
   * StringUtils.isEmpty("bob")     = false
   * StringUtils.isEmpty("  bob  ") = false
   * </pre>
   *
   * <p>
   * NOTE: This method changed in Lang version 2.0. It no longer trims the String. That
   * functionality is available in isBlank().
   * </p>
   *
   * @param str the String to check, may be null
   * @return <code>true</code> if the String is empty or null
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

  public static boolean isNotEmpty(List<?> array) {
    return !isEmpty(array);
  }

  public static boolean isNotEmpty(Map<?, ?> map) {
    return !isEmpty(map);
  }
}
