package com.smo.controller;

import com.smo.entite.Contact;
import com.smo.service.MailService;
import com.smo.util.ContactMappings;
import com.smo.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String sendMail(@ModelAttribute Contact contact) {
        try {
            String content = "Name: " + contact.getName();
            content += "<br>Phone: " + contact.getPhoneNumber();
            content += "<br>Email: " + contact.getEmail();
            content += "<br>Message: " + contact.getMessage();
            mailService.send(contact.getEmail(), "smolii@o2.pl", contact.getName(), content);
            Thread.sleep(2500);
        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:" + ContactMappings.HOME_PAGE;
    }

}
