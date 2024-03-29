package com.api.forum.config.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidationHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus (code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorDTO> handle(MethodArgumentNotValidException exception) {
		List<ErrorDTO> dto = new ArrayList<>();
		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();
		fieldErros.forEach(e -> {
			String mesagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorDTO erro = new ErrorDTO(e.getField(), mesagem);
			dto.add(erro);
			
		});
		return dto;
	}

}
