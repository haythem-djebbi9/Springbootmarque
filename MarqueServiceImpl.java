package com.example.Finale.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.Finale.entities.Marque;
import com.example.Finale.repos.Marquerepisotery;

@Service
public class MarqueServiceImpl implements MarqueService {
	
	@Autowired
	private Marquerepisotery marqueRepository;

	@Override
	public Marque saveMarque(Marque m) {
		return marqueRepository.save(m);
	}

	@Override
	public Marque updateMarque(Marque m) {
		return marqueRepository.save(m);
	}

	@Override
	public void deleteMarque(Marque m) {
		marqueRepository.delete(m);
	}

	@Override
	public void deleteMarqueById(Long id) {
		marqueRepository.deleteById(id);
	}

	@Override
	public Marque getMarque(Long id) {
		return marqueRepository.findById(id).get();
	}

	@Override
	public List<Marque> getAllMarques() {
		return marqueRepository.findAll();
	}
	@Override
	public Page<Marque> getAllMarquesParPage(int page, int size) {
	    return marqueRepository.findAll(PageRequest.of(page, size));
	}

}


