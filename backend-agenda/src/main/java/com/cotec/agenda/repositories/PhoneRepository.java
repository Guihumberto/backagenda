package com.cotec.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotec.agenda.entities.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
