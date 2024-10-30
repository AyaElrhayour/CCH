package com.youcode.models.entities.embeddables;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResultKey implements Serializable {

    @Column(name = "cyclistId")
    private UUID cyclistId;

    @Column(name = "competitionId")
    private UUID competitionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResultKey that = (GeneralResultKey) o;
        return Objects.equals(cyclistId, that.cyclistId) &&
                Objects.equals(competitionId, that.competitionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cyclistId, competitionId);
    }
}
