package DynamicProgramming;

public class NinjaTraining {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        ninjaTraining(3, new int[][]{{1, 2, 5}, {3, 1, 1}, {3, 3, 3}});
    }

    public static int ninjaTraining(int n, int points[][]) {

        int result = dp(n - 1, 3, points);

        return result;
    }

    private static int dp(int index, int last, int points[][]) {

        if (index == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (last != i) {
                    maxi = Math.max(maxi, points[0][i]);
                    return maxi;
                }
            }
        }


        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int activity = points[index][i] + dp(index - 1, i, points);
                maxi = Math.max(maxi, activity);
            }

        }
        return maxi;

    }
}
