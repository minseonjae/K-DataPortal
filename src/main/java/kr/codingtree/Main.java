package kr.codingtree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import kr.codingtree.kdataportal.KDataPortal;

public class Main {

    public static void main(String[] args) {
        String json = KDataPortal.get;

        System.out.println(json);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(json));
    }

}