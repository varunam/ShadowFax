package coding.assignment.shadowfax.app.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import coding.assignment.shadowfax.app.R;
import coding.assignment.shadowfax.app.models.City;
import coding.assignment.shadowfax.app.models.Country;

/**
 * Created by varun.am on 18/03/19
 */
public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> implements Filterable {
    
    private List<Country> countries;
    private List<Country> filteredCountries;
    private Country country;
    //private int lastPosition = -1, oldPosition = -1;
    
    public void setCountries(List<Country> countries) {
        this.countries = countries;
        this.filteredCountries = countries;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_recycler, viewGroup, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        country = filteredCountries.get(i);
        viewHolder.title.setText(country.getTitle());
        ChildAdapter childAdapter = new ChildAdapter();
        childAdapter.setCities(country.getCities());
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(viewHolder.recyclerView.getContext()));
        viewHolder.recyclerView.setAdapter(childAdapter);
        new ItemTouchHelper(itemTouchCallbacks).attachToRecyclerView(viewHolder.recyclerView);
        
        /*viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldPosition = lastPosition;
                lastPosition = i;
                notifyItemChanged(lastPosition);
                notifyItemChanged(oldPosition);
            }
        });
        
        if (i == lastPosition) {
            viewHolder.recyclerView.setVisibility(View.VISIBLE);
        } else {
            viewHolder.recyclerView.setVisibility(View.GONE);
        }*/
    }
    
    @Override
    public int getItemCount() {
        if (filteredCountries != null)
            return filteredCountries.size();
        else
            return 0;
    }
    
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchedString = charSequence.toString().toLowerCase();
                List<Country> newCountries = new ArrayList<>();
                for(Country country: countries){
                    if(country.getTitle().toLowerCase().contains(searchedString)){
                        newCountries.add(country);
                    }
                }
                FilterResults results = new FilterResults();
                results.values = newCountries;
                return results;
            }
    
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredCountries = (List<Country>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView title;
        View layout;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            layout = itemView;
            recyclerView = itemView.findViewById(R.id.rv_child);
            title = itemView.findViewById(R.id.textView);
            
        }
    }
    
    private ItemTouchHelper.Callback itemTouchCallbacks = new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            int swipeFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            return makeMovementFlags(dragFlags, swipeFlags);
        }
        
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            return true;
        }
        
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        }
        
        @Override
        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int fromPos, @NonNull RecyclerView.ViewHolder target, int toPos, int x, int y) {
            Log.d("hello","Moved from " + fromPos + " to " + toPos);
            List<City> cities = country.getCities();
            City city = cities.get(fromPos);
            City newCity = new City(city.getTitle());
            cities.remove(fromPos);
            cities.add(toPos, newCity);
            country.setCities(cities);
            recyclerView.getAdapter().notifyItemMoved(fromPos, toPos);
        }
    };
}
