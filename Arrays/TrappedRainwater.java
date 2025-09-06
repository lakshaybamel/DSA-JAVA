import java.util.*;

//time complexity is O(n) n is no. of elements in array
public class TrappedRainwater {

    public static int findTrappedRainwater(int height[]){
        //Auxiliary Arrays
        //2 Pointer approach
        //calculate left max boundary
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        //calculate right max boundary
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        // //print leftMax array
        // for (int i = 0; i < leftMax.length; i++){
        //     System.out.print(leftMax[i] + " ");
        // }
        // System.out.println();

        // //print rightMax array
        // for (int i = 0; i < rightMax.length; i++){
        //     System.out.print(rightMax[i] + " ");
        // }
        // System.out.println();

        //loop
        int trappedWater = 0;
        for (int i = 1; i < height.length; i++){
            //waterLevel = min(leftMax bound, rightMax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //trappedWater = waterLevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String []args){
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        System.out.println("total trapped water is : " + findTrappedRainwater(height));
    }
}