package com.gaia.snpc.services.interfaces;

import com.gaia.snpc.domains.dtos.request.DepartmentRequestDTO;
import com.gaia.snpc.domains.dtos.responses.DepartmentResponseDTO;
import com.gaia.snpc.domains.entities.GeoDepartments;

import java.util.List;

public interface DepartmentService {

    void delete(String id);

    GeoDepartments findById(String id);

    List<DepartmentResponseDTO> search();

    DepartmentResponseDTO getById(String id);

    DepartmentResponseDTO create(DepartmentRequestDTO dto);

    DepartmentResponseDTO update(String id, DepartmentRequestDTO dto);
}
