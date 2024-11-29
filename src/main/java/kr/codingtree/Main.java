package kr.codingtree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import kr.codingtree.util.kdataportal.KDataPortal;

public class Main {

    public static void main(String[] args) {
        String data = KDataPortal.test();

        System.out.println(data);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement json = JsonParser.parseString(data);

        System.out.println(gson.toJson(json));
    }

}