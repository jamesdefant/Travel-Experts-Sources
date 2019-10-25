package data.dummy;

public class Customer_rewardsData implements data.Customer_rewardsData {
    @Override
    public String getCustomer_rewards(int customer_rewardsId) {

        return "{\"customerId\":104,\"rewardId\":1,\"rwdNumber\":\"123456 4322\"}";
    }

    @Override
    public String getAllCustomer_rewards() {

        return "[{\"CustomerId\":104,\"RewardId\":1,\"RwdNumber\":\"123456 4322\"},{\"CustomerId\":104,\"RewardId\":2,\"RwdNumber\":\"5435 678 CF\"},{\"CustomerId\":105,\"RewardId\":2,\"RwdNumber\":\"1435 678 CA\"},{\"CustomerId\":106,\"RewardId\":1,\"RwdNumber\":\"123456 4322\"},{\"CustomerId\":106,\"RewardId\":4,\"RwdNumber\":\"4643 23 5435\"},{\"CustomerId\":107,\"RewardId\":2,\"RwdNumber\":\"5735 638 CF\"},{\"CustomerId\":107,\"RewardId\":5,\"RwdNumber\":\"2354 4583 63A\"},{\"CustomerId\":108,\"RewardId\":1,\"RwdNumber\":\"129456 4322\"},{\"CustomerId\":109,\"RewardId\":4,\"RwdNumber\":\"4343 23 5435\"},{\"CustomerId\":109,\"RewardId\":5,\"RwdNumber\":\"2784 4553 63F\"},{\"CustomerId\":114,\"RewardId\":2,\"RwdNumber\":\"5875 678 CG\"},{\"CustomerId\":117,\"RewardId\":1,\"RwdNumber\":\"123456 4322\"},{\"CustomerId\":118,\"RewardId\":3,\"RwdNumber\":\"FG2343 785\"},{\"CustomerId\":123,\"RewardId\":2,\"RwdNumber\":\"5435 678 CF\"},{\"CustomerId\":127,\"RewardId\":1,\"RwdNumber\":\"113526 4322\"},{\"CustomerId\":138,\"RewardId\":1,\"RwdNumber\":\"124256 4322\"},{\"CustomerId\":140,\"RewardId\":4,\"RwdNumber\":\"4343 23 5435\"},{\"CustomerId\":142,\"RewardId\":1,\"RwdNumber\":\"123456 4322\"},{\"CustomerId\":142,\"RewardId\":3,\"RwdNumber\":\"FG2343 785\"},{\"CustomerId\":142,\"RewardId\":5,\"RwdNumber\":\"2254 4553 63Z\"}]";
    }
}
