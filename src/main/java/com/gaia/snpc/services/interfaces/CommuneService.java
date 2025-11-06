package com.gaia.snpc.services.interfaces;

import com.gaia.snpc.domains.dtos.request.CommuneRequestDTO;
import com.gaia.snpc.domains.dtos.responses.CommuneResponseDTO;
import com.gaia.snpc.domains.entities.GeoCommunes;

import java.util.List;

public interface CommuneService {

    void delete(String code);

    List<CommuneResponseDTO> search();

    GeoCommunes findByCodeCommune(String code);

    CommuneResponseDTO create(CommuneRequestDTO dto);

    CommuneResponseDTO getByCodeCommune(String code);

    CommuneResponseDTO update(String code, CommuneRequestDTO dto);
}
