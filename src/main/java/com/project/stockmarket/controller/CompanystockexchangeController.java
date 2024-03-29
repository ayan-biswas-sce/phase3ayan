package com.project.stockmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarket.entity.Company;
import com.project.stockmarket.entity.Companystockexchangemap;
import com.project.stockmarket.entity.StockExchange;
import com.project.stockmarket.repository.Companyrepository;
import com.project.stockmarket.repository.Companystockexchangemaprepository;
import com.project.stockmarket.repository.StockExchangeRepository;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class CompanystockexchangeController {
	@Autowired
	Companystockexchangemaprepository compstkmaprepo;
	@Autowired
	Companyrepository cmprepo;
	@Autowired
	StockExchangeRepository stkrepo;

	@PostMapping(path = "/mapcompanycode")
	public Companystockexchangemap mapcode(@RequestBody Companystockexchangemap cmpstkmap) {

		Company company = cmprepo.findByName(cmpstkmap.getCompanyname());
		StockExchange stkexchg = stkrepo.findByName(cmpstkmap.getStockexchangename());
		Companystockexchangemap csemap = new Companystockexchangemap();
		csemap.setCompanycode(cmpstkmap.getCompanycode());
		csemap.setCompanyname(cmpstkmap.getCompanyname());
		csemap.setStockexchangename(cmpstkmap.getStockexchangename());
		csemap.setStockexchange(stkexchg);
		csemap.setCompany(company);
		csemap = compstkmaprepo.save(csemap);
		return csemap;
	}

	@GetMapping(path = "/getAllMappings")
	public List<Companystockexchangemap> getAll() {
		List<Companystockexchangemap> compstockmap = compstkmaprepo.findAll();
		return compstockmap;
	}

	@DeleteMapping(path = "/{id}/delete")
	public void delete(@PathVariable Long id) {
		compstkmaprepo.deleteById(id);
	}
}
