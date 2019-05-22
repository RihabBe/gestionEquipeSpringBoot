package com.fr.adaming.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

import com.fr.adaming.entity.User;

@RunWith(SpringRunner.class)
//grace à cette annoation SPRING va voir ces annotation
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTests {
	//on est entrain de tester le service donc, on injecte le service
		@Autowired
		private IUserService service;
		
		private static User resultUser;
		
		@Test
		public void a_createUserNotNull() {
			System.out.println("*************Start createUserNotNull **********");
			User testUser= new User(null,"nom1", "prenom1", "nom1@gmail.com", "azerty");
			
			resultUser= service.create(testUser);
			System.out.println("DEBUG USER ID after creation: "+resultUser.getId());
			//si l'objet Id est not null
			assertNotNull(resultUser.getId());
		}
		//create ValidUser/creatExistUser/createUserWithnullId, createUser wth id=0, createUserNull.
		//createUserWithidEqualToZero
		//aprés la méthod ede test de create, le user sera perssistent, donc tester la del sur cet objet, créer attribut de classe
		
		@Test
		public void b_createExistingUser() {
			System.out.println("************createExistingUser***************");
			User testUser = new User(null, "nameUser", "lastName", "longin@gmail.com", "azerty");
			resultUser=service.getByEmail(testUser);
			assertNull(resultUser);
		}
		@Test
		public void c_createUserNull() {
			System.out.println("************createUserNull***************");
			User testUser = null;
//			resultUser=service.readByID(testUser.getId());
			assertNull(resultUser);
		}
		
		@Test
		public void d_createMailInvalid() {
			System.out.println("************createMailInvalid***************");
			User testUser = new User(null, "nameUser", "lastName", "mail", "azerty");
			resultUser=service.getByEmail(testUser);
			assertNull(resultUser);
		}
		@Test
		public void e_createUserWIthIdNull() {
			System.out.println("************createUserWIthIdNull***************");
			
		}
		
		@Test
		public void f_deleteUser() {
			System.out.println("*************Start DELETE Test Method **********");
			User testUser= new User(null,"nameUser", "lastName", "longin@gmail.com", "azerty");
			
			resultUser= service.create(testUser);
			System.out.println("DEBUG USER ID: "+resultUser);	
			boolean resultat= service.delete(resultUser.getId());
			assertTrue(resultat);
			
			//pour que la méthode after n'envoie pas une requete delete à la BD
			resultUser= null;
		}
		
		@Before
		public void beforeMethod() {
			System.out.println("*************BEFORE Test Method **********");
		}
//		@After
		@Test
		public void afterMethod() {
			
			System.out.println("*************AFTER Test Method **********");
			service.getByEmail(resultUser);
			if(resultUser !=null && resultUser.getId() != null) {
				service.delete(resultUser.getId());
			}
		}
}
