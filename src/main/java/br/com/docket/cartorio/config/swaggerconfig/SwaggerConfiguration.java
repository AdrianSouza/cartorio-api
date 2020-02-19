package br.com.docket.cartorio.config.swaggerconfig;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.docket.cartorio.entitys.model.entitys.Cartorio;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Cartorio API", 
	      "Creation of CRUD (Create, Read, Update, Delete) for the notary entity.", 
	      "1.0.0", 
	      "Terms of service", 
	      new Contact("Adrian de Souza Silva", "https://www.linkedin.com/in/adrian-s-2912a0129/", "adriandesouzasilva04@gmail.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

	
	@Bean
	public Docket cartorioApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.docket.cartorio"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(Cartorio.class).apiInfo(apiInfo());
	}
}
