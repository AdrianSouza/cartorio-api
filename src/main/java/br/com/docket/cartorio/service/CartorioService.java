package br.com.docket.cartorio.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.docket.cartorio.dto.cartorio.CartorioDTO;
import br.com.docket.cartorio.entity.Cartorio;
import br.com.docket.cartorio.repository.CartorioRepository;
import br.com.docket.cartorio.utils.DataTransfer;

@Service
public class CartorioService {

	@Autowired
	DataTransfer dataTransfer;

	@Autowired
	CartorioRepository cartorioRepository;

	public Long save(CartorioDTO cartorioDTO) throws SQLException {
		Cartorio cartorio = dataTransfer.copyToClassTarget(cartorioDTO, Cartorio.class);
		if (cartorioRepository.findById(cartorioDTO.getId()).isPresent()) {
			throw new SQLException("Cartorio já exite no banco");
		}
		Long id = cartorioRepository.save(cartorio).getId();
		return id;
	}

	public CartorioDTO findById(Long cartorioId) {
		CartorioDTO cartorioDTO = dataTransfer.copyToClassTarget(cartorioRepository.findById(cartorioId).get(),
				CartorioDTO.class);
		return cartorioDTO;
	}

	public List<CartorioDTO> findByIds(List<Long> cartorioIds) {
		List<Cartorio> listCartorio = cartorioRepository.findAllById(cartorioIds);
		List<CartorioDTO> listCartorioDTO = dataTransfer.copyToClassTarget(listCartorio, CartorioDTO.class);
		return listCartorioDTO;
	}

	public List<CartorioDTO> findAll(Pageable pageable) {
		return dataTransfer.copyToClassTarget(cartorioRepository.findAll(pageable).getContent(), CartorioDTO.class);
	}

	public Long delete(Long cartorioId) {
		cartorioRepository.deleteById(cartorioId);
		return cartorioId;
	}

	public Long patch(CartorioDTO cartorioDTO) throws SQLException {
		Optional<Cartorio> cartorio = cartorioRepository.findById(cartorioDTO.getId());
		if (!cartorio.isPresent()) {
			throw new SQLException("Cartorio não exite no banco");
		}
		dataTransfer.copyToObjectTarget(cartorioDTO, cartorio.get());
		cartorioRepository.save(cartorio.get());
		return cartorioDTO.getId();
	}

}
