package com.smo.controller;

import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.smo.entite.Contact;
import com.smo.service.MailService;
import com.smo.util.ContactMappings;
import com.smo.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@Slf4j
public class ContactController {

    @Autowired
    private MailService mailService;

    @GetMapping(ContactMappings.HOME_PAGE)
    public String homePage(Model model) {
        model.addAttribute("contact", new Contact());

        return ViewNames.INDEX;
    }



    @PostMapping(ContactMappings.HOME_PAGE)
    public String sendMail(@ModelAttribute Contact contact, ModelMap modelMap) {

        String content = "Name: " + contact.getName() + "\n";
        content += "Phone: " + contact.getPhoneNumber() + "\n";
        content += "Email: " + contact.getEmail() + "\n";
        content += "Message: " + contact.getMessage();
        try {
            mailService.send(contact.getEmail(), contact.getName(), content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:" + ContactMappings.HOME_PAGE;
    }
}
