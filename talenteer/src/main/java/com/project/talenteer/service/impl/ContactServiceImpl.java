package com.project.talenteer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.repository.UserRepository;
import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.ErrorDataResult;
import com.project.talenteer.core.utilities.result.SuccessDataResult;
import com.project.talenteer.model.entity.Contact;
import com.project.talenteer.repository.ContactRepository;
import com.project.talenteer.service.ContactService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

    public ContactServiceImpl(ContactRepository contactRepository, UserRepository userRepository){
        this.contactRepository= contactRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<Contact> saveContact(Contact contact) {
    // Gelen contact nesnesinin içindeki userId'ye göre ilgili kullanıcıyı bul
    User user = userRepository.findById(contact.getUser().getId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + contact.getUser().getId()));

    // Contact nesnesini ilgili kullanıcıya bağla
    contact.setUser(user);

    return new SuccessDataResult<>(contactRepository.save(contact));
    }



    @Override
    public DataResult<Contact> getContactById(int id) {
        return new SuccessDataResult<>(contactRepository.findById(id).orElse(null));
    }

    @Override
    public DataResult<Void> deleteContact(int id) {
    try {
        contactRepository.deleteById(id);
        logger.info("Contact with id {} deleted successfully", id);
        return new SuccessDataResult<>(null);
    } catch (EmptyResultDataAccessException e) {
        logger  .error("Contact not found with id: {}", id);
        return new ErrorDataResult<>("Contact not found with id: " + id);
    }
    }


}
