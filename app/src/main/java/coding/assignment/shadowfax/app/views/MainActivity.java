package coding.assignment.shadowfax.app.views;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import coding.assignment.shadowfax.app.R;
import coding.assignment.shadowfax.app.models.CountriesDataFactory;
import coding.assignment.shadowfax.app.views.adapters.ParentAdapter;

public class MainActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private ParentAdapter parentAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
    }
    
    private void init() {
        recyclerView = findViewById(R.id.rv_parent);
        parentAdapter = new ParentAdapter();
        parentAdapter.setCountries(CountriesDataFactory.getCountries());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parentAdapter);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_id);
    
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        search(searchView);
        return true;
    }
    
    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            
            @Override
            public boolean onQueryTextChange(String newText) {
                parentAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}
