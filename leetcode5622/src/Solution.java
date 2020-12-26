public class Solution {
    public double averageWaitingTime(int[][] customers) {
        int sum_time = 0;
        int next_time = 0;
        for (int[] customer : customers) {
            int arrive_time = customer[0];
            while (next_time > customer[0]) {
                customer[0]++;
            }
            next_time += customer[1];
            sum_time += next_time - arrive_time;
        }
        return (float) sum_time / customers.length;
    }
}
