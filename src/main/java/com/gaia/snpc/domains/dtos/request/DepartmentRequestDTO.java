package com.gaia.snpc.domains.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Représente l'objet qui permet de creer le departement dans le système")
public record DepartmentRequestDTO(
        @Schema(
                description = "Nom du departement",
                example = "MIFI",
                requiredMode = REQUIRED
        )
        String name,

        @Schema(
                description = "Code de la region",
                example = "asdsf-geedd-fsfsf-gresd-25fs6",
                requiredMode = REQUIRED
        )
        String codeRegion) { }
