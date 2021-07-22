
package za.co.nkosana.starwarsapiassesment;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import za.co.nkosana.starwarsapiassesment.Data.PeopleDatabase;
import za.co.nkosana.starwarsapiassesment.Model.Person;
import za.co.nkosana.starwarsapiassesment.Data.PersonDao;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // getting extras
        Bundle extras = getIntent().getExtras();

        // displaying details of hero in Details activity

        TextView name = findViewById(R.id.hero_name);
        name.setText(extras.getString("name"));

        TextView height = findViewById(R.id.hero_height);
        height.setText("HEIGHT: " + extras.getString("height"));

        TextView weight = findViewById(R.id.hero_weight);
        weight.setText("WEIGHT: " + extras.getString("weight"));

        TextView hair = findViewById(R.id.hero_hair);
        hair.setText("HAIR COLOR: " + extras.getString("hair"));

        TextView skin = findViewById(R.id.hero_skin);
        skin.setText("SKIN COLOR: " + extras.getString("skin"));

        TextView eyes = findViewById(R.id.hero_eye);
        eyes.setText("EYE COLOR: " + extras.getString("eyes"));

        TextView gender = findViewById(R.id.hero_gender);
        gender.setText("GENDER: " + extras.getString("gender"));

        // saving details to a local DB
        PeopleDatabase database = Room.databaseBuilder(this, PeopleDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();

        PersonDao personDAO = database.personDAO();
        Person person = new Person();

        person.setName(extras.getString("name"));
        person.setHeight(extras.getString("height"));
        person.setMass(extras.getString("weight"));
        person.setHair_color(extras.getString("hair"));
        person.setSkin_color(extras.getString("skin"));
        person.setEye_color(extras.getString("eyes"));
        person.setGender(extras.getString("gender"));

        personDAO.insert(person);

    }

}
