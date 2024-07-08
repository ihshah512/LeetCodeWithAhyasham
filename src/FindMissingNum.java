import java.util.HashMap;
import java.util.*;
import java.util.Map;


public class FindMissingNum {

    public static int missingNumber(int[] nums) {

        // Convert array to Set
        // Convert array to a Set
        /*Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int n = 0; n <= nums.length; n++) {
            if (!set.contains(n)) {
                System.out.print("Missing NUmber is: ");
                System.out.println(n);
                return n;
            }
        }
*/

        Arrays.sort(nums);
        if(nums[0]!=0){
            return 0;
        }

        if(nums.length==1 && nums[0]==1){
            return 0;
        }
        if(nums.length==1 && nums[0]==0){
            return 1;
        }
        int i;
        for( i=0; i < nums.length-1; i++){
           // int j = 1;

            if(((nums[i+1]-nums[i])!=1)){
                return nums[i]+1;
            }
           // j++;
        }

       return i+1;
    }


    public static void main(String[] args){

        int[] arr = {9,6,4,2,3,5,7,0,1};
        //int[] arr = {0,1};
        System.out.print(missingNumber(arr));
    }
}
