package kr.codingtree.kdataportal.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import kr.codingtree.kdataportal.KDataPortal;
import kr.codingtree.kdataportal.data.DataFetcher;
import kr.codingtree.kdataportal.key.DataPortalKey;
import kr.codingtree.kdataportal.model.BusArrivalInfoResponse;
import kr.codingtree.kdataportal.model.BusRouteInfoResponse;
import kr.codingtree.kdataportal.model.BusRouteLocationsResponse;
import kr.codingtree.kdataportal.model.NearbyBusStationsResponse;
import kr.codingtree.kdataportal.util.URLBuilder;

public class BusService {

    /**
     * 특정 위치(gps 위도와 경도)를 기준으로 주변의 버스 정류장을 조회합니다.
     *
     * @param pageNo   요청할 페이지 번호
     * @param numOfRows 한 페이지에서 가져올 정류장 수
     * @param gpsLati WGS84 위도
     * @param gpsLong WGS84 경도
     * @return NearbyBusStationsResponse 주변 정류장 정보를 담은 응답 객체
     */
    public NearbyBusStationsResponse getNearbyStations(int pageNo, int numOfRows, double gpsLati, double gpsLong) {
        URLBuilder builder = new URLBuilder(KDataPortal.BUS_STTN_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", String.valueOf(pageNo))         // 페이지 번호
                .append("numOfRows", String.valueOf(numOfRows))   // 한 페이지 결과 수
                .append("gpsLati", String.valueOf(gpsLati))       // WGS84 위도  :  예제 37.67777
                .append("gpsLong", String.valueOf(gpsLong));      // WGS84 경도  :  예제 126.79619

        JsonElement result = JsonParser.parseString(DataFetcher.fetchData(builder))
                                    .getAsJsonObject()
                                    .getAsJsonObject("response")
                                    .getAsJsonObject("body");

        NearbyBusStationsResponse response = new Gson().fromJson(result, NearbyBusStationsResponse.class);

        if (KDataPortal.isDebugMode()) {
            System.out.println(response);
        }

        return response;
    }

    /**
     * 특정 정류장의 도착 예정 버스 정보를 조회합니다.
     *
     * @param pageNo 요청할 페이지 번호
     * @param numOfRows 한 페이지에서 가져올 도착 정보 수
     * @param cityCode 해당 정류장이 속한 도시 코드
     * @param nodeId 정류장 ID
     * @return BusArrivalInfoResponse 정류장 도착 정보를 담은 응답 객체
     */
    public BusArrivalInfoResponse getStationArrivalInfo(int pageNo, int numOfRows, int cityCode, String nodeId) {
        URLBuilder builder = new URLBuilder(KDataPortal.BUS_ARRIVAL_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", String.valueOf(pageNo))         // 페이지 번호
                .append("numOfRows", String.valueOf(numOfRows))   // 한 페이지 결과 수
                .append("cityCode", String.valueOf(cityCode))     // 도시 코드
                .append("nodeId", String.valueOf(nodeId));        // 정류장 ID

        JsonElement result = JsonParser.parseString(DataFetcher.fetchData(builder))
                                    .getAsJsonObject()
                                    .getAsJsonObject("response")
                                    .getAsJsonObject("body");

        BusArrivalInfoResponse response = new Gson().fromJson(result, BusArrivalInfoResponse.class);

        if (KDataPortal.isDebugMode()) {
            System.out.println(response);
        }

        return response;
    }

    /**
     * 특정 정류장에서 특정 노선의 도착 정보를 조회합니다.
     *
     * @param pageNo 요청할 페이지 번호
     * @param numOfRows 한 페이지에서 가져올 도착 정보 수
     * @param cityCode 해당 정류장이 속한 도시 코드
     * @param nodeId 정류장 ID
     * @param routeId 노선 ID
     * @return BusArrivalInfoResponse 노선 도착 정보를 담은 응답 객체
     */
    public BusArrivalInfoResponse getRouteArrivalInfo(int pageNo, int numOfRows, int cityCode, String nodeId, String routeId) {
        URLBuilder builder = new URLBuilder(KDataPortal.BUS_SPECIFIC_ROUTE_ARRIVAL_INFO_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", String.valueOf(pageNo))         // 페이지 번호
                .append("numOfRows", String.valueOf(numOfRows))   // 한 페이지 결과 수
                .append("cityCode", String.valueOf(cityCode))     // 도시 코드
                .append("nodeId", String.valueOf(nodeId))         // 정류장 ID
                .append("routeId", String.valueOf(routeId));      // 노선 ID

        JsonElement result = JsonParser.parseString(DataFetcher.fetchData(builder))
                                    .getAsJsonObject()
                                    .getAsJsonObject("response")
                                    .getAsJsonObject("body");

        BusArrivalInfoResponse response = new Gson().fromJson(result, BusArrivalInfoResponse.class);

        if (KDataPortal.isDebugMode()) {
            System.out.println(response);
        }

        return response;
    }

    /**
     * 특정 노선의 상세 정보를 조회합니다.
     *
     * @param cityCode 노선이 속한 도시 코드
     * @param routeId 노선 ID
     * @return BusRouteInfoResponse 노선 정보를 담은 응답 객체
     */
    public BusRouteInfoResponse getRouteInfo(int cityCode, String routeId) {
        URLBuilder builder = new URLBuilder(KDataPortal.BUS_ROUTE_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("cityCode", String.valueOf(cityCode))  // 도시 코드
                .append("routeId", routeId);                   // 노선 ID


        JsonElement result = JsonParser.parseString(DataFetcher.fetchData(builder))
                                    .getAsJsonObject()
                                    .getAsJsonObject("response")
                                    .getAsJsonObject("body")
                                    .getAsJsonObject("items")
                                    .getAsJsonObject("item");

        BusRouteInfoResponse response = new Gson().fromJson(result, BusRouteInfoResponse.class);

        if (KDataPortal.isDebugMode()) {
            System.out.println(response);
        }

        return response;
    }

    /** 특정 노선의 버스 위치 정보를 조회합니다.
     *
     * @param pageNo 조회할 페이지 번호
     * @param numOfRows 한 페이지에 포함될 데이터 수
     * @param cityCode 조회할 도시의 코드
     * @param routeId 조회할 버스 노선 ID
     * @return BusRouteLocationsResponse 버스 위치 정보를 담은 응답 객체
     */
    public BusRouteLocationsResponse getBusRouteLocations(int pageNo, int numOfRows, int cityCode, String routeId) {
        URLBuilder builder = new URLBuilder(KDataPortal.BUS_LOCATION_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", String.valueOf(pageNo))         // 페이지 번호
                .append("numOfRows", String.valueOf(numOfRows))   // 한 페이지 결과 수
                .append("cityCode", String.valueOf(cityCode))     // 도시 코드
                .append("routeId", String.valueOf(routeId));      // 노선 ID

        JsonElement result = JsonParser.parseString(DataFetcher.fetchData(builder))
                .getAsJsonObject()
                .getAsJsonObject("response")
                .getAsJsonObject("body");

        BusRouteLocationsResponse response = new Gson().fromJson(result, BusRouteLocationsResponse.class);

        if (KDataPortal.isDebugMode()) {
            System.out.println(response);
        }

        return response;
    }
}
