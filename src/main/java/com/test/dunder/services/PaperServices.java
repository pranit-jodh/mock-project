package com.test.dunder.services;

import java.util.List;
import java.util.Optional;

import com.test.dunder.entity.Paper;
import com.test.dunder.exceptions.ResourceNotFoundException;

public interface PaperServices {

	List<Paper> getAllPaperStocks();
	Optional<Paper> getPaperStock(int paperStockId) throws ResourceNotFoundException;
	Paper addPaperStock(Paper paper);
	Paper updatePaperStock(Paper paper)throws ResourceNotFoundException;
	void deletePaperStock(int paperStockId) throws ResourceNotFoundException;
	
}
