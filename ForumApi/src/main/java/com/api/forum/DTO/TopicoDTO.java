package com.api.forum.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.api.forum.model.Topico;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class TopicoDTO {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriação;

	

}
