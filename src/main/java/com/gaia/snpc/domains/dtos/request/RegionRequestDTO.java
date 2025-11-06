package com.gaia.snpc.domains.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Représente l'objet qui permet de creer une region dans le système")
public record RegionRequestDTO(
        @Schema(
                description = "Code de la region",
                example = "YND",
                requiredMode = REQUIRED
        )
        String code,

        @Schema(
                description = "Nom de la region",
                example = "Yaounde",
                requiredMode = REQUIRED
        )
        String name) {
}
