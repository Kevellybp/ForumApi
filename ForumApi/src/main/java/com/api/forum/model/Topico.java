package com.api.forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Topico {

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
	
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Curso curso;
	@OneToMany(mappedBy = "topico")
	private List<Resposta> respostas = new ArrayList<>();


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Topico(String titulo2, String mensagem2, Curso curso2) {
		// TODO Auto-generated constructor stub
	}

	

//	public Topico(String titulo2, String mensagem2, Curso curso2) {
//		// TODO Auto-generated constructor stub
//	}

	

}
