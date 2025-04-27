package org.example;

import java.util.HashMap;

public class Task5 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] pair = findPairWithSum(nums, target);
        if (pair != null) {
            System.out.println("Пара: " + pair[0] + ", " + pair[1]);
        } else {
            System.out.println("Пара не найдена");
        }
    }

    public static int[] findPairWithSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{complement, nums[i]};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
