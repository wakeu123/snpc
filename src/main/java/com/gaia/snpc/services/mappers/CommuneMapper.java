package com.gaia.snpc.services.mappers;

import org.springframework.stereotype.Component;
import com.gaia.snpc.domains.entities.GeoCommunes;
import com.gaia.snpc.domains.dtos.responses.CommuneResponseDTO;

import java.util.function.Function;

@Component
public class CommuneMapper implements Function<GeoCommunes, CommuneResponseDTO> {

    @Override
    public CommuneResponseDTO apply(GeoCommunes c) {
        return new CommuneResponseDTO(
                c.getId(),
                c.getName(),
                c.getCodeCommune(),
                c.getDepartment().getName());
    }
}
