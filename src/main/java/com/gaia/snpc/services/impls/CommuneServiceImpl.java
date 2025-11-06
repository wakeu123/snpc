package com.gaia.snpc.services.impls;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gaia.snpc.exceptions.ResourceNotFoundException;
import com.gaia.snpc.domains.entities.GeoCommunes;
import com.gaia.snpc.services.mappers.CommuneMapper;
import com.gaia.snpc.repositories.CommuneRepository;
import com.gaia.snpc.domains.entities.GeoDepartments;
import com.gaia.snpc.services.interfaces.CommuneService;
import com.gaia.snpc.services.interfaces.DepartmentService;
import com.gaia.snpc.domains.dtos.request.CommuneRequestDTO;
import com.gaia.snpc.domains.dtos.responses.CommuneResponseDTO;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommuneServiceImpl implements CommuneService {

    private final CommuneMapper mapper;
    private final CommuneRepository repository;
    private final DepartmentService departmentService;

    @Override
    public void delete(String code) {
        CommuneResponseDTO entity = getByCodeCommune(code);

        repository.delete(new GeoCommunes(entity.id(), entity.codeCommune()));
    }

    @Override
    public List<CommuneResponseDTO> search() {
        return repository.findAll().stream()
                .map(mapper)
                .toList();
    }

    @Override
    public GeoCommunes findByCodeCommune(String code) {
        return repository.findByCodeCommune(code)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune commune n'existe avec ce code"));
    }

    @Override
    public CommuneResponseDTO create(CommuneRequestDTO dto) {
        GeoCommunes elem = new GeoCommunes();
        elem.setName(dto.name());
        elem.setCodeCommune(dto.code());
        String departmentID = departmentService.getById(dto.departmentID()).id();
        GeoDepartments depart = new GeoDepartments(departmentID);
        elem.setDepartment(depart);
        return mapper.apply(repository.save(elem));
    }

    @Override
    public CommuneResponseDTO getByCodeCommune(String code) {
        return repository.findByCodeCommune(code)
                .map(mapper)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune commune n'existe avec ce code"));
    }

    @Override
    public CommuneResponseDTO update(String code, CommuneRequestDTO dto) {
        if(code == null || code.isEmpty()) {
            throw new ResourceNotFoundException("Aucune commune n'existe avec ce code");
        }

        GeoCommunes commune = findByCodeCommune(code);
        String departmentID = departmentService.getById(dto.departmentID()).id();
        GeoDepartments depart = new GeoDepartments(departmentID);
        commune.setName(dto.name());
        commune.setDepartment(depart);
        return mapper.apply(repository.save(commune));
    }
}
