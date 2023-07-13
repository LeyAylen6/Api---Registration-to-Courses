package com.example.Project.UNRN.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InscriptionData {

    public @NotNull @Positive Long studentId;
    public @NotNull @Positive Long courseId;

}
