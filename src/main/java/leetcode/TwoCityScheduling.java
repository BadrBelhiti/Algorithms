package leetcode;

import java.util.Arrays;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int res = 0;

        for(int[] cost : costs){
            res += cost[0];
        }

        int[] refund = new int[costs.length];

        for(int i = 0; i < costs.length; i++){
            refund[i] = costs[i][1] - costs[i][0];
        }

        Arrays.sort(refund);

        for(int i = 0; i < refund.length / 2; i++){
            res += refund[i];
        }

        return res;
    }

}
