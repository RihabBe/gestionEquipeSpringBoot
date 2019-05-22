package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;

@Repository
public interface IAuthDao extends JpaRepository<User,Long>{
	@Query(value = "from User where email= :emailParam and pwd= :pwdParam")
	public User findByEmailAndPwd(@Param("emailParam") String email, @Param("pwdParam")String pwd);
	
	@Query(value = "from User where email= :emailParam")
	public User findByEmail(@Param("emailParam") String email);
	
	public User findByEquipeId(Long id);
	
}
