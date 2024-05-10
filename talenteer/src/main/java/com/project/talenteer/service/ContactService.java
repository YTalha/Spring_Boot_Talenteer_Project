package com.project.talenteer.service;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Contact;

public interface ContactService {
    DataResult<Contact> saveContact(Contact contact);
    DataResult<Contact> getContactById(int id);

}
