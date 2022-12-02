package com.example.pa_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {

    Optional<T> findById(Integer id);


    List<T> findAll();
}
