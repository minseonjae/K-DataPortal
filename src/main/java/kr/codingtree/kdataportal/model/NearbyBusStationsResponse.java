package kr.codingtree.kdataportal.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class NearbyBusStationsResponse {

    @SerializedName("items")
    private BusStationItems items;

    @SerializedName("numOfRows")
    private int numOfRows;

    @SerializedName("pageNo")
    private int pageNo;

    @SerializedName("totalCount")
    private int totalCount;

    @Getter
    @ToString
    public static class BusStationItems {

        @SerializedName("item")
        private List<BusStationItem> list;

    }

}