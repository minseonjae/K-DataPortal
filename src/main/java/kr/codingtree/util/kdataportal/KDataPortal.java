package kr.codingtree.util.kdataportal;

import kr.codingtree.util.URLBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@UtilityClass
public class KDataPortal {

    public final String BUS_STTN_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCrdntPrxmtSttnList";
    public final String BUS_ROUTE_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteInfoIem";
    public final String BUS_LOCATION_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusLcInfoInqireService/getRouteAcctoBusLcList";
    public final String BUS_ARRIVAL_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList";

    public String test() {
        URLBuilder builder = new URLBuilder("http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCtyCodeList");
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json");

        return getData(builder);
    }

    public String getSttnInfo(double gpsLati, double gpsLong) {
        URLBuilder builder = new URLBuilder(BUS_STTN_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", "1")                        // 페이지 번호
                .append("numOfRows", "10")                    // 한 페이지 결과 수
                .append("gpsLati", String.valueOf(gpsLati))   // WGS84 위도 37.67777
                .append("gpsLong", String.valueOf(gpsLong));  // WGS84 경도 126.79619

        return getData(builder);
    }

    public String getRouteInfo() {
        URLBuilder builder = new URLBuilder(BUS_ROUTE_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("cityCode", "10")          // 도시 코드
                .append("routeId", "DJB30300004"); // 노선 ID

        return getData(builder);
    }

    public String getLocationInfo() {
        URLBuilder builder = new URLBuilder(BUS_LOCATION_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", "1")             // 페이지 번호
                .append("numOfRows", "10")         // 한 페이지 결과 수
                .append("cityCode", "25")          // 도시 코드
                .append("routeId", "DJB30300052"); // 노선 ID

        return getData(builder);
    }

    public String getArrivalInfo() {
        URLBuilder builder = new URLBuilder(BUS_ARRIVAL_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", "1")           // 페이지 번호
                .append("numOfRows", "10")       // 한 페이지 결과 수
                .append("cityCode", "25")        // 도시 코드
                .append("nodeId", "DJB8001793"); // 정류장 ID

        return getData(builder);
    }

    @SneakyThrows
    private String getData(URLBuilder builder) {
        System.out.println(builder.toURL().toString());
        HttpURLConnection connection = (HttpURLConnection) builder.toURL().openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type", "application/json");

        BufferedReader rd = null;

        if(connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        connection.disconnect();

        return sb.toString();
    }
}
