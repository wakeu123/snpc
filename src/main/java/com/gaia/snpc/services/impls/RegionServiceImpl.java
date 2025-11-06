package com.gaia.snpc.services.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gaia.snpc.exceptions.ResourceNotFoundException;
import com.gaia.snpc.domains.entities.GeoRegions;
import com.gaia.snpc.services.mappers.RegionMapper;
import com.gaia.snpc.repositories.RegionRepository;
import com.gaia.snpc.services.interfaces.RegionService;
import com.gaia.snpc.domains.dtos.request.RegionRequestDTO;
import com.gaia.snpc.domains.dtos.responses.RegionResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionMapper mapper;
    private final RegionRepository repository;

    @Override
    public void delete(String code) {

    }

    @Override
    public List<RegionResponseDTO> search() {
        return repository.findAll().stream()
                .map(mapper)
                .toList();
    }

    @Override
    public GeoRegions findByCode(String code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune region n'existe avec ce code"));
    }

    @Override
    public RegionResponseDTO getByCode(String code) {
        return repository.findByCode(code)
                .map(mapper)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune region n'existe avec ce code"));
    }

    @Override
    public RegionResponseDTO create(RegionRequestDTO dto) {
        GeoRegions elem = new GeoRegions();
        elem.setName(dto.name());
        elem.setCode(dto.code());
        return mapper.apply(repository.save(elem));
    }

    @Override
    public RegionResponseDTO update(String code, RegionRequestDTO dto) {
        if(code == null || code.isEmpty()) {
            throw new ResourceNotFoundException("Aucune region n'existe avec ce code");
        }

        GeoRegions region = findByCode(code);
        region.setName(dto.name());
        return mapper.apply(repository.save(region));
    }
}
