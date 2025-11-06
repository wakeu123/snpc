package com.gaia.snpc.repositories;

import org.springframework.stereotype.Repository;
import com.gaia.snpc.domains.entities.GeoDepartments;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<GeoDepartments, String> {
}
