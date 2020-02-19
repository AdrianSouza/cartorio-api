package br.com.docket.cartorio.advice;

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

import br.com.docket.cartorio.dto.advice.ErroDeValidacaoDTO;

@RestControllerAdvice
public class AdviceErrorHandler {
	@Autowired
	MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeValidacaoDTO> handler(MethodArgumentNotValidException exception) {
		List<ErroDeValidacaoDTO> errosDeFormulario = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(data -> {
			String message = messageSource.getMessage(data, LocaleContextHolder.getLocale());
			ErroDeValidacaoDTO erro = new ErroDeValidacaoDTO(data.getField(), message);
			errosDeFormulario.add(erro);
		});
		return errosDeFormulario;

	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public String handler(IllegalArgumentException exception) {
		return exception.getMessage();
	}
}
