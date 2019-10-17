package com.ashishkaul.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashishkaul.rest.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}

