package leetCode;

public class MedianOfTwoSortedArrays {
/*
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2}, nums3 = {1,2}, nums4 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums3, nums4));
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if ((m + n) % 2 != 0) // odd
            return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even
            return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }
    public static int findKth(int A[], int B[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;
        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
        int aMid = aLen * k / (aLen + bLen); // a’s middle count
        int bMid = k - aMid - 1; // b’s middle count
        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;
        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }
        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }

}
