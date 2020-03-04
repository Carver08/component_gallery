package com.login.service;

public interface MailService {

    /*
    发送文本邮件
     */
//    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件，方便用户点击附带的code用来验证激活账户
     * @param to
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

}
