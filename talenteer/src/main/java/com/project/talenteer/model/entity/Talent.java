package com.project.talenteer.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.talenteer.core.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="talent")
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "talentId")
    private int talentId;

    @Column(name = "softwareLanguage")
    private String softwareLanguage;

    @Column(name = "softwareLanguageLevel")
    private String softwareLanguageLevel;

    @Column(name = "foreignLanguage")
    private String foreignLanguage;

    @Column(name = "foreignLanguageLevel")
    private String foreignLanguageLevel;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

}
