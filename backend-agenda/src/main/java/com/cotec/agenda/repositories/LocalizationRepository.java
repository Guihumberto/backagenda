package com.cotec.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotec.agenda.entities.Localization;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Long> {

}
