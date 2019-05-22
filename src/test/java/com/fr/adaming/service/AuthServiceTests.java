package com.fr.adaming.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.dao.IAuthDao;
import com.fr.adaming.entity.User;

@RunWith(SpringRunner.class)
//grace à cette annoation SPRING va voir ces annotation
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthServiceTests {
	
	@Autowired
	private IUserService service;
	@Autowired
	private IAuthService serviceAuth;

	private static User resultUser;

	@Test
	public void a_registerExistingEmail() {
		System.out.println("*************Start FIRST Test Method **********");
		User testUser = new User(null, "nameUser", "lastName", "longin@gmail.com", "azerty");

		resultUser = serviceAuth.register(testUser);
		System.out.println("DEBUG USER ID after creation: " + resultUser.getId());
		// si l'objet Id est not null
		assertNull(resultUser.getId());
	}
	// create ValidUser/creatExistUser/createUserWithnullId, createUser wth id=0,
	// createUserNull.
	// createUserWithidEqualToZero
	// aprés la méthod ede test de create, le user sera perssistent, donc tester la
	// del sur cet objet, créer attribut de classe

//	@Test
//	public void b_registerEmailNull() {
//		User testUser = new User(null, "nameUser", "lastName", "longin@gmail.com", "azerty");
//		
//		resultUser = serviceAuth.register(testUser);
//		assertSame(resultUser, service.getByEmail(testUser));
//	}

	@Test
	public void c_createUserNull() {

	}

	@Test
	public void d_loginUserWIthEmailNull() {
		User testUser = new User(null, "nameUser", "lastName", null, "azerty");
		resultUser = serviceAuth.login(testUser.getLongin(),testUser.getPwd());
		
		//Message de DEBUG en utilisant l'Opérateur IF ternaire
		System.out.println("DEBUG loginUserWIthEmailNull(): " + (resultUser == null ? "User is NULL" : resultUser));
		// si l'objet Id est not null
		assertNull(resultUser);
	}
	
	@Test
	public void e_loginUserWIthPwdNull() {
		User u = new User(1L, "nameUser", "lastName", "longin@gmail.com", null);
		resultUser = serviceAuth.login(u.getLongin(),u.getPwd());
		
		//Message de DEBUG en utilisant l'Opérateur IF ternaire
		System.out.println("DEBUG loginUserWIthEmailNull(): " + (resultUser == null ? "User is NULL" : resultUser));
		// si l'objet Id est not null
		assertNull(resultUser);
	}
	@After
	public void f_deleteUser() {
		System.out.println("*************Start DELETE Test Method **********");
		System.out.println("DEBUG USER ID: " + resultUser);
		boolean resultat = service.delete(resultUser.getId());
		assertTrue(resultat);
	}
}
