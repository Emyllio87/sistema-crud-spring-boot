package com.sistemarh.sis_rh.repository;

import com.sistemarh.sis_rh.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository  extends JpaRepository<Cargo, Long> {
}
