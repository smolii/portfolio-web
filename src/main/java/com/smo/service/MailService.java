package com.smo.service;

public interface MailService {
    void send(String toAddress, String subject, String content);
}
