package com.fr.adaming.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fr.adaming.entity.Equipe;
@Service
public interface IEquipeService {
	
		public Equipe create(Equipe equipe);
		public Equipe readByID(Long id);
		public List<Equipe > readAll();
		public Equipe getById(Long id);
		public Equipe getByUser();
		public void update(Equipe equipe);
		public boolean delete(Long id);
	}

