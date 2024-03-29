// Assignement_2

// <aside>
// 💡 **Question 1**

// Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

// **Example 1:**
// Input: nums = [1,4,3,2]
// Output: 4

// **Explanation:** All possible pairings (ignoring the ordering of elements) are:

// 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
// 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
// 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
// So the maximum possible sum is 4
// </aside>

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 1;i<nums.length;i+=2){
            sum += Math.min(nums[i],nums[i-1]);
        }
        return sum;
    }
}

// Question 2

// Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor. 

// The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice. 

// Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.

// Example 1:
// Input: candyType = [1,1,2,2,3,3]
// Output: 3

// Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.

class Solution {
    public int distributeCandies(int[] candyType) {
     HashSet <Integer> hashSet  = new  HashSet<>();
    //  HashSet contains unique elements only.
     for(int type:candyType){
         hashSet.add(type);
     }   
        return Math.min(hashSet.size(),candyType.length/2);
    }
}

// Question 3

// We define a harmonious array as an array where the difference between its maximum value
// and its minimum value is exactly 1.

// Given an integer array nums, return the length of its longest harmonious subsequence
// among all its possible subsequences.

// A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: nums = [1,3,2,2,5,2,3,7]
// Output: 5

// Explanation: The longest harmonious subsequence is [3,2,2,2,3].

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums)
            m.put(i,m.getOrDefault(i,0)+1);
        
        int max=0;
        for(int i:m.keySet())
            if(m.containsKey(i+1)) max=Math.max(max,m.get(i)+m.get(i+1)); 
        
        return max;
        
    }
}

// Question 4

// You have a long flowerbed in which some of the plots are planted, and some are not.
// However, flowers cannot be planted in adjacent plots.
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

// Example 1:
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i = 0;i<len && n > 0;i++){
            if(flowerbed[i] == 0){
                if( (i == 0 || flowerbed[i-1] == 0) && (i == len -1 || flowerbed[i+1] == 0)){
                    flowerbed[i] = 1;
                    n--;
                } 
            }
        }
         return n == 0;
    }
}

// Question 5
// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

// Example 1:
// Input: nums = [1,2,3]
// Output: 6

class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int product = 1;
        if(n == 3){
              ans =  nums[0] * nums[1] * nums[2];
        }else{
          Arrays.sort(nums);
          ans = Math.max(nums[n-1] * nums[n-2] * nums[n-3] , nums[n-1] * nums[0] * nums[1]);
        }

        return ans;

        
    }
}

// Question 6 (Binary Search)

// Given an array of integers nums which is sorted in ascending order, and an integer target,
// write a function to search target in nums. If target exists, then return its index. Otherwise,
// return -1.

// You must write an algorithm with O(log n) runtime complexity.

// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4

// Explanation: 9 exists in nums and its index is 4

class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target)
            {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}

// Question 7
// An array is monotonic if it is either monotone increasing or monotone decreasing.

// An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is
// monotone decreasing if for all i <= j, nums[i] >= nums[j].

// Given an integer array nums, return true if the given array is monotonic, or false otherwise.

// Example 1:
// Input: nums = [1,2,2,3]
// Output: true

class Solution {
    public boolean isMonotonic(int[] nums) {
    if (nums.length <= 1) {
        return true;
    } 
    int m = 0, n = 0;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] >= nums[i-1]) m++;
        if (nums[i] <= nums[i-1]) n++;
    }
    if (m == nums.length - 1) return true;
    else if (n == nums.length - 1) return true;
    else return false;
    }
}