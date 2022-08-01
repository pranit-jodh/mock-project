package com.test.dunder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dunder.entity.Paper;
import com.test.dunder.exceptions.ResourceNotFoundException;
import com.test.dunder.repo.PaperRepo;

@Service
public class PaperServicesImp implements PaperServices{

	@Autowired
	PaperRepo repo;

	@Override
	public List<Paper> getAllPaperStocks() {
		List<Paper> paperList = null;
		try {
			paperList = repo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paperList;
	}

	@Override
	public Optional<Paper> getPaperStock(int paperStockId) throws ResourceNotFoundException {
		Optional<Paper> paper = null;

		paper = Optional.ofNullable(repo.findById(paperStockId)
				.orElseThrow(() -> new ResourceNotFoundException("Paper Stock not found for id :: " + paperStockId)));

		return paper;
	}

	@Override
	public Paper addPaperStock(Paper paper) {
		return repo.save(paper);
	}

	@Override
	public Paper updatePaperStock(Paper paper) throws ResourceNotFoundException {
		Optional<Paper> updatePaper = Optional.ofNullable(repo.findById(paper.getPaperStockId()).orElseThrow(
				() -> new ResourceNotFoundException("Paper Stock not found for id :: " + paper.getPaperStockId())));
		Paper upaper = updatePaper.get();
		upaper.setPaperAgeingInYears(paper.getPaperAgeingInYears());
		upaper.setPaperColor(paper.getPaperColor());
		upaper.setPaperSize(paper.getPaperSize());
		return repo.save(upaper);

	}

	@Override
	public void deletePaperStock(int paperStockId) throws ResourceNotFoundException {
		Optional<Paper> deletePaper = Optional.ofNullable(repo.findById(paperStockId)
				.orElseThrow(() -> new ResourceNotFoundException("Paper Stock not found for id :: " + paperStockId)));
		repo.delete(deletePaper.get());
	}
}
