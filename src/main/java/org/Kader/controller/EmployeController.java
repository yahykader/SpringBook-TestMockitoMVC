package org.Kader.controller;

import java.util.List;

import org.Kader.model.Employe;
import org.Kader.model.Response;
import org.Kader.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/employe")
public class EmployeController {
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@PostMapping(value="/addEmploye")
	public Response addEmploye(@RequestBody Employe employe) {
		 employeRepository.save(employe);
		 return new Response(employe.getId()+ "inserted",Boolean.TRUE);
	}
	
	@GetMapping(value="/getAllEmployes")
	public Response getAllEmployes() {
		List<Employe>employes=employeRepository.findAll();
		return new Response("record counts "+employes.size(),Boolean.TRUE);
		
	}
	
	
	

}
