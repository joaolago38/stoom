package stoom;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.stoom.model.Endereco;
import br.com.stoom.repository.EnderecoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EnderecoRepositoryTests {
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void criarEnderecoPersistirDados() {
		Endereco endereco = new Endereco(1L, "neturno", 398L, "casa", " neighbourhood", "city", "state", "country",
				"zipcode", 25, 30);
		this.enderecoRepository.save(endereco);
		Assertions.assertThat(endereco.getId()).isNull();
		Assertions.assertThat(endereco.getCity()).isEqualTo("city");
		Assertions.assertThat(endereco.getCountry()).isEqualTo("country");
		Assertions.assertThat(endereco.getNumber()).isEqualTo(398);
		Assertions.assertThat(endereco.getState()).isEqualTo("state");
		Assertions.assertThat(endereco.getNumber()).isEqualTo(456);
		Assertions.assertThat(endereco.getZipcode()).isEqualTo("zipcode");
		Assertions.assertThat(endereco.getNeighbourhood()).isEqualTo(" neighbourhood");
		Assertions.assertThat(endereco.getLongitude()).isNull();
	}

	public void deleteEnderecoDadosPersistidos() {

		Endereco endereco = new Endereco(1L, "neturno", 398L, "casa", " neighbourhood", "city", "state", "country",
				"zipcode", 25, 30);
		this.enderecoRepository.save(endereco);
		this.enderecoRepository.delete(endereco);
		Assertions.assertThat(enderecoRepository.findById(1L)).isNull();
	}
	
	public void atualizarEnderecoDadosPersistidos() {

		Endereco endereco = new Endereco(1L, "neturno", 398L, "casa", " neighbourhood", "city", "state", "country",
				"zipcode", 25, 30);
		endereco.setCity("city2");
        endereco.setCountry("country");
		this.enderecoRepository.save(endereco);
		Assertions.assertThat(endereco.getCity()).isEqualTo("city2");
		Assertions.assertThat(endereco.getCountry()).isEqualTo("country2");
		;
	}

}
