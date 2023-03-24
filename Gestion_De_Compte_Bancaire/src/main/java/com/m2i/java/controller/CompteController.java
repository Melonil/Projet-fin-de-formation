package com.m2i.java.controller;

import java.util.Collection;

import com.m2i.java.DTO.CompteDTOMapper;
import com.m2i.java.DTO.RetraitDepotInfosDTO;
import com.m2i.java.service.implementation.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.m2i.java.DTO.CompteDTO;
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
	public ResponseEntity<Collection<CompteDTO>> getComptes(){
		System.out.println(compteService.list(30));
		return ResponseEntity.ok(
			compteService.list(30)
		);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CompteDTO> getCompte(@PathVariable("id") Long id){
		return ResponseEntity.ok(
			compteService.get(id)
		);
	}
	
	@PostMapping("/save")
	public ResponseEntity<CompteDTO> saveCompte(@RequestBody CompteDTO compteDTO){
		return ResponseEntity.ok(
			compteService.create(compteDTO)
		);
	}
	
	@PutMapping("/save")
	public ResponseEntity<CompteDTO> updateCompte(@RequestBody CompteDTO compteDTO){
		return ResponseEntity.ok(
			compteService.update(compteDTO)
		);
	}
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<Boolean>	deleteCompte(@PathVariable("id") Long id){
		return ResponseEntity.ok(
			compteService.delete(id)
		);
	}

	@PutMapping("/withdraw")
	public ResponseEntity<CompteDTO> retrait(@RequestBody RetraitDepotInfosDTO retraitDepotInfosDTO){

		return ResponseEntity.ok(
			compteService.operationRetrait(retraitDepotInfosDTO,operationService)
		);
	}

	@PutMapping("/deposit")
	public ResponseEntity<CompteDTO> depot(@RequestBody RetraitDepotInfosDTO retraitDepotInfosDTO){
		return ResponseEntity.ok(
			compteService.depot(retraitDepotInfosDTO.idCompte(), retraitDepotInfosDTO.montant(),operationService)
		);
	}

	@GetMapping("/getMainAccount/{id}")
	public ResponseEntity<CompteDTO>	getMainAccount(@PathVariable("id") Long idClient){
		return ResponseEntity.ok(
			compteService.getCompteByIdClient(idClient)
		);
	}

}
