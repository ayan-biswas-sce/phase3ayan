package com.project.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarket.entity.IPODetail;

@Repository
public interface IPOrepository extends JpaRepository<IPODetail, Long> {

}
