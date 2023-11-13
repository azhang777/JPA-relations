package com.spring.jpamanytomanydemo.repository;

import com.spring.jpamanytomanydemo.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends CrudRepository<Concert, Long> {
}
