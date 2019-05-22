package com.fr.adaming;



import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GestionEquipeSpringBootApplication{
	
	public static void main(String[] args) {
		
//		SpringApplication.run(GestionEquipeSpringBootApplication.class, args);
		ApplicationContext context = SpringApplication.run(GestionEquipeSpringBootApplication.class, args);
//		Equipe e= new Equipe(1L, "FacNantes", "confirmé");
//		IEquipeService serviceEq = (IEquipeService)context.getBean("equipeService");
//		serviceEq.create(e);
//		
//		User u= new User(5L, "aaa", "aa", "aaa", "aa", e);
//		IUserService service = (IUserService)context.getBean("userService");
//		service.create(u);;
	

	Logger log =Logger.getLogger(GestionEquipeSpringBootApplication.class);
	log.trace("tarce");
	log.debug("debug");
	log.info("info");
	log.warn("warn");
	log.error("erreur");
	log.fatal("fatal");
	
	
	}
}
