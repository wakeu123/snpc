package com.gaia.snpc.domains.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Représente un departement dans le système")
public record DepartmentResponseDTO(
        @Schema(
                description = "Identifiant unique du departement",
                example = "ahfge-grgef-2wef5-wfwf4-fsd52",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String id,

        @Schema(
                description = "Nom du departement",
                example = "departement MIFI",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String name,

        @Schema(
                description = "Nom de la region",
                example = "Yaounde",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String regionName) {}
