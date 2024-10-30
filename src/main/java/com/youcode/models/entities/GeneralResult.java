package com.youcode.models.entities;


import com.youcode.models.entities.embeddables.GeneralResultKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.Duration;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResult {

    @EmbeddedId
    private GeneralResultKey id;

    @Column(name = "overallTime")
    private Duration overallTime;

    @Column(name = "overallRank")
    private int overallRank;

    @ManyToOne()
    @JoinColumn(name = "cyclistId")
    @MapsId("cyclistId")
    private Cyclist cyclist;

    @ManyToOne()
    @JoinColumn(name = "competitionId")
    @MapsId("competitionId")
    private Competition competition;
}
