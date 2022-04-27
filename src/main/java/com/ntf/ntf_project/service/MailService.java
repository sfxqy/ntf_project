package com.ntf.ntf_project.service;


import com.ntf.ntf_project.constants.MailConstants;
import com.ntf.ntf_project.utils.RestTemplateUtil;
import javax.annotation.Resource;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮件服务
 *
 * @author hjh
 * @Description MailServiceImpl 接口实现
 * @since 2020-11-17
 */
@Data
@Service
@Log4j2
public class MailService {


  @Resource
  private JavaMailSender mailSender;
  @Resource
  private RestTemplateUtil restTemplateUtil;


  /**
   * 发送普通邮件
   *
   * @param to 收件箱
   * @param subject 标题
   * @param content 内容
   */
  public void sendSimpleMail(String to, String subject, String content) throws MailException {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(MailConstants.SEND_EMAIL); // 邮件发送者
    message.setTo(to); // 邮件接受者
    message.setSubject(subject); // 主题
    message.setText(content); // 内容

    mailSender.send(message);
  }


}

