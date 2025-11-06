package com.gaia.snpc.repositories;

import com.gaia.snpc.domains.entities.GeoRegions;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<GeoRegions, String> {
    Optional<GeoRegions> findByCode(String code);
}
