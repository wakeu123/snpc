package com.gaia.snpc.domains.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Représente une commune dans le système")
public record CommuneResponseDTO(
        @Schema(
                description = "Identifiant unique de la commune dans la base de donnee",
                example = "ahfge-grgef-2wef5-wfwf4-fsd52",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String id,

        @Schema(
                description = "Nom de la commune",
                example = "Commune de yaounde II",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String name,

        @Schema(
                description = "Code de la commune",
                example = "125487",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String codeCommune,

        @Schema(
                description = "Nom du departement auquel la commune est lie",
                example = "125487",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String departmentName) {}
