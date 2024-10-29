package com.youcode.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cyclits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cyclist {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "Age")
    private int age;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "cyclist", fetch = FetchType.EAGER)
    private List<GeneralResult> generalResults;

    @OneToMany(mappedBy = "cyclist", fetch = FetchType.EAGER)
    private List<Result> results;

}
