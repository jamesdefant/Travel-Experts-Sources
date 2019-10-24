package data.REST;

import rest.API;

public class RewardData implements data.RewardData {
    @Override
    public String getReward(int rewardId) {

        // Call the API
        return API.getJson(Constants.URL + "/reward/getreward/" + rewardId);
    }

    @Override
    public String getAllRewards() {

        // Call the API
        return API.getJson(Constants.URL + "/reward/getallrewards");
    }
}
