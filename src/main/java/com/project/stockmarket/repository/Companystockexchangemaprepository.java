package com.project.stockmarket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarket.entity.Companystockexchangemap;

@Repository
public interface Companystockexchangemaprepository extends JpaRepository<Companystockexchangemap, Long> {

	Companystockexchangemap findByCodeAndName(String companycode, String stockexchangename);

	Companystockexchangemap findByCompanyNameAndExchangeName(String companyname, String stockexchangename);
}