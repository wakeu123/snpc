package com.gaia.snpc.repositories;

import org.springframework.stereotype.Repository;
import com.gaia.snpc.domains.entities.GeoCommunes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface CommuneRepository extends JpaRepository<GeoCommunes, String> {

    Optional<GeoCommunes> findByCodeCommune(String code);
}
