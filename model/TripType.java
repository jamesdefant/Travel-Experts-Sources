/**
 * Entity class to hold data for 1 row in travelexperts.TripTypes table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */

package model;

public class TripType {

    private String triptypeId;
    private String ttName; //nullable

    public String getTriptypeId() {
        return triptypeId;
    }

    public void setTriptypeId(String triptypeId) {
        this.triptypeId = triptypeId;
    }

    public String getTtName() {
        return ttName;
    }

    public void setTtName(String ttName) {
        this.ttName = ttName;
    }

    public TripType(String triptypeId, String ttName) {
        this.triptypeId = triptypeId;
        this.ttName = ttName;
    }

    @Override
    public String toString() {
        return "TripTypeDb{" +
                "triptypeId=" + triptypeId +
                ", ttName='" + ttName + '\'' +
                '}';
    }

}
