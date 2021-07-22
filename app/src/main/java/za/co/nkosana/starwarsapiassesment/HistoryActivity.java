/*
This activity displays detailed information retrieved from a local DB in RecyclerView
Created by Maxim G. on December 12, 2018
*/

package za.co.nkosana.starwarsapiassesment;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import za.co.nkosana.starwarsapiassesment.Data.PeopleDatabase;
import za.co.nkosana.starwarsapiassesment.Data.PersonDao;
import za.co.nkosana.starwarsapiassesment.Model.PeopleAdapter;
import za.co.nkosana.starwarsapiassesment.Model.PeopleList;
import za.co.nkosana.starwarsapiassesment.Model.Person;

public class HistoryActivity extends AppCompatActivity {

    private List<PeopleList> peopleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PeopleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // creating recyclerview for Local history activity
        recyclerView = findViewById(R.id.history_recycler_view);
        mAdapter = new PeopleAdapter(peopleList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        // getting heroes information from a local DB
        PeopleDatabase database = Room.databaseBuilder(this, PeopleDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();

        final PersonDao personDAO = database.personDAO();
        List<Person> people = personDAO.getPeopleList();

        for (Person per : people) {
            PeopleList heroes = new PeopleList(per.getName(), per.getHeight(),
                    per.getMass(), per.getHair_color(), per.getSkin_color(), per.getEye_color(),
                    per.getGender());
            peopleList.add(heroes);
        }

        mAdapter.notifyDataSetChanged();

        // clear history button
        Button clearHistory = findViewById(R.id.button_clear);
        clearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personDAO.deleteAllPeople();
                startActivity(getIntent());
                finish();
                overridePendingTransition(0, 0);
            }
        });


    }

}


