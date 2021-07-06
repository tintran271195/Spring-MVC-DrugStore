package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, Long>{
    Iterable<Medicine> findAllByCategory(Category category);
    Page<Medicine> findAllByNameContaining(String name, Pageable pageable);
}

