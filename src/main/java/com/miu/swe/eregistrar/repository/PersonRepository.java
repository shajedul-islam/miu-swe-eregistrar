package com.miu.swe.eregistrar.repository;

import com.miu.swe.eregistrar.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}