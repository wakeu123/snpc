package com.gaia.snpc.services.impls;

import com.gaia.snpc.domains.entities.GeoCommunes;
import com.gaia.snpc.domains.entities.GeoRegions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gaia.snpc.ResourceNotFoundException;
import com.gaia.snpc.domains.entities.GeoDepartments;
import com.gaia.snpc.repositories.DepartmentRepository;
import com.gaia.snpc.services.interfaces.RegionService;
import com.gaia.snpc.services.mappers.DepartmentMapper;
import com.gaia.snpc.services.interfaces.DepartmentService;
import com.gaia.snpc.domains.dtos.request.DepartmentRequestDTO;
import com.gaia.snpc.domains.dtos.responses.DepartmentResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper mapper;
    private final RegionService regionService;
    private final DepartmentRepository repository;

    @Override
    public void delete(String id) {
        GeoDepartments entity = findById(id);
        repository.delete(entity);
    }

    @Override
    public List<DepartmentResponseDTO> search() {
        return repository.findAll().stream()
                .map(mapper)
                .toList();
    }

    @Override
    public DepartmentResponseDTO getById(String id) {
        return mapper.apply(findById(id));
    }

    @Override
    public DepartmentResponseDTO create(DepartmentRequestDTO dto) {
        GeoDepartments elem = new GeoDepartments();
        elem.setName(dto.name());
        GeoRegions region = regionService.findByCode(dto.codeRegion());
        elem.setRegion(region);
        return mapper.apply(repository.save(elem));
    }

    @Override
    public DepartmentResponseDTO update(String id, DepartmentRequestDTO dto) {
        if(id == null || id.isEmpty()) {
            throw new ResourceNotFoundException("Aucun departement n'existe avec cet id");
        }

        GeoDepartments department = findById(id);
        GeoRegions region = regionService.findByCode(dto.codeRegion());
        department.setName(dto.name());
        department.setRegion(region);
        return mapper.apply(repository.save(department));
    }

    public GeoDepartments findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune departement n'existe avec cet id"));
    }
}
