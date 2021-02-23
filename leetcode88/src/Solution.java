public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int j = m - 1;
        int k = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (nums1[j] >= nums2[k]) {
                nums1[i] = nums1[j];
                nums1[j] = 0;
                j--;
                if (j == -1) {
                    for (int temp = 0; temp <= k; temp++) {
                        nums1[temp] = nums2[temp];
                    }
                    return;
                }
            } else if (nums1[j] < nums2[k]) {
                nums1[i] = nums2[k];
                k--;
                if (k == -1) {
                    return;
                }
            }
        }
        return;
    }
//参考答案，和我的算法一样，但是比我写得更简洁
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
