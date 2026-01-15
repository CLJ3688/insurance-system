package com.lighthouse.insurance_system.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lighthouse.insurance_system.model.Claim;
import com.lighthouse.insurance_system.repository.ClaimRepository;

@Service
public class ClaimService {

	@Autowired
	private ClaimRepository claimRepository;
	
	public Claim processClaim(Claim claim) {
		
		//1.自動產生理賠案號
		claim.setClaimNumber("CLM-" + UUID.randomUUID().toString().substring(0,8).toUpperCase());
		
		//2.自動審核
		if(claim.getAmount() != null && claim.getAmount() < 5000) {
			claim.setStatus("APPROVED");
		} else {
			claim.setStatus("PENDING");
		}
		
		//3.儲存到資料庫
		return claimRepository.save(claim);
	}
}
