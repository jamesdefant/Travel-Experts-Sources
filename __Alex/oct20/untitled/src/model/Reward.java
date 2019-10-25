/**
 * Entity class to hold data for 1 row in travelexperts.rewards table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */


package model;

public class Reward {
    private int RewardId;
	private String	RwdName	; //nullable
	private String	RwdDesc;//nullable


    public Reward(int rewardId, String rwdName, String rwdDesc) {
        RewardId = rewardId;
        RwdName = rwdName;
        RwdDesc = rwdDesc;
    }

    public int getRewardId() {
        return RewardId;
    }

    public void setRewardId(int rewardId) {
        RewardId = rewardId;
    }

    public String getRwdName() {
        return RwdName;
    }

    public void setRwdName(String rwdName) {
        RwdName = rwdName;
    }

    public String getRwdDesc() {
        return RwdDesc;
    }

    public void setRwdDesc(String rwdDesc) {
        RwdDesc = rwdDesc;
    }


    @Override
    public String toString() {
        return "Reward{" +
                "RewardId=" + RewardId +
                ", RwdName='" + RwdName + '\'' +
                ", RwdDesc='" + RwdDesc + '\'' +
                '}';
    }
}
