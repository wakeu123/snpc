package com.gaia.snpc.services.mappers;

import org.springframework.stereotype.Component;
import com.gaia.snpc.domains.entities.GeoRegions;
import com.gaia.snpc.domains.dtos.responses.RegionResponseDTO;

import java.util.function.Function;

@Component
public class RegionMapper implements Function<GeoRegions, RegionResponseDTO> {
    @Override
    public RegionResponseDTO apply(GeoRegions r) {
        return new RegionResponseDTO(
                r.getId(),
                r.getName(),
                r.getCode());
    }
}
