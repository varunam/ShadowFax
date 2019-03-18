package coding.assignment.shadowfax.app.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varun.am on 18/03/19
 */
public class CountriesDataFactory {
    
    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        
        List<City> cities = new ArrayList<>();
        cities.add(new City("Bengaluru"));
        cities.add(new City("Mysuru"));
        cities.add(new City("New Delhi"));
        cities.add(new City("Mumbai"));
        cities.add(new City("Hyderabad"));
        Country india = new Country("India", cities);
        countries.add(india);
        
        cities= new ArrayList<>();
        cities.add(new City("Bangkok"));
        cities.add(new City("Pattaya"));
        cities.add(new City("Chiang Rai"));
        cities.add(new City("Chiang Mai"));
        cities.add(new City("Hat yai"));
        Country thailand = new Country("Thailand", cities);
        countries.add(thailand);
        
        cities= new ArrayList<>();
        cities.add(new City("New york city"));
        cities.add(new City("Chicago"));
        cities.add(new City("Los Angeles"));
        cities.add(new City("San Fansisco"));
        cities.add(new City("Washington D.C"));
        Country america = new Country("U.S", cities);
        countries.add(america);
        
        cities= new ArrayList<>();
        cities.add(new City("London"));
        cities.add(new City("Manchester"));
        cities.add(new City("Bristol"));
        cities.add(new City("Liverpool"));
        cities.add(new City("Edinburgh"));
        Country uk = new Country("U.K", cities);
        countries.add(uk);
        
        cities= new ArrayList<>();
        cities.add(new City("Melbourne"));
        cities.add(new City("Sydney"));
        cities.add(new City("Perth"));
        cities.add(new City("Canberra"));
        cities.add(new City("Brisbane"));
        Country australia = new Country("Australia", cities);
        countries.add(australia);
        
        return countries;
        
    }
}
