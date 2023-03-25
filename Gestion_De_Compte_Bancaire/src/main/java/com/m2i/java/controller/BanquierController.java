package com.m2i.java.controller;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.java.DTO.BanquierDTO;
import com.m2i.java.model.Response;
import com.m2i.java.service.implementation.BanquierService;

@RestController
@CrossOrigin
@RequestMapping("/banquier")
public class BanquierController {
	
	private final BanquierService banquierService;
	
	public BanquierController(BanquierService banquierService) {
		this.banquierService = banquierService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<Collection<BanquierDTO>> getBanquiers(){
		System.out.println(banquierService.list(30));
		return ResponseEntity.ok(
				banquierService.list(30)
		);
				
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<BanquierDTO> getBanquier(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				banquierService.get(id)
		);
				
	}
	
	@PostMapping("/save")
	public ResponseEntity<BanquierDTO> saveBanquier(@RequestBody BanquierDTO banquierDTO){
		System.out.println(banquierDTO);
		return ResponseEntity.ok(
				banquierService.create(banquierDTO)
		);
				
	}
	
	@PutMapping("/save")
	public ResponseEntity<BanquierDTO> updateBanquier(@RequestBody BanquierDTO banquierDTO){
		return ResponseEntity.ok(
				banquierService.update(banquierDTO)
		);
				
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean>	deleteBanquier(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				banquierService.delete(id)
		);
				
	}
}
