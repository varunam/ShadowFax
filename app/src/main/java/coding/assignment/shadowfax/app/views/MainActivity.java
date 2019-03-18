package coding.assignment.shadowfax.app.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
}
