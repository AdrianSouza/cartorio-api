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

@Controller
@RequestMapping("cartorio/")
public interface ICartorioController<T, K> {

	@PostMapping("teste/")
	public ResponseEntity<?> save(@Valid @RequestBody T cartorioDTO) throws SQLException;

	@PatchMapping("teste2/")
	public ResponseEntity<?> patch(@RequestBody T cartorioDTO)throws SQLException;
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<K> delete(@PathVariable K id);
	
	@GetMapping("id/{id}")
	public ResponseEntity<T> findById(@PathVariable K id);
	
	@GetMapping("teste5/")
	public ResponseEntity<List<T>> findByIds(@RequestBody List<K> cartorioIds);
	
	@GetMapping("pageable/")
	public ResponseEntity<List<T>> findAll(@PageableDefault(page = 0, size = 15) Pageable pageable);

}
