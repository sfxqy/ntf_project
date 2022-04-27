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
import java.util.logging.Handler;
import javax.annotation.Resource;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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

  /**
   * 获取IBox公告信息
   */
  public void getIboxNotice()throws Exception{
    String data11 = restTemplate.getForObject(IBoxURL.NOTICE_URL, String.class);
    JSONObject data = restTemplateUtil.getData(IBoxURL.NOTICE_URL);
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
    HttpGet httpGet = new HttpGet(IBoxURL.NOTICE_URL);
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
