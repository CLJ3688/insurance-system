package com.lighthouse.insurance_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lighthouse.insurance_system.model.Claim;
import com.lighthouse.insurance_system.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	@PostMapping
	public Claim submitClaim(@RequestBody Claim claim) {
		return claimService.processClaim(claim);
	}
}
