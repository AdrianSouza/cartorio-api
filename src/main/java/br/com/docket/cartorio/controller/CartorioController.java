package br.com.docket.cartorio.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.docket.cartorio.entitys.dto.cartorio.CartorioDTO;
import br.com.docket.cartorio.service.CartorioService;

@RestController
public class CartorioController implements ICartorioController<CartorioDTO, Long> {

	@Autowired
	CartorioService cartorioService;
	
	@Override
	public ResponseEntity<?> save(CartorioDTO cartorioDTO) throws SQLException {
		Long id = cartorioService.save(cartorioDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("id/{id}").buildAndExpand(id)
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@Override
	public ResponseEntity<?> patch(CartorioDTO cartorioDTO) throws SQLException {
		cartorioService.patch(cartorioDTO);
		return null;
	}

	@Override
	public ResponseEntity<Long> delete(Long id) {
		return ResponseEntity.ok(cartorioService.delete(id));
	}

	@Override
	public ResponseEntity<CartorioDTO> findById(Long id) {
		CartorioDTO cartorioDTO = cartorioService.findById(id);
		return ResponseEntity.ok(cartorioDTO);
	}

	@Override
	public ResponseEntity<List<CartorioDTO>> findByIds(List<Long> cartorioIds) {
		List<CartorioDTO> listCartorioDTO = cartorioService.findByIds(cartorioIds);
		return ResponseEntity.ok(listCartorioDTO);
	}

	@Override
	public ResponseEntity<List<CartorioDTO>> findAll(Pageable pageable) {
		return ResponseEntity.ok(cartorioService.findAll(pageable));
	}
}
