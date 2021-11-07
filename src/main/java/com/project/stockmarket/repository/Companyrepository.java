package com.project.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.stockmarket.entity.Company;


@Repository
public interface Companyrepository extends JpaRepository<Company, Long> {
	
	Company findByName(String Name);

}