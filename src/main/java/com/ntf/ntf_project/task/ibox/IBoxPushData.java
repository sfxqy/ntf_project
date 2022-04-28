package com.ntf.ntf_project.task.ibox;

import com.ntf.ntf_project.service.ibox.IBoxDataService;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author sfx
 * @Description
 */

@Log4j2
@Component
@Configuration //读取配置
@EnableScheduling // 2.开启定时任务
public class IBoxPushData {

  @Resource
  private IBoxDataService boxDataService;

  @PostConstruct
  @Scheduled(cron = "*/10 * * * * *") //1分钟同步一次数据
  public void pushNotice()throws Exception{
    try {
      boxDataService.getIboxNotice();
    }catch (Exception e){
      e.printStackTrace();
    }

  }
}
