/*
This interface is an intermediary between the user and the database. All the operation to be performed on a table are defined here.
Created by Maxim G. on December 12, 2018
*/

package za.co.nkosana.starwarsapiassesment.Data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import za.co.nkosana.starwarsapiassesment.Model.Person;

@Dao
public interface PersonDao {

    @Insert
    void insert(Person per);

    @Query("Delete from Person_Table")
    void deleteAllPeople();

    @Query("Select * from person_table order by name ASC")
    List<Person> getPeopleList();

}