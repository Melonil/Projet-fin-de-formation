package com.m2i.java.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/banquier")
public class BanquierController {
	
	private final BanquierService banquierService;
	
	public BanquierController(BanquierService banquierService) {
		this.banquierService = banquierService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<Response> getBanquiers(){
		System.out.println(banquierService.list(30));
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.OK.value(),
						HttpStatus.OK,
						null,
						"Banquier retrieved",
						null,
						Map.of("banquiers",banquierService.list(30))
				)
		);
				
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getBanquier(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.OK.value(),
						HttpStatus.OK,
						null,
						"Banquier retrieved",
						null,
						Map.of("banquier",banquierService.get(id))
				)
		);
				
	}
	
	@PostMapping("/save")
	public ResponseEntity<Response> saveBanquier(@RequestBody BanquierDTO banquierDTO){
		System.out.println(banquierDTO);
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.CREATED.value(),
						HttpStatus.CREATED,
						null,
						"Banquier created",
						null,
						Map.of("banquier",banquierService.create(banquierDTO))
				)
		);
				
	}
	
	@PutMapping("/save")
	public ResponseEntity<Response> updateBanquier(@RequestBody BanquierDTO banquierDTO){
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.OK.value(),
						HttpStatus.OK,
						null,
						"Banquier updated",
						null,
						Map.of("banquier",banquierService.update(banquierDTO))
				)
		);
				
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response>	deleteBanquier(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				new Response(
						LocalDateTime.now(), 
						HttpStatus.OK.value(),
						HttpStatus.OK,
						null,
						"Banquier deleted",
						null,
						Map.of("deleted",banquierService.delete(id))
				)
		);
				
	}
}
