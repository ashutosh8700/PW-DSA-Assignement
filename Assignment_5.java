import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.MediaSize.Other;

public class Assignment_5 {
    // <aside>
    // 💡 **Question 1**
    
    // Convert 1D Array Into 2D Array
    
    // You are given a **0-indexed** 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using **all** the elements from original.
    
    // The elements from indices 0 to n - 1 (**inclusive**) of original should form the first row of the constructed 2D array, the elements from indices n to 2 * n - 1 (**inclusive**) should form the second row of the constructed 2D array, and so on.
    
    // Return *an* m x n *2D array constructed according to the above procedure, or an empty 2D array if it is impossible*.
    
    // </aside>
   
    class Solution {
        public int[][] construct2DArray(int[] original, int m, int n) {
        int [][] arr=new int [m][n];
        if(original.length!=m*n)return new int[0][0];
        int ix=0;
             for(int i=0;i<arr.length;i++) {
             for(int j=0;j<arr[0].length;j++){
             arr[i][j]=original[ix++];
                  
             }
          
         }
         return arr;
        }
    } 
    
//     <aside>
// 💡 **Question 2**

// You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase **may be** incomplete.

// Given the integer n, return *the number of **complete rows** of the staircase you will build*.

// </aside>

class Solution {
    public int arrangeCoins(int n) {
        long left = 0,right = n;
        
        while(left <= right){
            long mid = left + (right - left)/2;
            long k = mid * (mid + 1) / 2;
            
            if(k == n){
                return (int)mid;
            }
            else if(k > n){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
           
        }
        return (int)right;
    }
}

// <aside>
// 💡 **Question 3**

// Given an integer array nums sorted in **non-decreasing** order, return *an array of **the squares of each number** sorted in non-decreasing order*.

// **Example 1:**

// **Input:** nums = [-4,-1,0,3,10]

// **Output:** [0,1,9,16,100]

// **Explanation:** After squaring, the array becomes [16,1,0,9,100].

// After sorting, it becomes [0,1,9,16,100].

// </aside>


class Solution {
    public int[] sortedSquares(int[] nums) {
        
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
}

// <aside>
// 💡 **Question 4**

// Given two **0-indexed** integer arrays nums1 and nums2, return *a list* answer *of size* 2 *where:*

// - answer[0] *is a list of all **distinct** integers in* nums1 *which are **not** present in* nums2*.*
// - answer[1] *is a list of all **distinct** integers in* nums2 *which are **not** present in* nums1.

// **Note** that the integers in the lists may be returned in **any** order.

// **Example 1:**

// **Input:** nums1 = [1,2,3], nums2 = [2,4,6]

// **Output:** [[1,3],[4,6]]

// **Explanation:**

// For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].

// For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

// </aside>


class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        //adding elemets to sets
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }

        ArrayList<Integer> diff1=new ArrayList<>();
        ArrayList<Integer> diff2=new ArrayList<>();

        //adding elements to arraylists
        for(int num:set1){
            if(! set2.contains(num)){
                diff1.add(num);
            }
        }
        for(int num:set2){
            if(! set1.contains(num)){
                diff2.add(num);
            }
        }

        List<List<Integer>> answer=new ArrayList<>();
        answer.add(diff1);
        answer.add(diff2);

        return answer;
    }
}

// <aside>
// 💡 **Question 5**

// Given two integer arrays arr1 and arr2, and the integer d, *return the distance value between the two arrays*.

// The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.

// **Example 1:**

// **Input:** arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2

// **Output:** 2

// **Explanation:**

// For arr1[0]=4 we have:

// |4-10|=6 > d=2

// |4-9|=5 > d=2

// |4-1|=3 > d=2

// |4-8|=4 > d=2

// For arr1[1]=5 we have:

// |5-10|=5 > d=2

// |5-9|=4 > d=2

// |5-1|=4 > d=2

// |5-8|=3 > d=2

// For arr1[2]=8 we have:

// **|8-10|=2 <= d=2**

// **|8-9|=1 <= d=2**

// |8-1|=7 > d=2

// **|8-8|=0 <= d=2**

// </aside>

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        //adding elemets to sets
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }

        ArrayList<Integer> diff1=new ArrayList<>();
        ArrayList<Integer> diff2=new ArrayList<>();

        //adding elements to arraylists
        for(int num:set1){
            if(! set2.contains(num)){
                diff1.add(num);
            }
        }
        for(int num:set2){
            if(! set1.contains(num)){
                diff2.add(num);
            }
        }

        List<List<Integer>> answer=new ArrayList<>();
        answer.add(diff1);
        answer.add(diff2);

        return answer;
    }
}

// <aside>
// 💡 **Question 6**

// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears **once** or **twice**, return *an array of all the integers that appears **twice***.

// You must write an algorithm that runs in O(n) time and uses only constant extra space.

// **Example 1:**

// **Input:** nums = [4,3,2,7,8,2,3,1]

// **Output:**

// [2,3]

// </aside>

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> states = new HashSet<Integer>();
        List<Integer> result = new ArrayList<>();


        for (int num : nums) {
            if (states.contains(num)) {
                result.add(num);
            } else {
                states.add(num);
            }
        }

        return result;
    }
}

// <aside>
// 💡 **Question 7**

// Suppose an array of length n sorted in ascending order is **rotated** between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// - [4,5,6,7,0,1,2] if it was rotated 4 times.
// - [0,1,2,4,5,6,7] if it was rotated 7 times.

// Notice that **rotating** an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given the sorted rotated array nums of **unique** elements, return *the minimum element of this array*.

// You must write an algorithm that runs in O(log n) time.

// **Example 1:**

// **Input:** nums = [3,4,5,1,2]

// **Output:** 1

// **Explanation:**

// The original array was [1,2,3,4,5] rotated 3 times.

// </aside>

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int flag = 0;
    
        for(int i=0; i<n-1; i++)
        {
            if(nums[i] > nums[i+1]) {
                flag = 1;
                break;
            }
        }

        if(flag == 0) {
            return nums[0];
        }
        
        int s = 0;
        int e = n-1;
        int mid = s + (e-s)/2;

        while(s<e) 
        {
            if(nums[0] <= nums[mid]) {
                s = mid+1;
            }
            else if(nums[0] > nums[mid]) {
                e = mid;
            }
            mid = s+(e-s)/2;
        }
        return nums[s];
    }
}

// <aside>
// 💡 **Question 8**

// An integer array original is transformed into a **doubled** array changed by appending **twice the value** of every element in original, and then randomly **shuffling** the resulting array.

// Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is not a **doubled** array, return an empty array. The elements in* original *may be returned in **any** order*.

// **Example 1:**

// **Input:** changed = [1,3,4,2,6,8]

// **Output:** [1,3,4]

// **Explanation:** One possible original array could be [1,3,4]:

// - Twice the value of 1 is 1 * 2 = 2.
// - Twice the value of 3 is 3 * 2 = 6.
// - Twice the value of 4 is 4 * 2 = 8.

// Other original arrays could be [4,3,1] or [3,1,4].

// </aside>

class Solution {
    public int[] findOriginalArray(int[] nums) {
       int[] vacarr = new int[0];
	   	// when we need to return vacant array
        int n= nums.length;
			// size of the array
        if(n%2!=0)
        {
            return vacarr;
			// when we will have odd number of integer in our input(double array can't be in odd number)
    
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			 // for storing the frequencies of each input
        int[] ans = new int[(nums.length/2)];
        // answer storing array
     
        for(int i=0;i<n;i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
			// storing the frequencies
        }
        int temp = 0;
        
        Arrays.sort(nums);
		// sorting in increasing order
        for(int i: nums)
        {
           
            if(hm.get(i)<=0)
            {
			  // if we have already decreased it's value when we were checking y/2 value, like 2,4 we will remove 4 also when we will check 2 but our iteration will come again on 4.
      
                continue;
            }
         
            if(hm.getOrDefault(2*i,0)<=0)
            {   // if we have y but not y*2 return vacant array
                return vacarr;
            }
            ans[temp++] = i;
			 // if we have both y and y*2, store in our ans array
           // decrease the frequency of y and y*2
            hm.put(i, hm.get(i)-1); 
            hm.put(2*i, hm.get(2*i)-1);
        }
        
        return ans;
    }
}
}
