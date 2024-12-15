package kr.codingtree.kdataportal.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BusArrivalInfoResponse {

    @SerializedName("items")
    public ArrivalItems items;

    @SerializedName("numOfRows")
    public int numOfRows;

    @SerializedName("pageNo")
    public int pageNo;

    @SerializedName("totalCount")
    public int totalCount;

    @ToString
    public static class ArrivalItems {

        @SerializedName("item")
        public List<BusArrivalInfoItem> list;

    }

}
