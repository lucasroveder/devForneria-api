package com.example.devforneria.ltable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LTableRepository extends JpaRepository<LTable, Long> {

}
