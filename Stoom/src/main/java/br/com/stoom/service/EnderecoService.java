package br.com.stoom.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.stoom.geolocalizacao.Geolocalizacao;
import br.com.stoom.model.Endereco;
import br.com.stoom.repository.EnderecoRepository;

public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private Geolocalizacao geolocalizacao;
	public Endereco atualizar (Long codigo, Endereco endereco) {
		Optional<Endereco> enderecoSalva = enderecoRepository.findById(codigo);
				if (enderecoSalva == null) {
					throw new EmptyResultDataAccessException(1);
				}
				BeanUtils.copyProperties(endereco, enderecoSalva, "codigo");
				return enderecoRepository.saveAll(enderecoSalva);
		
		
	}
}
