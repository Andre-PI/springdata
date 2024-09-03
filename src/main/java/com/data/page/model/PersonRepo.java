package com.data.page.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PersonRepo extends JpaRepository<Person, Integer>{

    List<Person> findByName(String name);
}
