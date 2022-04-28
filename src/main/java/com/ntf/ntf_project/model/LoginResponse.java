package com.ntf.ntf_project.model;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 登录返回实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String token;

  private Date expiresTime;

  private User user;

}
