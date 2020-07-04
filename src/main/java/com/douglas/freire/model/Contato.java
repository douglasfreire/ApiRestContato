package com.douglas.freire.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contato")
public class Contato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	@NotNull
	private String nome;
	@Column
	@NotNull
	@Email(message = "campo email invalido")
	private String email;
	@Column
	@NotNull
	private String telefone;
	
	@Column
	private LocalDateTime dateCreated;
	
	public Contato() {}
	
	public Contato(Long id, String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	@PrePersist	
	public void onPrePersist() {
		if (this.dateCreated == null) {
			this.dateCreated = LocalDateTime.now();
		}
	}
	@PreUpdate
	public void onPreUpdate() {
		if (this.dateCreated != null) {
			this.dateCreated = LocalDateTime.now();
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", dateCreated="
				+ dateCreated + "]";
	}
	
	
	
}
