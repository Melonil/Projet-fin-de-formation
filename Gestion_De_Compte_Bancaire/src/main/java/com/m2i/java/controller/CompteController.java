package com.m2i.java.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.java.DTO.CompteDTO;
import com.m2i.java.model.Compte;
import com.m2i.java.model.Response;
import com.m2i.java.service.implementation.CompteService;

@RestController
@RequestMapping("/compte")
public class CompteController {
	private final CompteService compteService;

	public CompteController(CompteService compteService) {
		this.compteService = compteService;
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<Response> getComptes(){
		System.out.println(compteService.list(30));
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.OK.value(),
						HttpStatus.OK,
						null,
						"Comptes retrieved",
						null,
						Map.of("comptes",compteService.list(30))
				)
		);
				
	} 
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getCompte(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.OK.value(),
						HttpStatus.OK,
						null,
						"Compte retrieved",
						null,
						Map.of("compte",compteService.get(id))
				)
		);
				
	}
	
	@PostMapping("/save")
	public ResponseEntity<Response> saveCompte(@RequestBody CompteDTO compteDTO){
		System.out.println(compteDTO);
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.CREATED.value(),
						HttpStatus.CREATED,
						null,
						"Compte created",
						null,
						Map.of("compte",compteService.create(compteDTO))
				)
		);
				
	}
	
	@PutMapping("/save")
	public ResponseEntity<Response> updateCompte(@RequestBody CompteDTO compteDTO){
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.OK.value(),
						HttpStatus.OK,
						null,
						"Compte updated",
						null,
						Map.of("compte",compteService.update(compteDTO))
				)
		);
				
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Response>	deleteCompte(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.OK.value(),
						HttpStatus.OK,
						null,
						"Compte deleted",
						null,
						Map.of("deleted",compteService.delete(id))
				)
		);
				
	}
}
