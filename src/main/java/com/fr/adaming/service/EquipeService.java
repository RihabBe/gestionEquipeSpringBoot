package com.fr.adaming.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IEquipeDao;
import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;

@Service
public class EquipeService implements IEquipeService {

	@Autowired
	private IEquipeDao daoEq;
	private Logger log = Logger.getLogger(UserService.class);

	@Override
	public Equipe create(Equipe equipe) {
		if (equipe.getId() == null || equipe.getId() == 0 || daoEq.existsById(equipe.getId()) == false) {
			try {
				daoEq.save(equipe);
			} catch (Exception e) {
				if (e instanceof IllegalArgumentException) {
					log.info("DEBUG create: opéartion non réalisée");
				} else {
					log.error(e.getStackTrace());
				}
			}
		} else {
			log.debug("DEBUG create: ID existant/ équipe non crée");
		}
		return equipe;
	}

	@Override
	public Equipe readByID(Long id) {
		Equipe eq = null;
		try {
			eq = daoEq.findById(id).get();
		} catch (Exception e) {
			if (e instanceof IllegalArgumentException) {
				log.info("ID  null opération non effectuée ");
			} else {
				log.error(e.getStackTrace());
			}
		}
		return eq;
	}

	@Override
	public List<Equipe> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipe getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipe getByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Equipe equipe) {
		if (equipe.getId() != null || equipe.getId() != 0 || daoEq.existsById(equipe.getId())) {
			try{daoEq.save(equipe);
			
			System.out.println("DEBUG update: MAJ SUCCESS");
			}catch (Exception e) {
				if (e instanceof IllegalArgumentException) {
					log.info("ID  null opération non effectuée ");
				} else {
					log.error(e.getStackTrace());
				}
			}
		} else {
			log.debug("DEBUG update: pas d'EQUIPE avec cet id");
		}

	}

	@Override
	public boolean delete(Long id) {
		try {
			daoEq.deleteById(id);

		} catch (Exception e) {
			if (e instanceof EmptyResultDataAccessException) {
				log.info("ID  n'exite pas opération non effectuée ");
			} else if (e instanceof IllegalArgumentException) {
				log.info("ID NULL opération non effectuée ");
				log.error(e.getStackTrace());
			}
		}
		return !daoEq.existsById(id);
	}

}
