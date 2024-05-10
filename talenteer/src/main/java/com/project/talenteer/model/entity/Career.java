package com.project.talenteer.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.talenteer.core.entity.User;
import com.project.talenteer.model.entity.Enum.CalismaTuru;
import com.project.talenteer.model.entity.Enum.IsTuru;
import com.project.talenteer.model.entity.Enum.Pozisyon;
import com.project.talenteer.model.entity.Enum.Ulke;

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
@Table(name="career")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="careerId")
    private int careerId;

    @Column(name="salary")
    private double salary;

    @Column(name="startDate")
    private Date startDate;

    @Column(name="jobType")
    private IsTuru jobType;

    @Column(name="workType")
    private CalismaTuru workType;

    @Column(name="workPosition")
    private Pozisyon workPosition;

    @Column(name="workCountry")
    private Ulke workCountry;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    private User user;
}
