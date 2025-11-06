package com.gaia.snpc.services.mappers;

import org.springframework.stereotype.Component;
import com.gaia.snpc.domains.entities.GeoDepartments;
import com.gaia.snpc.domains.dtos.responses.DepartmentResponseDTO;

import java.util.function.Function;

@Component
public class DepartmentMapper implements Function<GeoDepartments, DepartmentResponseDTO> {
    @Override
    public DepartmentResponseDTO apply(GeoDepartments g) {
        return new DepartmentResponseDTO(
                g.getId(),
                g.getName(),
                g.getRegion().getName());
    }
}
