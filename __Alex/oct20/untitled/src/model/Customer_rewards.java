/**
 * Database access class to manipulate travelexperts.customer_rewards table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package model;

public class Customer_rewards {

    private int CustomerId;
    private int 	RewardId;
	private String RwdNumber;

    public Customer_rewards(int customerId, int rewardId, String rwdNumber) {
        CustomerId = customerId;
        RewardId = rewardId;
        RwdNumber = rwdNumber;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getRewardId() {
        return RewardId;
    }

    public void setRewardId(int rewardId) {
        RewardId = rewardId;
    }

    public String getRwdNumber() {
        return RwdNumber;
    }

    public void setRwdNumber(String rwdNumber) {
        RwdNumber = rwdNumber;
    }

    @Override
    public String toString() {
        return "Customer_rewards{" +
                "CustomerId=" + CustomerId +
                ", RewardId=" + RewardId +
                ", RwdNumber='" + RwdNumber + '\'' +
                '}';
    }
}
