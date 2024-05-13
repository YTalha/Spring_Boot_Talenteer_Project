package com.project.talenteer.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.talenteer.core.entity.User;
import com.project.talenteer.model.entity.Enum.Rapor;

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
@Table(name = "handicap")
public class Handicap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "handicapId")
    private int handicapId;

    @Column(name = "handicapType")
    private String handicapType;

    @Column(name = "handicapRatio")
    private String handicapRatio;

    @Column(name = "report")
    private Rapor report;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

}
