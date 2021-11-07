package com.project.stockmarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.entity.Company;
import com.project.stockmarket.entity.IPODetail;
import com.project.stockmarket.entity.Sector;
import com.project.stockmarket.repository.Companyrepository;
import com.project.stockmarket.repository.IPOrepository;
import com.project.stockmarket.repository.SectorRepository;

@Service
public class CompanyService {

	@Autowired
	private Companyrepository companyrepo;

	@Autowired
	private SectorRepository sectorrepo;

	@Autowired
	private IPOrepository iporepo;

	public List<Company> getCompanies() {
		List<Company> companies = companyrepo.findAll();
		return companies;
	}

	public Company findById(Long id) {
		Optional<Company> company = companyrepo.findById(id);
		if (!company.isPresent())
			return null;
		return company.get();
	}

	public IPODetail getCompanyIPODetails(Long id) {
		Optional<Company> company = companyrepo.findById(id);
		if (!company.isPresent())
			return null;
		IPODetail ipo = company.get().getIpo();
		return ipo;
	}

	public Object addCompany(Company company) {

		Sector sector = sectorrepo.findByName(company.getSectorname());
		if (sector == null)
			return null;
		company.setSector(sector);
		company = companyrepo.save(company);
		return company;
	}

	public void deleteCompany(long id) {
		companyrepo.deleteById(id);
	}

	public Company addIpoToCompany(String companyName, IPODetail ipo) {

		Company company = companyrepo.findByName(companyName);
		if (company == null)
			return null;
		ipo.setCompany(company);
		iporepo.save(ipo);

		company.setIpo(ipo);
		company = companyrepo.save(company);
		return company;
	}

}
