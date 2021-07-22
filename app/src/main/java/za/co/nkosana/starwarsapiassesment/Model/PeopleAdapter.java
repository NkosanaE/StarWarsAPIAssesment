

package za.co.nkosana.starwarsapiassesment.Model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import za.co.nkosana.starwarsapiassesment.DetailsActivity;
import za.co.nkosana.starwarsapiassesment.Model.PeopleList;
import za.co.nkosana.starwarsapiassesment.R;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.MyViewHolder> {

    private List<PeopleList> peopleList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
        }
    }


    public PeopleAdapter(List<PeopleList> peopleList) {
        this.peopleList = peopleList;
    }


    // Create new views
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.people_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final PeopleList people = peopleList.get(position);
        holder.name.setText(people.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context c = v.getContext();
                Intent intent = new Intent(c, DetailsActivity.class);
                intent.putExtra("name", people.getName());
                intent.putExtra("height", people.getHeight());
                intent.putExtra("weight", people.getMass());
                intent.putExtra("hair", people.getHair_color());
                intent.putExtra("skin", people.getSkin_color());
                intent.putExtra("eyes", people.getEye_color());
                intent.putExtra("gender", people.getGender());
                c.startActivity(intent);

            }
        });


    }

    // Return the size of a dataset
    @Override
    public int getItemCount() {
        return peopleList.size();
    }
}

