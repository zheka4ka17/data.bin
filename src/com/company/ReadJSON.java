package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadJSON {
    public static void main(String[] args) throws IOException {
       FileReader fr = new FileReader("src/com/company/data/persons.json");
        JSONTokener jsonTokener= new JSONTokener(fr);
        JSONObject person = new JSONObject(jsonTokener);

        int id = person.getInt("id");
        System.out.println(id);

        String name = person.getString("name");
        System.out.println(name);

       JSONArray emails= person.getJSONArray("emails");
        for (int i = 0; i < emails.length(); i++)
            System.out.println(emails.get(i));
    }
}
