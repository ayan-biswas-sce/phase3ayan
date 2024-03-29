package com.project.stockmarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.entity.Company;
import com.project.stockmarket.entity.Sector;
import com.project.stockmarket.repository.SectorRepository;

@Service
public class SectorService {
	
	@Autowired
	SectorRepository sectorrepo;

	public Sector findById(long id) {
		Optional<Sector> sector = sectorrepo.findById(id);
		if (!sector.isPresent())
			return null;
		return sector.get();
	}

	public Sector save(Sector sector) {
		sectorrepo.save(sector);
		return sector;
	}

	public void deleteById(long id) {
		sectorrepo.deleteById(id);

	}

	public List<Company> getCompanies(long id) {
		Optional<Sector> sector = sectorrepo.findById(id);
		List<Company> companies = sector.get().getCompanies();
		return companies;
	}

	public List<Sector> findAll() {
		List<Sector> sectors = sectorrepo.findAll();
		return sectors;
	}

}
