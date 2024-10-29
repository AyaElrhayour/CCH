package com.youcode.models.entities.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ResultKey implements Serializable {

    @Column(name = "StageId")
    private UUID stageId;

    @Column(name = "CyclistId")
    private UUID cyclistId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultKey that = (ResultKey) o;
        return Objects.equals(stageId, that.stageId) &&
                Objects.equals(cyclistId, that.cyclistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stageId, cyclistId);
    }
}
