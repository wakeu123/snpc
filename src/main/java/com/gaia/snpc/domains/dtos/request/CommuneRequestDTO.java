package com.gaia.snpc.domains.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Représente l'objet qui permet de creer la commune dans le système")
public record CommuneRequestDTO(
        @Schema(
                description = "Nom de la commune",
                example = "125487",
                requiredMode = REQUIRED
        )
        String name,

        @Schema(
                description = "Code de la commune",
                example = "NGDF/YND/237",
                requiredMode = REQUIRED
        )
        String code,

        @Schema(
                description = "Identifiant du departement de la commune",
                example = "asdsf-geedd-fsfsf-gresd-25fs6",
                requiredMode = REQUIRED
        )
        String departmentID) { }
