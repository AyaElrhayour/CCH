package com.youcode.models.entities;


import com.youcode.models.entities.embeddables.ResultKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Entity
@Table(name = "result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @EmbeddedId
    private ResultKey id;
    private Duration time;
    private int rank ;


}
