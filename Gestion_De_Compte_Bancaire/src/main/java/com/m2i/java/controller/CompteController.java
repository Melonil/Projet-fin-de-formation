package com.m2i.java.controller;

import java.time.LocalDateTime;
import java.util.Map;

import com.m2i.java.DTO.OperationDTO;
import com.m2i.java.service.implementation.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.m2i.java.DTO.CompteDTO;
import com.m2i.java.model.Response;
import com.m2i.java.service.implementation.CompteService;

@RestController
@CrossOrigin
@RequestMapping("/compte")
public class CompteController {
	private final CompteService compteService;
	private final OperationService operationService;

	public CompteController(CompteService compteService, OperationService operationService) {
		this.compteService = compteService;
		this.operationService = operationService;
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<Response> getComptes(){
		System.out.println(compteService.list(30));
		return ResponseEntity.ok(
			Response.builder()
				.timeStamp(LocalDateTime.now())
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.message("Comptes retrieved")
				.data(Map.of("comptes",compteService.list(30)))
				.build()
		);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getCompte(@PathVariable("id") Long id){
		return ResponseEntity.ok(
			Response.builder()
				.timeStamp(LocalDateTime.now())
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.message("Comptes retrieved")
				.data(Map.of("compte",compteService.get(id)))
				.build()
		);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Response> saveCompte(@RequestBody CompteDTO compteDTO){
		System.out.println(compteDTO);
		return ResponseEntity.ok(
			Response.builder()
				.timeStamp(LocalDateTime.now())
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
				.message("Compte created")
				.data(Map.of("compte",compteService.create(compteDTO)))
				.build()
		);
	}
	
	@PutMapping("/save")
	public ResponseEntity<Response> updateCompte(@RequestBody CompteDTO compteDTO){
		return ResponseEntity.ok(
			Response.builder()
				.timeStamp(LocalDateTime.now())
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.message("Compte updated")
				.data(Map.of("compte",compteService.update(compteDTO)))
				.build()
		);
	}
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<Response>	deleteCompte(@PathVariable("id") Long id){
		return ResponseEntity.ok(
			Response.builder()
				.timeStamp(LocalDateTime.now())
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.message("Compte deleted")
				.data(Map.of("deleted",compteService.delete(id)))
				.build()
		);
	}

	@GetMapping("/withdraw")
	public ResponseEntity<Response> retrait(@RequestBody OperationDTO operationDTO ){
		return ResponseEntity.ok(
			Response.builder()
				.timeStamp(LocalDateTime.now())
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.message("Opération de retrait effectuée")
				.data(Map.of("operation",compteService.retrait(operationDTO.idCompte(),operationDTO.montant(),operationService)))
				.build()
		);
	}

	@GetMapping("/deposit")
	public ResponseEntity<Response> depot(@RequestBody OperationDTO operationDTO ){
		return ResponseEntity.ok(
			Response.builder()
				.timeStamp(LocalDateTime.now())
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
				.message("Opération de dépôt effectuée")
				.data(Map.of("operation",compteService.depot(operationDTO.idCompte(),operationDTO.montant(),operationService)))
				.build()
		);
	}
}
