package com.example.pa_backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {

    Optional<T> findByIdAndIsArchived(Integer id, Integer isArchived);

    List<T> findByIdInAndIsArchived(List<Integer> ids, Integer isArchived);

    List<T> findAllByIsArchived(Integer isArchived);
    Page<T> findAllByIsArchived(Integer isArchived, Pageable pageable);
    
}
