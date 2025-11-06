package com.gaia.snpc.domains.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Représente une region dans le système")
public record RegionResponseDTO(
        @Schema(
                description = "Identifiant unique de la region dans la base de donnee",
                example = "ahfge-grgef-2wef5-wfwf4-fsd52",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String id,

        @Schema(
                description = "Nom de la region",
                example = "Yaounde",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String name,

        @Schema(
                description = "Code de la region",
                example = "YND",
                accessMode = Schema.AccessMode.READ_ONLY
        )
        String code) {
}
