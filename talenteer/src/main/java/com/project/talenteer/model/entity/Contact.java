package com.project.talenteer.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.talenteer.core.entity.User;
import com.project.talenteer.model.entity.Enum.Cinsiyet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contactId")
    private int contactId;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="birthDay")
    private Date birthDay;

    @Enumerated(EnumType.STRING)
    @Column(name="sex")
    private Cinsiyet sex;

    @Column(name="linkedln")
    private String linkedln;

    @Column(name="github")
    private String github;

    @Column(name="instagram")
    private String instagram;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

}
