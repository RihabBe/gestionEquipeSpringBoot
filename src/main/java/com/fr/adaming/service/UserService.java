package com.fr.adaming.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao dao;

	private Logger log = Logger.getLogger(UserService.class);

	// create user seulement si user.getId()==null
	// user.getId()==0
	// dao.existsById(user.getId()))==false
	public User create(User user) {
		if (user.getId() == null || user.getId() == 0 || dao.existsById(user.getId()) == false) {
			try {
				user = dao.save(user);
			}catch (Exception e) {
				if (e instanceof IllegalArgumentException) {
					log.info("user null opération non effectuée ");
				}else if(e instanceof DataIntegrityViolationException){
					log.info("DataIntegrityViolationException ERROR", e);
				}else if(e instanceof ConstraintViolationException) {
					log.info("ConstraintViolationException ERROR", e);
				}else if (e instanceof SQLIntegrityConstraintViolationException) {
					log.info("SQLIntegrityConstraintViolationException ERROR", e);
				}else if (e instanceof NullPointerException) {
					log.info("NullPointerException ERROR", e);
				}
			}
			
		} else {
			// afficher un msg si user.getId()!=null
			log.debug("Ce user a un id différent de null");
//		System.out.println("DEBUG create: fail car user.getId() !=null");
		}
		return user;
	}

	@Override
	public User readByID(Long id) {
		User user = null;
		try {
			user = dao.findById(id).get();
		} catch (Exception e) {
			if (e instanceof IllegalArgumentException) {
				log.info("ID  null opération non effectuée ");
			} else {
				log.error(e.getStackTrace());
			}
		}
		return user;

	}

	@Override
	public List<User> readAll() {
		List<User> list = dao.findAll();
		return list;
	}

	@Override
	// update uniquement si user.getId Exist || user.getId()!=null
	// ||equipe.getId()!=0
	public void update(User user) {
		user = null;

		if (user.getId() != null || user.getId() != 0 || dao.existsById(user.getId())) {
			try {
				dao.save(user);
			} catch (Exception e) {
				if (e instanceof IllegalArgumentException) {
					log.info("ID  null opération non effectuée ");
				} else {
					log.error(e.getStackTrace());
				}
			}
		} else {
			log.debug("DEBUG update: pas de user avec cet id");
		}
	}

	@Override
	public boolean delete(Long id) {
		try{
			dao.deleteById(id);
			
		}catch(Exception e) {
			if (e instanceof EmptyResultDataAccessException) {
				log.info("ID  n'exite pas opération non effectuée ");
			} else if(e instanceof IllegalArgumentException){
				log.info("ID NULL opération non effectuée ");
				log.error(e.getStackTrace());
			}
			}return !dao.existsById(id);
		}

	@Override
	public User getByEmail(User user) {
		User userReturn= dao.findByEmail(user.getLongin());
		return userReturn;
	}

	}


