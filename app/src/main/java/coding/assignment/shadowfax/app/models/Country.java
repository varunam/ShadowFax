package coding.assignment.shadowfax.app.models;

import java.util.List;

/**
 * Created by varun.am on 18/03/19
 */
public class Country {
    private String title;
    private List<City> cities;
    
    public Country(String title, List<City> cities) {
        this.title = title;
        this.cities = cities;
    }
    
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
    
    public String getTitle() {
        return title;
    }
    
    public List<City> getCities() {
        return cities;
    }
}
