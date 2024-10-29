package com.youcode.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "number")
    private int number;

    @Size(min = 2 , max = 50)
    @Column(name = "startLocation")
    private String startLocation;

    @Column(name = "endLocation")
    private String endLocation;

    @Column(name = "type")
    private String type;

    @Column(name = "isCompleted")
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "competitionId")
    private Competition competition ;

    @OneToMany(mappedBy = "stage")
    private List<Result> results;

}
