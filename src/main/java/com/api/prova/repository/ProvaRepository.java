package com.api.prova.repository;

import com.api.prova.models.ProvaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvaRepository extends JpaRepository<ProvaModel, Long> {
}


