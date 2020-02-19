package br.com.docket.cartorio.entitys.dto.cartorio;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CartorioDTO {

	@ApiModelProperty(value = "Id identificador de cartorio. </br>", example = "1", position = 1)
	private long id;

	@NotNull
	@Size(min = 5, max = 50)
	@ApiModelProperty(value = "Nome do documento.", example = "DocTeste", position = 3)
	private String nome;
}
