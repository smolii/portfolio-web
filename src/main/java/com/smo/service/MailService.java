package com.smo.service;

public interface MailService {

    void send(String fromAddress, String toAddress, String subject, String content) throws Exception;
}
