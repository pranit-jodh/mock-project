package com.test.dunder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int paperStockId;
	String paperSize;
	int paperAgeingInYears;
	String paperColor;
}
