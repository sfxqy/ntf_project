package com.ntf.ntf_project.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author sfx
 * @Description
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("crm_user")
public class User {


  private String name;

  private String password;

  private String phone;

  private String email;

  private String activationCode;

  /**
   * 1.试用  2.按时间  3.永久
   */
  private Integer useType;

  private Date expirationTime;
}
