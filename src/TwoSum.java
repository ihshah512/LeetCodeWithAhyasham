import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoSum {


    public static int[] returnIndices(int[] nums, int target){

      //  int[] returnArr = new int[2];
        Map<Integer,Integer> convertToMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            //convertToMap.put(nums[i],i);
            int x = nums[i];
            int num = target-x;
            if(convertToMap.containsKey(num)){
                return new int[] {i, convertToMap.get(num)};
            }else{
                convertToMap.put(x,i);
            }



        }


        return new int[] {-1,-1};

       }






    public static void main(String[] args){

        int[] arr = {1,2,3,4};
        int tar = 6;

        int[] newArr = returnIndices(arr,tar);

        for(int i: newArr){
            System.out.print(i + " ,");
        }



    }


}
/*
Example 1: 1. Two Sum

Given an array of integers nums and an integer target, return
indices of two numbers
such that they add up to target. You cannot use the same index twice.

 */
