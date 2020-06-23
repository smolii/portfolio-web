package com.smo.service;


import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Value("app.sendgrid.templateId")
    private String templateId;

    @Autowired
    private SendGrid sendGrid;

    private Request request;

    @Override
    public void send(String toAddress, String subject, String content) {
        Email from = new Email("start800m@gmail.com");
        Email to = new Email(toAddress);
        Content text = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, to, text);
        Personalization personalization = new Personalization();
        personalization.addTo(to);
        mail.setTemplateId(templateId);
        this.request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
