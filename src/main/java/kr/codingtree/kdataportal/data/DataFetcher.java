package kr.codingtree.kdataportal.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kr.codingtree.kdataportal.KDataPortal;
import kr.codingtree.kdataportal.util.URLBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@UtilityClass
public class DataFetcher {

    @SneakyThrows
    public String fetchData(String url) {
        return fetchData(new URL(url));
    }

    @SneakyThrows
    public String fetchData(URLBuilder builder) {
        return fetchData(builder.toURL());
    }

    @SneakyThrows
    public String fetchData(URL url) {
        if (KDataPortal.isDebugMode()) {
            System.out.println("Debug fetchData URL  :  " + url.toString());
        }

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type", "application/json");

        BufferedReader rd = null;

        if(connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            if (KDataPortal.isDebugMode()) {
                System.out.println("Debug fetchData InputStream");
            }

        } else {
            rd = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

            if (KDataPortal.isDebugMode()) {
                System.out.println("Debug fetchData ErrorStream");
            }

        }

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        connection.disconnect();

        if (KDataPortal.isDebugMode()) {
            System.out.println("Debug fetchData JSON to String : " + sb.toString());
        }

        return sb.toString();
    }

}
