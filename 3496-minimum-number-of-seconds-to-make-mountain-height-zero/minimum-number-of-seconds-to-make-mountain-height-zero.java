class Solution {
    public long minNumberOfSeconds(int mountainHeight_, int[] workerTimes_) {
        int n = workerTimes_.length;
        long mountainHeight = (long) mountainHeight_;
        long[] workerTimes = new long[n];
        for (int i = 0; i < n; i++) {
            workerTimes[i] = workerTimes_[i];
        }

        long multiplier = (1 + mountainHeight) * mountainHeight / 2;
        long r = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            r = Math.min(r, multiplier * workerTimes[i]);
        }
        long ans = r;

        long l = 1;
        while (l <= r) {
            long time = (l + r) / 2; // check max height can reduce within "time" seconds
            long sum = 0;
            for (int i = 0; i < n; i++) {
                long ll = 0;
                long rr = mountainHeight;
                long maxHeight = -1;
                while (ll <= rr) {
                    long mid = (ll + rr) / 2;
                    if ((1 + mid) * mid * workerTimes[i] <= 2 * time) {
                        maxHeight = mid;
                        ll = mid + 1;
                    } else {
                        rr = mid - 1;
                    }
                }
                if (maxHeight != -1) {
                    sum += maxHeight;
                    if (sum >= mountainHeight) {
                        break;
                    }
                }
            }
            if (sum >= mountainHeight) {
                ans = time;
                r = time - 1;
            } else {
                l = time + 1;
            }
        }
        return ans;
    }
}