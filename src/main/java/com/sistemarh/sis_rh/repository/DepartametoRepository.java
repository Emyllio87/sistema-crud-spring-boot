package com.sistemarh.sis_rh.repository;

import com.sistemarh.sis_rh.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartametoRepository  extends JpaRepository<Departamento, Long> {
}
