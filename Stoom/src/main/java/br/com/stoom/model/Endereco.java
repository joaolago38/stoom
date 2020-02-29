package br.com.stoom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;

import br.com.stoom.geolocalizacao.Geolocalizacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "pessoa")
public class Endereco implements Geolocalizacao {
	
	public Endereco(@NotNull Long id, @NotNull String streetName, @NotNull Long number, String complement,
			@NotNull String neighbourhood, @NotNull String city, @NotNull String state, @NotNull String country,
			@NotNull String zipcode, @NotNull Integer latitude, @NotNull Integer longitude) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.number = number;
		this.complement = complement;
		this.neighbourhood = neighbourhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Endereco() {

	}

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(name = "streetName")
	private String streetName;
	@NotNull
	private Long number;
	@Column(name = "complement")
	private String complement;
	@NotNull
	@Column(name = "neighbourhood")
	private String neighbourhood;
	@NotNull
	@Column(name = "city")
	private String city;
	@NotNull
	@Column(name = "city")
	private String state;
	@NotNull
	@Column(name = "country")
	private String country;
	@NotNull
	@Column(name = "zipcode")
	private String zipcode;
	@NotNull
	@Column(name = "latitude")
	private Integer latitude;
	@NotNull
	@Column(name = "longitude")
	private Integer longitude;

	final String API_KEY = "AIzaSyBm3xh9oZP1ksMWcMzVaZQevWlrtb8tIgc";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	@Override
	public Endereco localizaGeolocalizacao(Integer longitude, Integer latitude) {
		if (latitude == null || longitude == null) {
	        LOGGER.debug("latitude/longitude must not be null in order for geolocation to proceed");
	        return null;
	    }
	}
}
