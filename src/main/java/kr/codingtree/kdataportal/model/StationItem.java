package kr.codingtree.kdataportal.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class StationItem {

    @SerializedName("citycode")
    private int cityCode;

    @SerializedName("gpslati")
    private double gpsLati;

    @SerializedName("gpslong")
    private double gpsLong;

    @SerializedName("nodeid")
    private String nodeId;

    @SerializedName("nodenm")
    private String nodeName;

    @SerializedName("nodeno")
    private int nodeNo;

}
