package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fr.adaming.entity.Equipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class RegisterDto {

	private String nameUser;
	
	private String lastName;
	
	@Email(message = "message soit respecter le pattern @")
	@NotNull
	private String longin;
	
	
	@NotNull
	private String pwd;
	
	private Equipe equipe;
}
