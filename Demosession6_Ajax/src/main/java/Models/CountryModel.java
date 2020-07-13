package Models;

import java.util.ArrayList;
import java.util.List;

import entities.Country;
import entities.Province;

public class CountryModel {
	List<Country> countries = new ArrayList<Country>();

	public CountryModel() {
		Country country1 = new Country();
		country1.setId(1);
		country1.setName("country 1");
		country1.getProvinces().add(new Province(1, "Province 1"));
		country1.getProvinces().add(new Province(2, "Province 2"));
		country1.getProvinces().add(new Province(3, "Province 3"));
		countries.add(country1);

		Country country2 = new Country();
		country2.setId(2);
		country2.setName("country 2");
		country2.getProvinces().add(new Province(4, "Province 4"));
		country2.getProvinces().add(new Province(5, "Province 5"));
		country2.getProvinces().add(new Province(6, "Province 6"));
		countries.add(country2);

		Country country3 = new Country();
		country3.setId(3);
		country3.setName("country 3");
		country3.getProvinces().add(new Province(7, "Province 7"));
		country3.getProvinces().add(new Province(8, "Province 8"));

		countries.add(country3);
	}

	public List<Country> findall() {
		return countries;
	}

	public List<Province> findByCountry(int countryId) {
		for (Country country : countries) {
			if (country.getId() == countryId) {
				return country.getProvinces();
			}
		}
		return null;
	}
}
