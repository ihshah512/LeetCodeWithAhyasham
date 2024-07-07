import java.util.*;

class sumArray{

    public static long sum(long[] arr){

        long sum = 0;

        for(long i: arr){
            sum+=i;
        }


        return sum;
    }


    public static void main(String[] args){

       long[] arrr= {1,2,3,1000};

       System.out.println(sum(arrr));

    }

}

