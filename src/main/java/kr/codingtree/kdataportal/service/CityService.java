package kr.codingtree.kdataportal.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import kr.codingtree.kdataportal.KDataPortal;
import kr.codingtree.kdataportal.data.DataFetcher;
import kr.codingtree.kdataportal.key.DataPortalKey;
import kr.codingtree.kdataportal.util.URLBuilder;

import java.util.HashMap;

public class CityService {

    public HashMap<Integer, String> getCityCodes() {
        URLBuilder builder = new URLBuilder(KDataPortal.CITY_CODE_LIST_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json");

        JsonElement element = JsonParser.parseString(DataFetcher.fetchData(builder));

        HashMap<Integer, String> cityCodes = new HashMap<>();

        element.getAsJsonObject()
                .getAsJsonObject("response")
                .getAsJsonObject("body")
                .getAsJsonObject("items")
                .getAsJsonArray("item").forEach(value -> {
                    int code = value.getAsJsonObject().get("citycode").getAsInt();
                    String name = value.getAsJsonObject().get("cityname").getAsString();

                    cityCodes.put(code, name);
                });

        return cityCodes;
    }

}
