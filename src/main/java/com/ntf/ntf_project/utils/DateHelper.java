package com.ntf.ntf_project.utils;

import com.ntf.ntf_project.constants.Constants;
import java.lang.ref.SoftReference;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

/**
 * 日期格式化
 */
@Log4j2
public class DateHelper {

  private static final long ONE_MINUTE = 60000L;
  private static final long ONE_HOUR = 3600000L;
  private static final long ONE_DAY = 86400000L;
  private static final long ONE_WEEK = 604800000L;

  private static final String ONE_SECOND_AGO = "秒前";
  private static final String ONE_MINUTE_AGO = "分钟前";
  private static final String ONE_HOUR_AGO = "小时前";
  private static final String ONE_DAY_AGO = "天前";
  private static final String ONE_MONTH_AGO = "月前";
  private static final String ONE_YEAR_AGO = "年前";
  private static final String TODAY_EXT = "今天";
  private static final String YESTODAY_EXT = "昨天";
  private static final String MORNING = "上午";
  private static final String AFTERNOON = "下午";

  public static final String LONG_FORMAT="yyyy-MM-dd HH:mm:ss";

  /**
   * 返回日期格式的字符串
   */
  public static String formatDateBySpecified(String dateStr, String format) {
    HashMap<String, String> dateRegFormat = new HashMap<>();
    dateRegFormat.put("\\w{3}\\s\\w{3}\\s\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s+\\w+\\s+\\d{4}",
        "EEE MMM dd HH:mm:ss Z yyyy");
    dateRegFormat.put("\\d{4}年\\d{1,2}月\\d{1,2}日", "yyyy年MM月dd");
    dateRegFormat.put("\\d{4}-\\d{1,2}-\\d{1,2}", "yyyy-MM-dd");
    dateRegFormat.put("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}\\.\\d{6}",
        "yyyy-MM-dd");
    dateRegFormat.put("\\w{3}\\s\\w{1,2},\\s\\d{4}\\s\\d{2}:\\d{2}:\\d{2}\\s\\w{2}",
        "MMM dd, yyyy hh:mm:ss a");
    dateRegFormat.put("\\d{4}-\\d{1,2}-\\d{1,2}T\\d{2}:\\d{2}:\\d{2}", "yyyy-MM-dd'T'HH:mm:ss");
    dateRegFormat.put("\\d{8}", "yyyyMMdd");
    DateFormat ress_form = new SimpleDateFormat(format);
    String strSuccess = null;
    DateFormat oldForm = null;
    try {
      for (String key : dateRegFormat.keySet()) {
        if (Pattern.compile(key).matcher(dateStr).matches()) {
          if ("\\w{3}\\s\\w{3}\\s\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s+\\w+\\s+\\d{4}".equals(key)) {
            oldForm = new SimpleDateFormat(dateRegFormat.get(key), Locale.UK);
          } else if ("\\w{3}\\s\\w{1,2},\\s\\d{4}\\s\\d{2}:\\d{2}:\\d{2}\\s\\w{2}".equals(key)) {
            oldForm = new SimpleDateFormat(dateRegFormat.get(key), Locale.ENGLISH);
          } else {
            oldForm = new SimpleDateFormat(dateRegFormat.get(key));
          }
          strSuccess = ress_form.format(oldForm.parse(dateStr));
          break;
        }
      }
    } catch (Exception e) {
      return null;
    }
    return strSuccess;
  }

  /**
   * 系统时间戳
   */
  public static String currentTimestamp() {
    return "" + System.currentTimeMillis();
  }

  /**
   * yyyyMMddHHmmss
   */
  public static String currentTimeMillis0() {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssms");
    return format.format(new Date());
  }

  /**
   * yyMMddHHmmss
   */
  public static String currentTimeMillis1() {
    SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
    return format.format(new Date());
  }

  /**
   * yyyy/MM/dd HH:mm:ss
   */
  public static String currentTimeMillis2() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    return format.format(new Date());
  }

  /**
   * yy/MM/dd HH:mm:ss
   */
  public static String currentTimeMillis3() {
    SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
    return format.format(new Date());
  }

  /**
   * yyyy/MM/dd HH:mm:ss.sss
   */
  public static String currentTimeMillis4() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
    return format.format(new Date());
  }

  /**
   * yy/MM/dd HH:mm:ss.sss
   */
  public static String currentTimeMillis5() {
    SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss.sss");
    return format.format(new Date());
  }

  /**
   * yyyy-MM-dd HH:mm:ss
   */
  public static String currentTimeMillisCN1() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return format.format(new Date());
  }

  /**
   * yy-MM-dd HH:mm:ss
   */
  public static String currentTimeMillisCN2() {
    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    return format.format(new Date());
  }

  /**
   * yyyy-MM-dd
   */
  public static String currentTimeMillisCN3() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return format.format(new Date());
  }

  /**
   * 当前时间减一天 yyyy-MM-dd
   */
  public static String currentTimeMillisCN7() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return format.format(calendar.getTime());
  }

  /**
   * 当前时间减N天 yyyy-MM-dd n 减多少天
   */
  public static String currentTimeMillisCN7(int n) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DAY_OF_MONTH, n);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return format.format(calendar.getTime());
  }

  /**
   * yy-MM-dd
   */
  public static String currentTimeMillisCN4() {
    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
    return format.format(new Date());
  }

  /**
   * yyyy-MM-dd HH:mm:ss.sss
   */
  public static String currentTimeMillisCN5() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
    return format.format(new Date());
  }

  /**
   * yy-MM-dd HH:mm:ss.sss
   */
  public static String currentTimeMillisCN6() {
    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss.sss");
    return format.format(new Date());
  }

  /**
   * yyMMdd
   */
  public static String currentDate1() {
    SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
    return format.format(new Date());
  }

  /**
   * yy/MM/dd
   */
  public static String currentDate2() {
    SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
    return format.format(new Date());
  }

  /**
   * yyyyMMdd
   */
  public static String currentDate3() {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    return format.format(new Date());
  }

  /**
   * yyyy/MM/dd
   */
  public static String currentDate4() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    return format.format(new Date());
  }

  /**
   * HHmmss
   */
  public static String currentTime1() {
    SimpleDateFormat format = new SimpleDateFormat("HHmmss");
    return format.format(new Date());
  }

  /**
   * HH:mm:ss
   */
  public static String currentTime2() {
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    return format.format(new Date());
  }

  /**
   * HH:mm:ss
   */
  public static String customTime(String formatType) {
    SimpleDateFormat format = new SimpleDateFormat(formatType);
    return format.format(new Date());
  }

  public static String customTime(Date date, String formatType) {
    SimpleDateFormat format = new SimpleDateFormat(formatType);
    return format.format(date);
  }

  public static Date strDateToDate(String date, String formatType) throws Exception {
    SimpleDateFormat format = new SimpleDateFormat(formatType);
    return format.parse(date);
  }

  public static Long getCurrentTimeByDate(String date) {
    return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).
        parse(date, new ParsePosition(0)).getTime() / 1000;
  }

  /**
   * 两个日期相差多少秒
   */
  public static int getTimeDelta(Date date1, Date date2) {
    // 单位是秒
    long timeDelta = (date1.getTime() - date2.getTime()) / 1000;
    return timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
  }

  /**
   * 两个日期相差多少秒
   */
  public static int getTimeDelta(Calendar date1, Calendar date2) {
    // 单位是秒
    long timeDelta = (date1.getTimeInMillis() - date2.getTimeInMillis()) / 1000;
    return timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
  }

  /**
   * 日期转化
   *
   * @param date 日期字符串
   */
  public static Calendar getCalendar(String date) {
    Calendar c = Calendar.getInstance();
    date = date.replaceAll("[\\.\\-\\年\\月]", "/").replace("日", "");
    String[] d = date.split("/");
    c.set(Integer.parseInt(d[0]), Integer.parseInt(d[1]) - 1, Integer.parseInt(d[2]));
    return c;
  }

  /**
   * 日期转化
   *
   * @param date       日期字符串
   * @param formatType 日期格式
   */
  public static Calendar getCalendar(String date, String formatType) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat(formatType);

    Calendar c = Calendar.getInstance();
    c.setTimeInMillis(sdf.parse(date).getTime());
    return c;
  }

  /**
   *
   */
  public static java.sql.Date getSQLDate(String date) throws Exception {
    return new java.sql.Date(getCalendar(date).getTimeInMillis());
  }

  public static String getSQLDate(String date, String formatType) throws Exception {
    return customTime(getSQLDate(date), formatType);
  }

  public static String getDate(String date, String formatType) throws Exception {
    return customTime(getDate(date), formatType);
  }

  /**
   * 日期转换<br> 20151111日<br> 2015.6.19<br> 2015/6/19 <br> 2015-6-19 <br> 2015年11月11日<br>
   */
  public static Date getDate(String date) {
    Calendar c = Calendar.getInstance();
    try {
      if (date.length() == 8) {
        c.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
            Integer.parseInt(date.substring(6, 8)));
      } else {
        c = getCalendar(date);
      }
    } catch (Exception e) {
      return null;
    }
    return c.getTime();
  }

  /**
   * 日期计算
   */
  public static String getDateAdd(int field, int amount) throws Exception {
    return getDateAdd(new Date(), field, amount);
  }

  /**
   * 日期计算 {@link Calendar#()}
   */
  public static String getDateAdd(Date date, int field, int amount) throws Exception {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(field, amount);
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    return format.format(cal.getTime());
  }

  public static String getDateAdd2(Date date, int field, int amount) throws Exception {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(field, amount);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return format.format(cal.getTime());
  }

  /**
   * 时间转字符串 yyyy-MM-dd
   */
  public static String dateToString(Date date) {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return format.format(date);

  }

  public static int getDaysBetween(Date fDate, Date oDate) {
    Calendar aCalendar = Calendar.getInstance();
    aCalendar.setTime(fDate);
    int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
    aCalendar.setTime(oDate);
    int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
    return day2 - day1;
  }

  /**
   * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
   *
   * @param nowTime   当前时间
   * @param startTime 开始时间
   * @param endTime   结束时间
   * @author jqlin
   */
  public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
    if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
      return true;
    }

    Calendar date = Calendar.getInstance();
    date.setTime(nowTime);

    Calendar begin = Calendar.getInstance();
    begin.setTime(startTime);

    Calendar end = Calendar.getInstance();
    end.setTime(endTime);

    if (date.after(begin) && date.before(end)) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * 获取今日的剩余时间，返回值单位：秒
   *
   * @return long
   */
  public static Long getSurplusTime() {
    Calendar c = Calendar.getInstance();
    long now = c.getTimeInMillis();
    c.add(Calendar.DAY_OF_MONTH, 1);
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);
    long millis = c.getTimeInMillis() - now + 2000;

    return millis / 1000;
  }

  /**
   * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致String yyyy-MM-dd HH:mm:ss
   *
   * @param nowTime_   当前时间
   * @param startTime_ 开始时间
   * @param endTime_   结束时间
   * @author jqlin
   */
  public static boolean isEffectiveDateString(String nowTime_, String startTime_, String endTime_)
      throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date nowTime = sdf.parse(nowTime_);
    Date startTime = sdf.parse(startTime_);
    Date endTime = sdf.parse(endTime_);
    if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
      return true;
    }
    Calendar date = Calendar.getInstance();
    date.setTime(nowTime);
    Calendar begin = Calendar.getInstance();
    begin.setTime(startTime);
    Calendar end = Calendar.getInstance();
    end.setTime(endTime);
    if (date.after(begin) && date.before(end)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 得到 年月的最后一天
   */
  public static int getMaxDayOfMonth(int year, int month) {
    Calendar date = Calendar.getInstance();
    date.set(Calendar.YEAR, year);
    date.set(Calendar.MONTH, month - 1);
    return date.getActualMaximum(Calendar.DATE);
  }

  /**
   * 指定时间前几月的时间,或者指定时间后几月的时间yyyy-MM-dd HH:mm:ss
   *
   * @param time   yyyy-MM-dd HH:mm:ss
   * @param amount 正为后,负为几月前
   * @return yyyy-MM-dd HH:mm:ss
   */
  public static String getDateMonth(String time, int amount) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date dNow = sdf.parse(time);
      // 得到日历
      Calendar calendar = Calendar.getInstance();
      // 把当前时间赋给日历
      calendar.setTime(dNow);
      // 设置为前3月
      calendar.add(Calendar.MONTH, amount);
      // 得到前3月的时间
      Date dBefore = calendar.getTime();
      // 格式化前3月的时间
      return sdf.format(dBefore);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String format(String date) throws ParseException {
    Date dateStr = getStringToDate(date);
    long delta = new Date().getTime() - dateStr.getTime();
    if (delta < ONE_MINUTE) {
      long seconds = toSeconds(delta);
      return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
    }
    if (delta < 45L * ONE_MINUTE) {
      long minutes = toMinutes(delta);
      return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
    }
    if (delta < 24L * ONE_HOUR) {
      long hours = toHours(delta);
      return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
    }
    if (delta < 48L * ONE_HOUR) {
      SimpleDateFormat format = new SimpleDateFormat("HH:mm");
      return "昨天 " + format.format(dateStr);
    } else {
      long years = toYears(delta);
      String formatType = years > 1 ? "yyyy-MM-dd HH:mm" : "MM-dd HH:mm";
      SimpleDateFormat format = new SimpleDateFormat(formatType);
      return format.format(dateStr);
    }
  }

  private static long toSeconds(long date) {
    return date / 1000L;
  }

  private static long toMinutes(long date) {
    return toSeconds(date) / 60L;
  }

  private static long toHours(long date) {
    return toMinutes(date) / 60L;
  }

  private static long toDays(long date) {
    return toHours(date) / 24L;
  }

  private static long toMonths(long date) {
    return toDays(date) / 30L;
  }

  private static long toYears(long date) {
    return toDays(date) / 365L;
  }

  private static Date getStringToDate(String dateStr) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.parse(dateStr);
  }

  // 将字符串转为时间戳
  public static String getCurrentTime(String user_time, String type) {
    String re_time = null;
    SimpleDateFormat sdf = new SimpleDateFormat(type);
    Date d;
    try {
      d = sdf.parse(user_time);
      long l = d.getTime();
      String str = String.valueOf(l);
      re_time = str.substring(0, 10);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return re_time;
  }

  /**
   * 获取当前时间戳
   *
   * @return String
   */
  public static String getNowCurrentTime(Long per) {
    Long time = new Date().getTime() + per;
    String str = String.valueOf(time);

    return str.substring(0, 10);
  }

  /**
   * 2016-11-08 14:39:38 pattern yyyy-MM-dd HH:mm:ss
   */
  public static String showDate(String paramDate, String pattern) throws ParseException {
    Date date = getStringToDate(paramDate);
    if (pattern == null) {
      pattern = "yyyy-MM-dd HH:mm";
    }
    String yewTerDay = getYesTerDay();
//    String dateStr = formatNew(date, pattern);
    String dateStrNew = formatNew(date, "yyyy-MM-dd");
//    String year = formatNew(date, "yyyy");
//    int day = Integer.parseInt(dateStr.substring(8, 10));
    long addtime = date.getTime();
    long today = System.currentTimeMillis();
    Date now = new Date(today);
    String nowStr = formatNew(now, pattern);
    String nowDay = nowStr.substring(0, 10);
//    String nowYear = formatNew(now, "yyyy");
    String result = "";
    //当前时间与给定时间差的毫秒数
    long l = today - addtime;
    //这个时间相差的天数整数，大于1天为前天的时间了，小于24小时则为昨天和今天的时间
    long days = l / (24 * 60 * 60 * 1000);
    //这个时间相差的减去天数的小时数
    long hours = (l / (60 * 60 * 1000) - days * 24);
    long min = ((l / (60 * 1000)) - days * 24 * 60 - hours * 60);
    long s = (l / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - min * 60);
    if (dateStrNew.equals(yewTerDay)) {
      result = "昨天 " + formatNew(date, "HH:mm");
    } else if (dateStrNew.equals(nowDay)) {
      if (hours > 0) {
        result = hours + " 小时前";
      } else if (min > 0) {
        result = min + " 分钟前";
      } else {
        result = s + " 秒前";
      }
    } else {
      String formatType = "";
      formatType = "yyyy-MM-dd HH:mm";
      result = formatNew(date, formatType);
    }

    return result;
  }

  /**
   * 2016-11-08 14:39:38 pattern yyyy-MM-dd HH:mm:ss
   */
  public static String showDateForEn(String paramDate, String pattern) throws ParseException {
    Date date = getStringToDate(paramDate);
    if (pattern == null) {
      pattern = "yyyy-MM-dd HH:mm";
    }
    String yewTerDay = getYesTerDay();
//    String dateStr = formatNew(date, pattern);
    String dateStrNew = formatNew(date, "yyyy-MM-dd");
//    String year = formatNew(date, "yyyy");
//    int day = Integer.parseInt(dateStr.substring(8, 10));
    long addtime = date.getTime();
    long today = System.currentTimeMillis();
    Date now = new Date(today);
    String nowStr = formatNew(now, pattern);
    String nowDay = nowStr.substring(0, 10);
//    String nowYear = formatNew(now, "yyyy");
    String result = "";
    //当前时间与给定时间差的毫秒数
    long l = today - addtime;
    //这个时间相差的天数整数，大于1天为前天的时间了，小于24小时则为昨天和今天的时间
    long days = l / (24 * 60 * 60 * 1000);
    //这个时间相差的减去天数的小时数
    long hours = (l / (60 * 60 * 1000) - days * 24);
    long min = ((l / (60 * 1000)) - days * 24 * 60 - hours * 60);
    long s = (l / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - min * 60);
    if (dateStrNew.equals(yewTerDay)) {
      SimpleDateFormat format = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH);
      result = format.format(date);
      result = "Yesterday " + result;
    } else if (dateStrNew.equals(nowDay)) {
      String head = "Updated ";
      if (hours > 0) {
        result = hours + (hours == 1 ? " hour" : " hours") + " ago";
      } else if (min > 0) {
        result = min + (min == 1 ? " min" : " mins") + " ago";
      } else {
        result = s + (s == 1 ? " second" : " seconds") + " ago";
      }
      result = head + result;
    } else {
      String formatType = "MMM dd, yyyy hh:mm aa";
      SimpleDateFormat format = new SimpleDateFormat(formatType, Locale.ENGLISH);
      result = format.format(date);
    }

    return result;
  }

  /**
   * 2016-11-08 14:39:38 pattern yyyy-MM-dd HH:mm:ss
   */
  public static String showDateEn(String paramDate) throws ParseException {
    Date date = getStringToDate(paramDate);
    String formatType = "MMM dd, yyyy";
    SimpleDateFormat format = new SimpleDateFormat(formatType, Locale.ENGLISH);

    return format.format(date);
  }

  public static String showDate(Date date) {
    String dateStr = formatNew(date, "yyyy-MM-dd HH:mm:ss");
    try {
      return showDate(dateStr, null);
    } catch (ParseException e) {
      e.printStackTrace();
      return StringUtils.EMPTY;
    }
  }

  /**
   * 获取当前日期,指定格式 描述:<描述函数实现的功能>.
   *
   * @return Date
   */
  public static Date nowDateTimeReturnDate(String DATE_FORMAT) {
    SimpleDateFormat dft = new SimpleDateFormat(DATE_FORMAT);
    return strToDate(dft.format(new Date()), DATE_FORMAT);
  }

  /**
   * parse a String to Date in a specifies fromat.
   *
   * @param dateStr     日期
   * @param DATE_FORMAT 格式
   * @return Date
   */
  public static Date strToDate(String dateStr, String DATE_FORMAT) {
    SimpleDateFormat myFormat = new SimpleDateFormat(DATE_FORMAT);
    try {
      return myFormat.parse(dateStr);
    } catch (ParseException e) {
      return null;
    }
  }

  /**
   * 获取当前日期,指定格式 描述:<描述函数实现的功能>.
   *
   * @return String
   */
  public static Integer getNowTime() {
    long t = (System.currentTimeMillis() / 1000L);
    return Integer.parseInt(String.valueOf(t));
  }

  /**
   * 获取当前日期,指定格式 描述:<描述函数实现的功能>.
   *
   * @return Date
   */
  public static Date nowDateTime() {
    return strToDate(nowDateTimeStr(), Constants.DATE_FORMAT);
  }

  /**
   * 获取当前日期,指定格式 描述:<描述函数实现的功能>.
   *
   * @return
   */
  public static String nowDateTime(String DATE_FORMAT) {
    SimpleDateFormat dft = new SimpleDateFormat(DATE_FORMAT);
    return dft.format(new Date());
  }

  /**
   * 获取当前日期,指定格式 描述:<描述函数实现的功能>.
   *
   * @return String
   */
  public static String nowDateTimeStr() {
    return nowDate(Constants.DATE_FORMAT);
  }

  /**
   * 获取当前日期,指定格式 描述:<描述函数实现的功能>.
   *
   * @return String
   */
  public static String nowDate(String DATE_FORMAT) {
    SimpleDateFormat dft = new SimpleDateFormat(DATE_FORMAT);
    return dft.format(new Date());
  }

  /**
   * date add Second
   *
   * @param date Date
   * @param num  int
   * @return Date
   */
  public static Date addSecond(Date date, int num) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.SECOND, num);
    return calendar.getTime();
  }

  //获取时间戳11位
  public static int getSecondTimestamp() {
    Date date = strToDate(nowDateTime(Constants.DATE_FORMAT), Constants.DATE_FORMAT);
    if (null == date) {
      return 0;
    }
    String timestamp = String.valueOf(date.getTime() / 1000);
    return Integer.parseInt(timestamp);
  }

  /**
   * 日期格式化
   *
   * @param date    需要格式化的日期
   * @param pattern 时间格式，如：yyyy-MM-dd HH:mm:ss
   * @return 返回格式化后的时间字符串
   */
  public static String formatNew(Date date, String pattern) {
    SimpleDateFormat formatter = DateFormatHolder.formatFor(pattern);
    return formatter.format(date);
  }

  private static String getYesTerDay() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    Date d = cal.getTime();
    SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
    return sp.format(d);
  }

  public static boolean isToday(long time) {
    return isThisTime(time, "yyyy-MM-dd");
  }

  public static boolean isThisTime(long time, String pattern) {
    Date date = new Date(time);
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    String param = sdf.format(date);
    String now = sdf.format(new Date());
    if (param.equals(now)) {
      return true;
    }
    return false;
  }

  /**
   * 获得当日上下午,以及当日前的时间显示 dateString  "yyyy-MM-dd HH:mm:ss"
   *
   * @return "上午"07;45   yyyy/MM/dd HH:mm  2020/07/25 12:06
   */
  public static String getConversionDate(String dateString) throws ParseException {
    if (EmptyHelper.isNotEmpty(dateString)) {
      if (dateString.length() <= 16) {
        return dateString;
      }
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date = sdf.parse(dateString);
      boolean flag = isToday(date.getTime());
      if (flag) {
        String c = dateString.substring(11, 16);
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str = df.format(date);
        int a = Integer.parseInt(str);
        if (a >= 0 && a <= 12) {
          return MORNING + c;
        }
        if (a > 12 && a <= 24) {
          return AFTERNOON + c;
        }
      } else {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return format.format(date);
      }
    }
    return "";
  }

  /**
   * 将日期格式转化. dateString  "yyyy-MM-dd HH:mm:ss"
   *
   * @return yyyy/MM/dd HH:mm  2020/07/25 12:06
   */
  public static String getConversionDateStr(String dateString) throws ParseException {
    if (EmptyHelper.isNotEmpty(dateString)) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date = sdf.parse(dateString);
      SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
      return format.format(date);
    }
    return "";
  }

  //将时间戳转换为时间
  public static String stampToDate(String s) {
    String res;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long lt = Long.parseLong(s);
    res = simpleDateFormat.format(lt * 1000L);
    return res;
  }

  public static String timestamp2String(long time, String pattern) {
    SimpleDateFormat formatter = DateFormatHolder.formatFor(pattern);
    return formatter.format(time);
  }

  /**
   *获取N小时之前的时间
   * @param hour
   * @return
   */
  public static Date getBeforeByHourTime(Integer hour){
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
    return calendar.getTime();
  }


  /**
   * 获取N小时之后的时间
   * @param hour
   * @return
   */
  public static Date getAfterByHourTime(Integer hour){
    return getBeforeByHourTime(-hour);
  }

  static final class DateFormatHolder {

    private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>
        THREADLOCAL_FORMATS = new ThreadLocal<>();

    DateFormatHolder() {
    }

    public static SimpleDateFormat formatFor(String pattern) {
      SoftReference<Map<String, SimpleDateFormat>> ref = THREADLOCAL_FORMATS.get();
      Map<String, SimpleDateFormat> formats = ref == null ? null : ref.get();
      if (formats == null) {
        formats = new HashMap<>();
        THREADLOCAL_FORMATS.set(new SoftReference<>(formats));
      }
      return formats
          .computeIfAbsent(pattern, key -> new SimpleDateFormat(pattern));
    }

    public static void clearThreadLocal() {
      THREADLOCAL_FORMATS.remove();
    }
  }

  public static Date getBeginDateOfSpecifiedDay(Date date,Integer day){
    Calendar c =  Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.DATE, day);
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    return c.getTime();
  }


  /**
   * 指定时间day天之前(后)的时间
   * @param now
   * @param format
   * @return
   */
  public static String dayAddStr(Integer day,String now,String format){
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    String datastr = null;
    try {
      Date d = sdf.parse(now);
      Calendar ca = Calendar.getInstance();
      ca.setTime(d);
      ca.set(ca.get(Calendar.YEAR),ca.get(Calendar.MONTH),ca.get(Calendar.DAY_OF_MONTH)+day);
      datastr = sdf.format(ca.getTime());
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return datastr;
  }


  public static Date dayAdd(Integer day,String now,String format){
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    Calendar ca=null;
    try {
      Date d = sdf.parse(now);
      ca = Calendar.getInstance();
      ca.setTime(d);
      ca.set(ca.get(Calendar.YEAR),ca.get(Calendar.MONTH),ca.get(Calendar.DAY_OF_MONTH)+day);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return ca.getTime();
  }

  public static Date getDayBegin() {
    Calendar cal = new GregorianCalendar();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal.getTime();
  }

  public static Date getDayEnd() {
    Calendar cal = new GregorianCalendar();
    cal.set(Calendar.HOUR_OF_DAY, 23);
    cal.set(Calendar.MINUTE, 59);
    cal.set(Calendar.SECOND, 59);
    return cal.getTime();
  }

  public static Date getBeforeByMinuteTime(Integer minute){
    Calendar beforeTime = Calendar.getInstance();
    beforeTime.add(Calendar.MINUTE, -minute);
    return beforeTime.getTime();
  }


  public static Date getBeginDayOfNDay(int day) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(getDayBegin());
    cal.add(Calendar.DAY_OF_MONTH, day);
    return cal.getTime();
  }

  public static Date getEndDayOfNDay(int day) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(getDayEnd());
    cal.add(Calendar.DAY_OF_MONTH, day);
    return cal.getTime();
  }


  /**
   *
   * @param year 多少年前  0表示当年  正为向后  负为向前
   * @param month 多少个月前  0表示当月  正为向后  负为向前
   * @return
   */
  public static Date getMonthStartTime(int year,int month) {
    Long currentTime = System.currentTimeMillis();
    String timeZone = "GMT+8:00";
    Calendar calendar = Calendar.getInstance();// 获取当前日期
    calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
    calendar.setTimeInMillis(currentTime);
    calendar.add(Calendar.YEAR, year);
    calendar.add(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }


  /**
   *
   * @param year 多少年前  0表示当年  正为向后  负为向前
   * @param month 多少个月前  0表示当月  正为向后  负为向前
   * @return
   */
  public static Date getMonthEndTime(int year,int month) {
    Long currentTime = System.currentTimeMillis();
    String timeZone = "GMT+8:00";
    Calendar calendar = Calendar.getInstance();// 获取当前日期
    calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
    calendar.setTimeInMillis(currentTime);
    calendar.add(Calendar.YEAR, year);
    calendar.add(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 获取当前月最后一天
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return calendar.getTime();
  }

}
