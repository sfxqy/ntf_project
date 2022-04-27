package com.ntf.ntf_project.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class NtfException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * 错误码
   */
  private Long code;

  public NtfException() {
  }

  public NtfException(String message) {
    super(message);
  }

  public NtfException(Long code, String message) {
    super(message);
    this.code = code;
  }

  public Long getCode() {
    return code;
  }
}
