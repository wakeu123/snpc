package com.gaia.snpc.services.interfaces;

import com.gaia.snpc.domains.entities.GeoRegions;
import com.gaia.snpc.domains.dtos.request.RegionRequestDTO;
import com.gaia.snpc.domains.dtos.responses.RegionResponseDTO;

import java.util.List;

public interface RegionService {

    void delete(String code);

    List<RegionResponseDTO> search();

    GeoRegions findByCode(String code);

    RegionResponseDTO getByCode(String code);

    RegionResponseDTO create(RegionRequestDTO dto);

    RegionResponseDTO update(String code, RegionRequestDTO dto);

}
