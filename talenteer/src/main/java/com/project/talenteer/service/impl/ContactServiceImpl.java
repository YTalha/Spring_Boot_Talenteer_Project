package com.project.talenteer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.repository.UserRepository;
import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.ErrorDataResult;
import com.project.talenteer.core.utilities.result.SuccessDataResult;
import com.project.talenteer.model.entity.Contact;
import com.project.talenteer.repository.ContactRepository;
import com.project.talenteer.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;
    
    private final UserRepository userRepository;

    @Autowired
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
    public DataResult<Contact> getContactByUserId(int userId) {
    User user = userRepository.findById(userId).orElse(null);
    if (user == null) {
        return new ErrorDataResult<>("User not found");
    }

    Contact contact = user.getContact();
    if (contact == null) {
        return new ErrorDataResult<>("Contact not found for user with id: " + userId);
    }

    return new SuccessDataResult<>(contact);
    }

}
