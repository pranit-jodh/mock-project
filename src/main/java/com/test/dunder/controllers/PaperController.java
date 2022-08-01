package com.test.dunder.controllers;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.test.dunder.entity.Paper;
import com.test.dunder.exceptions.ResourceNotFoundException;
import com.test.dunder.services.PaperServicesImp;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("paper")
@CrossOrigin("*")
public class PaperController {

	@Autowired
	PaperServicesImp service;

	private static Logger logger = LoggerFactory.getLogger(PaperController.class);

	@GetMapping("/")
	public ResponseEntity<List<Paper>> getAllPaperStocks() {
		List<Paper> list = service.getAllPaperStocks();
		logger.info("Getting all the list data of paper stocks ...");
		if (list.size() <= 0) {
			logger.warn("Paper stock list not found ...");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Paper>> getPaperStock(@PathVariable("id") int paperStockId)
			throws ResourceNotFoundException {
		Optional<Paper> paper = service.getPaperStock(paperStockId);
		logger.info("Getting single data of paper stock ...");
		if (paper.isEmpty()) {
			logger.warn("Paper stock not found ...");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(paper));
	}

	@PostMapping("/")
	public ResponseEntity<Paper> addPaperStock(@RequestBody Paper paper) {
		Paper dpaper = null;
		logger.info("Insert paper stock value in the database ...");
		try {
			if (paper.getPaperAgeingInYears() <= 0 || paper.getPaperColor().equals("")
					|| paper.getPaperSize().equals("")) {
				logger.warn("Insufficient data passed through body ...");
				return (ResponseEntity<Paper>) new ResponseEntity("Fields not filled properly ... check the fields!!",
						HttpStatus.BAD_REQUEST);
			}
			dpaper = service.addPaperStock(paper);
			return ResponseEntity.of(Optional.of(dpaper));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/")
	public ResponseEntity<Paper> updatePaperStock(@RequestBody Paper paper) {
		logger.info("Update paper stock value in the database ...");
		try {
			if (paper.getPaperAgeingInYears() <= 0 || paper.getPaperColor().equals("")
					|| paper.getPaperSize().equals("")) {
				logger.warn("Insufficient data passed through body ...");
				return (ResponseEntity<Paper>) new ResponseEntity("Fields not filled properly ... check the fields!!",
						HttpStatus.BAD_REQUEST);
			}
			service.updatePaperStock(paper);
			return ResponseEntity.ok().body(paper);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePaperStock(@PathVariable("id") int paperStockId) {
		logger.info("Deleting paper stock value in the database ...");
		try {
			service.deletePaperStock(paperStockId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
