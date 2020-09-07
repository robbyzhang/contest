class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total_pts = 0;
        int sum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < n; i++)
        {
            total_pts += cardPoints[i];
            if (i < n - k)
                sum += cardPoints[i];
        }

        int max = total_pts - sum;
        for (int i = 0; i < k; i++)
        {
            sum = sum - cardPoints[i];
            sum = sum + cardPoints[n-k+i];
            max = Math.max(max, total_pts - sum);
        }
        return max;
    }
}