package com.fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	public User(String nameUser, String lastName, String longin, String pwd, Equipe equipe) {
		super();
		this.nameUser = nameUser;
		this.lastName = lastName;
		this.longin = longin;
		this.pwd = pwd;
		this.equipe = equipe;
	}

	public User(Long id, String nameUser, String lastName, String longin, String pwd) {
		super();
		this.id = id;
		this.nameUser = nameUser;
		this.lastName = lastName;
		this.longin = longin;
		this.pwd = pwd;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nameUser;

	private String lastName;

	@Column(unique = true)
	private String longin;

	private String pwd;

	@ManyToOne
	@JoinColumn
	private Equipe equipe;

}
