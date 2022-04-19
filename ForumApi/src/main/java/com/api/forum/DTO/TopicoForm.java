package com.api.forum.DTO;


import javax.validation.constraints.NotBlank;

import com.api.forum.model.Curso;
import com.api.forum.model.Topico;
import com.api.forum.repository.CursoRepository;


import lombok.Data;

@Data
public class TopicoForm {

	@NotBlank
	private String titulo;
	@NotBlank
	private String mensagem;
	@NotBlank
	private String nomeCurso;
	
	public Topico converter(CursoRepository repository) {
		Curso curso = repository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}


	
}
