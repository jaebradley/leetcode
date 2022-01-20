package problems._1395;

public class Solution {
    public int numTeams(int[] rating) {
        int result = 0;
        for (int i = 1; i < rating.length - 1; i += 1) {
            int countOfGreaterRatingsLeftOfI = 0;
            int countOfLowerRatingsLeftOfI = 0;
            int countOfGreaterRatingsRightOfI = 0;
            int countOfLowerRatingsRightOfI = 0;

            for (int j = 0; j < rating.length; j += 1) {
                if (rating[i] > rating[j]) {
                    if (i > j) {
                        countOfLowerRatingsLeftOfI += 1;
                    } else if (j > i) {
                        countOfLowerRatingsRightOfI += 1;
                    }
                } else if (rating[i] < rating[j]) {
                    if (i > j) {
                        countOfGreaterRatingsLeftOfI += 1;
                    } else if (j > i) {
                        countOfGreaterRatingsRightOfI += 1;
                    }
                }
            }

            result += (countOfGreaterRatingsLeftOfI * countOfLowerRatingsRightOfI) + (countOfLowerRatingsLeftOfI * countOfGreaterRatingsRightOfI);
        }

        return result;
    }
}
