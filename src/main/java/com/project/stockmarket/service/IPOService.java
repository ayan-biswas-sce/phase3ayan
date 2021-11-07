package com.project.stockmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.entity.IPODetail;
import com.project.stockmarket.repository.IPOrepository;

@Service
public class IPOService {

	@Autowired
	private IPOrepository iporepo;

	public List<IPODetail> getAllIPO() {
		List<IPODetail> ipos = iporepo.findAll();
		return ipos;
	}

}
