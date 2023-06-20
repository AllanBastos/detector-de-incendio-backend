package com.detectordeincendiobackend.domain.repository;

import com.detectordeincendiobackend.domain.model.StatusCasa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusCasaRepository extends JpaRepository<StatusCasa, Long> {
}
