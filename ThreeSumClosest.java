// Find a triplet in an array whose sum is closest to a given number

// Given an array arr[] of N integers and an integer X, the task is to find three integers in arr[] such that the sum is closest to X.

// Examples:

// Input: arr[] = {-1, 2, 1, -4}, X = 1
// Output: 2
// Explanation:
// Sums of triplets:
// (-1) + 2 + 1 = 2
// (-1) + 2 + (-4) = -3
// 2 + 1 + (-4) = -1
// 2 is closest to 1.

// Input: arr[] = {1, 2, 3, 4, -5}, X = 10
// Output: 9
// Explanation:
// Sums of triplets:
// 1 + 2 + 3 = 6
// 2 + 3 + 4 = 9
// 1 + 3 + 4 = 7
// ...
// 9 is closest to 10.

import static java.lang.Math.abs;
import java.util.*;

public class ThreeSumClosest {
    static int solution(Vector<Integer> arr, int x) {

        Collections.sort(arr);

        long closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size() - 2; i++) {

            int ptr1 = i + 1, ptr2 = arr.size() - 1;

            while (ptr1 < ptr2) {

                int sum = arr.get(i) + arr.get(ptr1) + arr.get(ptr2);

                if (abs(x - sum) < abs(x - closestSum)) {
                    closestSum = sum;
                }

                if (sum > x) {
                    ptr2--;
                } else {
                    ptr1++;
                }
            }
        }

        return (int) closestSum;
    }

    public static void main(String[] args) {
        Vector arr = new Vector(Arrays.asList(-1, 2, 1, -4));
        int x = 1;
        System.out.println(solution(arr, x));
    }
}
