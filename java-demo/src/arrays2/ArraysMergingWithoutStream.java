package arrays2;

import java.util.Arrays;

public class ArraysMergingWithoutStream {


    public static void main(String[] args) {
        int nums1[] ={1,2,3,0,0,0};
        int m = 3;
        int nums2[] = {2,5,6};
        int n = 3;
        int count = 0;
        for (int i= 3; i< nums1.length; i++){
            nums1[i]= nums2[count];
            count++;
        }

        Arrays.sort(nums1);
        for (int i =0 ; i< nums1.length; i++){
            System.out.print(nums1[i]);
            System.out.print(",");
        }
    }
}
