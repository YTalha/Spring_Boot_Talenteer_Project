package com.project.talenteer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.talenteer.model.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
