package com.project.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.stockmarket.entity.Sector;


@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
	
	Sector findByName(String Name);

}