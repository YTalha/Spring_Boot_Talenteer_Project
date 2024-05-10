package com.project.talenteer.model.entity;

import java.util.Date;

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
@Table(name="education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="educationId")
    private int educationId;

    @Column(name="universityName")
    private String universityName;

    @Column(name="departmentName")
    private String departmentName;

    @Column(name="degrees")
    private String degrees;

    @Column(name="startEducationDate")
    private Date startEducationDate;

    @Column(name="endEducationDate")
    private Date endEducationDate;

    @Column(name="companyName")
    private String companyName;

    @Column(name="companyPosition")
    private String companyPosition;

    @Column(name="companyStatu")
    private String companyStatu;

    @Column(name="startCompanyDate")
    private Date startCompanyDate;

    @Column(name="endCompanyDate")
    private Date endCompanyDate;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

}
