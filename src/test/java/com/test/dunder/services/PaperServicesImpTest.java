package com.test.dunder.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.test.dunder.entity.Paper;
import com.test.dunder.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.Service;

import com.test.dunder.repo.PaperRepo;

@SpringBootTest
public class PaperServicesImpTest {
	
	@Autowired
	PaperRepo repo;
	
	@Autowired
	PaperServicesImp service;
	
	public PaperServicesImpTest() {
		
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void savePaperStocks() {
		Paper paper = new Paper();
		paper.setPaperAgeingInYears(5);
		paper.setPaperColor("white");
		paper.setPaperSize("A4");
		paper = service.addPaperStock(paper);
		assertNotNull(repo.findById(paper.getPaperStockId()).get());
	}
	
	@Test
	void getAllPaperStocks() {
		List<Paper> paperList = service.getAllPaperStocks();
		assertThat(paperList).size().isGreaterThan(0);
	}
	
//	@Test
//	void updatePaperStock() throws ResourceNotFoundException {
//		Paper paper = repo.findById(1).get();
//		System.out.println(paper);
//		paper.setPaperStockId(1);
//		paper.setPaperColor("white");
//		paper.setPaperAgeingInYears(2);
//		paper.setPaperSize("A3");
//		paper = service.updatePaperStock(paper);
//		assertEquals("A3", paper.getPaperSize());
//	}
	
	@Test
	void getPaperStock() throws ResourceNotFoundException {
		Paper paper = service.getPaperStock(1).get();
		assertEquals(5, paper.getPaperAgeingInYears());
		assertEquals("white", paper.getPaperColor());
		assertEquals("A4", paper.getPaperSize());
	}
	
	
//	@Test
//	void deletePaperStock() {
//		service.deletePaperStock(1);
//		assertThat(repo.existsById(1)).isFalse();
//	}
//	
//	
	
	
}
