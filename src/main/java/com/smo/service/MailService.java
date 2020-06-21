package com.smo.service;


import com.sendgrid.Request;
import com.sendgrid.SendGrid;

public interface MailService {
    void send(String toAddress, String subject, String content);
    SendGrid getSendGrid();
    Request getRequest();
}
