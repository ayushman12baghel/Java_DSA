import java .util.*;
public class trapped_rainwater_practice_2 {
    public static int trapped_rainwater(int height[]){
        int left_max[]=new int[height.length];
        left_max[0]=height[0];
        for(int i=1;i<height.length;i++){
            left_max[i]=Math.max(height[i], left_max[i-1]);
        }

        int right_max[]=new int[height.length];
        right_max[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            right_max[i]=Math.max(height[i], right_max[i+1]);
        }

        int trapped_water=0;
        for(int i=0;i<height.length;i++){
            int waterlevel=Math.min(left_max[i], right_max[i]);
            trapped_water+=waterlevel-height[i];
        }
        return trapped_water;
    }
    public static void main(String[] args) {
        int height[]={1,0,2,1,0,3,2,1,2};
        System.out.println(trapped_rainwater(height));
    }
}
