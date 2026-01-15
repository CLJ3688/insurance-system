package com.lighthouse.insurance_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "claims")
@Data

public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String claimNumber;
	private String policyNumber;
	private Double amount;
	private String description;
	private String status;
	private LocalDate reportDate;
	
	public boolean isHighValue() {
		return this.amount != null && this.amount > 10000;
	}
	
}
