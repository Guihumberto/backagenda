package com.cotec.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotec.agenda.entities.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

}
