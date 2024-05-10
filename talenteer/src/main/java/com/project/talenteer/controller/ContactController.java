package com.project.talenteer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Contact;
import com.project.talenteer.service.ContactService;


@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

    @Autowired
    private ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @PostMapping("/save")
    public DataResult<Contact> saveContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping("/{id}")
    public DataResult<Contact> getContactById(@PathVariable int id) {
        return contactService.getContactById(id);
    }
}
