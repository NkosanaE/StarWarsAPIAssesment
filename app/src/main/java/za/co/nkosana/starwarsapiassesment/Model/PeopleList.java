/*
This class is a data model for RecyclerView
Created by Maxim G. on December 12, 2018
*/

package za.co.nkosana.starwarsapiassesment.Model;

public class PeopleList {

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String gender;

    public PeopleList(String name, String height, String mass, String hair_color, String skin_color, String eye_color, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getGender() {
        return gender;
    }

}
