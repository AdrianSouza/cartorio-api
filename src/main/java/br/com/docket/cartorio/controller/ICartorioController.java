package br.com.docket.cartorio.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("cartorio/")
@Api(value = "Cartorio controller")
public interface ICartorioController<T, K> {

	@PostMapping
	@ApiOperation(value = "Salva um cartorio.")
	public ResponseEntity<?> save(@Valid @RequestBody T cartorioDTO) throws SQLException;

	@PatchMapping
	@ApiOperation(value = "Altera um cartorio.")
	public ResponseEntity<?> patch(@RequestBody T cartorioDTO)throws SQLException;
		
	@DeleteMapping("id/{id}")
	@ApiOperation(value = "Deleta um cartorio.")
	public ResponseEntity<K> delete(@PathVariable K id);
	
	@GetMapping("id/{id}")
	@ApiOperation(value = "Procura um cartorio pelo id.")
	public ResponseEntity<T> findById(@PathVariable K id);
	
	@GetMapping
	@ApiOperation(value = "Procura um cartorio por varios id.")
	public ResponseEntity<List<T>> findByIds(@RequestBody List<K> cartorioIds);
	
	@GetMapping("pageable/")
	@ApiOperation(value = "Procura todos os cartorios paginados.")
	public ResponseEntity<List<T>> findAll(@PageableDefault(page = 0, size = 15) Pageable pageable);

}
