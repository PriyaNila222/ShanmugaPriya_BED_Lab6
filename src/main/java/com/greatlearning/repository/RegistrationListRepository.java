package com.greatlearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.RegistrationList;

@Repository
public interface RegistrationListRepository extends JpaRepository<RegistrationList, Long> {

}
