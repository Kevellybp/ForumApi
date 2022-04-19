package com.api.forum.config.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ErrorDTO {

	
	private String campo;
	private String erro;
}
