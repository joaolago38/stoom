package br.com.stoom.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.stoom.model.Endereco;
import org.springframework.http.HttpStatus;
import java.util.Optional;

import javax.validation.Valid;

import br.com.stoom.repository.EnderecoRepository;
import br.com.stoom.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private EnderecoService enderecoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}

	@GetMapping("/{endereco}")
	public ResponseEntity<Optional<Endereco>> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Endereco> endereco = enderecoRepository.findById(codigo);
		if (endereco != null)
			return ResponseEntity.ok(endereco);
		else
			return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		enderecoRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long codigo, @Valid @RequestBody Endereco endereco) {
		Endereco enderecosalvo = enderecoService.atualizar(codigo, endereco);
		return ResponseEntity.ok(enderecosalvo);
	}

	

}
