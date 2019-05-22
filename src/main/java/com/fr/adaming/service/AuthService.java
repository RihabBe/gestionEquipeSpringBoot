package com.fr.adaming.service;

import java.sql.SQLIntegrityConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IAuthDao;
import com.fr.adaming.entity.User;
@Service
public class AuthService implements IAuthService{
	@Autowired
	private IAuthDao daoAuth;
	
	private Logger log = Logger.getLogger(UserService.class);
	
	
	@Override
	public User login(String email, String pwd) {
		User u= new User();
		try {
			u= daoAuth.findByEmailAndPwd(email, pwd);
		}catch (Exception e) {
			if(e instanceof NullPointerException) {
				log.info("Email NULL: opération non effectuée", e);
			}
			return null;
		}
		return u;
	}

	@Override
	public User register(User user) {
		try {
			user= daoAuth.save(user);
		}catch(Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				log.info("Email existant: opération non effectuée ");
			} else if (e instanceof SQLIntegrityConstraintViolationException){
				log.error("impossible", e);
			}else if(e instanceof NullPointerException) {
				log.error("UNKNOWN ERROR", e);
			}return null;
		}
		return user;
	}

}
