package com.youcode.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competition {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @Min(1)
    @Column(name = "NUMBER_OF_STAGES")
    private int numberOfStages;

    @OneToMany(mappedBy = "competition" , fetch = FetchType.EAGER)
    private List<GeneralResult> generalResults;

    @OneToMany(mappedBy = "competition", fetch = FetchType.EAGER)
    private List<Stage> stages ;
}
