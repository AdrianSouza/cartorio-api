package br.com.docket.cartorio.entitys.dto.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroDeValidacaoDTO {

	private String campo;

	private String erro;

}
