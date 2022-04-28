package com.ntf.ntf_project.service.ibox;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ntf.ntf_project.constants.IBoxURL;
import com.ntf.ntf_project.constants.MailConstants;
import com.ntf.ntf_project.constants.ibox.IBoxCode;
import com.ntf.ntf_project.model.ibox.Notice;
import com.ntf.ntf_project.service.MailService;
import com.ntf.ntf_project.utils.DateHelper;
import com.ntf.ntf_project.utils.RestTemplateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import javax.annotation.Resource;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author sfx
 * @Description
 */

@Service
public class IBoxDataService {


  @Resource
  private MailService mailService;
  @Resource
  private RestTemplateUtil restTemplateUtil;
  @Resource
  private RestTemplate restTemplate;



  public void login()throws Exception{
//		配置本地浏览器驱动路径
    System.getProperties().setProperty("webdriver.chrome.driver", "C:\\Users\\SFX\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//		创建浏览器对象
    ChromeDriver chromeDriver = new ChromeDriver();
//		设置浏览器窗口最大化
    chromeDriver.manage().window().maximize();
//		设置需要操作的网页url
    chromeDriver.get("https://www.ibox.art/zh-cn/");
//		设置隐式等待时间，根据目标网页的响应速度设置超时时间
    chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    chromeDriver.findElement(By.xpath("//*[@id=\"__layout\"]/section/header/div[1]/div[5]/div[1]")).click();

    //滑块
   // WebElement  slider= chromeDriver.findElement(By.cssSelector("#nc_1_n1z"));
    WebElement  slider= chromeDriver.findElementByCssSelector("#nc_1_n1z");

    //滑动槽
    //WebElement element = chromeDriver.findElement(By.cssSelector("#nc_1_n1t"));
    WebElement element = chromeDriver.findElementByCssSelector("#nc_1__scale_text");
    element.getSize().getWidth();
    element.getSize().getHeight();
    Actions actions = new Actions(chromeDriver);
    actions.dragAndDropBy(slider,element.getSize().getWidth()/2,element.getSize().getHeight()).perform();
    Thread.sleep(2000);
    actions.dragAndDropBy(slider,element.getSize().getWidth()+1,element.getSize().getHeight()).perform();

  /*  chromeDriver.findElement(By.cssSelector("##__layout > section > header > div.inner > div.wallet-button > div:nth-child(1)"))
    for (String pho : phoNumList) {
      try {
        //防止访问太快休息一秒
        Thread.sleep(1000l);
//		使用css定位手机号的输入框
        WebElement inputPhoNum = chromeDriver.findElement(By.cssSelector("form>section>input"));
//		清除输入框内容
        inputPhoNum.clear();
//		输入手机号
        inputPhoNum.sendKeys(pho);
//		休息一秒
        Thread.sleep(1000l);
//		使用css定位获取验证码的按钮并完成点击
        chromeDriver.findElement(By.cssSelector("form>section>button")).click();
//		这时js会加载拖动验证的滑块，休息两秒
        Thread.sleep(2000l);
//		使用ID定位js加载出来的滑动验证
        WebElement slideCode = chromeDriver.findElementById("nc_1_n1z");
//		获取节点坐标对象
        Point point = slideCode.getLocation();
//		创建按键模拟的对象
        Actions action = new Actions(chromeDriver);
        Thread.sleep(1000l);
//		模拟鼠标点击拖动滑块完成验证
        action.dragAndDropBy(slideCode, point.x + 170, point.y).perform();
//		使用封装的获取短信验证码的工具
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("PhoNum", pho);
        String smsCode = getSmsCode(map);
//		判断是否获取到短信验证码，否则切换手机号
        if (smsCode == "" || smsCode == null) {
          continue;
        }
//		使用cssh定位短信验证码输入框
        Thread.sleep(1000l);
        WebElement vCode = chromeDriver.findElement(By.cssSelector("[placeholder=验证码]"));
//		输入短信验证码
        vCode.sendKeys(smsCode);
        Thread.sleep(1000l);
//		使用class定位登录按钮位置
        WebElement loginBtn = chromeDriver.findElementByClassName("SubmitButton-2wG4T");
//		点击登录
        loginBtn.click();
//		获取已登录的cookie
        Set<Cookie> cookies = chromeDriver.manage().getCookies();
        for (Cookie ck : cookies) {
          System.out.println(ck);
        }

      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }finally {
//		所有操作执行完成，关闭浏览器
        chromeDriver.close();
      }
    }
*/

  }

  /**
   * 获取IBox公告信息
   */
  public void getIboxNotice()throws Exception{
    String data11 = restTemplate.getForObject(IBoxURL.HOME_PAGE, String.class);
    JSONObject data = restTemplateUtil.getData(IBoxURL.HOME_PAGE);
   // String data = restTemplate.getForObject(IBoxURL.NOTICE_URL, String.class);
    System.out.println(data);
    Integer code = (Integer) data.get("code");
    if ( code!=IBoxCode.SUCCESS_CODE){
      mailService.sendSimpleMail(MailConstants.MY_EMAIL,"公告模块报警","拉取iBox数据异常");
    }
    LinkedHashMap datas = (LinkedHashMap)data.get("data");
  //  LinkedHashMap dataMap = (LinkedHashMap)datas.get("list");
    List<LinkedHashMap> noticesList = (ArrayList<LinkedHashMap>)datas.get("list");
   // Object notices = JSON.parseObject(list).get("list");
  //  List<Notice> noticesList = JSON.parseArray((String) notices, Notice.class);
    StringBuilder stringBuilder = new StringBuilder();
    noticesList.forEach(x->{
      stringBuilder.append(x.get("id"));
      stringBuilder.append(x.get("noticeName"));
      stringBuilder.append(DateHelper.customTime(new Date((Long) x.get("noticeTime")),DateHelper.LONG_FORMAT));
    });
    mailService.sendSimpleMail(MailConstants.MY_EMAIL,"IBox最新公告提醒","IBox最新公告提醒");
  }



  public void getIboxNotice1()throws Exception{
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet("https://api-h5.ibox.art/nft-mall-web/v1.2/nft/product/getNoticeList");
    CloseableHttpResponse response = null;
    try {
      response = httpClient.execute(httpGet);
      if (response.getStatusLine().getStatusCode()==200){
        String s = EntityUtils.toString(response.getEntity());
        System.out.println(s);

      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      if (response!=null){
        response.close();
      }
    }

  }





}
