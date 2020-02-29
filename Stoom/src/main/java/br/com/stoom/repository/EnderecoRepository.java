package br.com.stoom.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import  br.com.stoom.model.Endereco;
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	Endereco saveAll(Optional<Endereco> enderecoSalva);

}
