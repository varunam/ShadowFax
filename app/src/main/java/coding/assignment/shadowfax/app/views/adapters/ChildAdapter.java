package coding.assignment.shadowfax.app.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import coding.assignment.shadowfax.app.R;
import coding.assignment.shadowfax.app.models.City;

/**
 * Created by varun.am on 18/03/19
 */
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    
    private List<City> cities;
    
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_recycler, viewGroup, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        City city = cities.get(i);
        viewHolder.textView.setText(city.getTitle());
    }
    
    @Override
    public int getItemCount() {
        if (cities != null)
            return cities.size();
        else
            return 0;
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            textView = itemView.findViewById(R.id.child_textView);
        }
    }
}
