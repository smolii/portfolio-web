package com.smo.service;


import com.sendgrid.Request;

public interface MailService {
    void send(String toAddress, String subject, String content);
}
