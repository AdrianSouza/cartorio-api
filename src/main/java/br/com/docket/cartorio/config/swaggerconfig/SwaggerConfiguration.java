package br.com.docket.cartorio.config.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.docket.cartorio.entitys.model.entitys.Cartorio;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket cartorioApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.docket.cartorio"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(Cartorio.class);
	}
}
