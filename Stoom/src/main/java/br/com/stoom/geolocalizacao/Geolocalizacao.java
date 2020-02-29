package br.com.stoom.geolocalizacao;

import br.com.stoom.model.Endereco;

public interface Geolocalizacao {
  public Endereco localizaGeolocalizacao(Integer latitude, Integer longitude);
}
