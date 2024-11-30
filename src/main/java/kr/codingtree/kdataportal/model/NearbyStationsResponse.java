package kr.codingtree.kdataportal.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class NearbyStationsResponse {

    @SerializedName("items")
    private StationItems items;

    @SerializedName("numOfRows")
    private int numOfRows;

    @SerializedName("pageNo")
    private int pageNo;

    @SerializedName("totalCount")
    private int totalCount;

    @Getter
    public static class StationItems {

        @SerializedName("item")
        private List<StationItem> itemList;

    }

}