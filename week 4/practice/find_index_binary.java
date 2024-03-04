import java.util.*;
public class find_index_binary {
    public static int  search(int nums[],int a){
        // min will have index of minimum element of nums

        int min=minSearch(nums);
        //find in sorted left

        if(nums[min]<=a && a<=nums[nums.length-1]){
            return search(nums,min,nums.length-1,a);
        }
        //find sorted right
        else{
            return search(nums,0,min,a);
        }
    }

// binaryb search to find a in left to right boundary

    public static int search(int nums[],int left,int right,int a){
        int l=left;
        int r=right;
         while(l<=r){
            int mid=l+(r-1)/2;
            if(nums[mid]==a){
                return mid;
            }
            else if(nums[mid]>a){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
         }
         return -1;
    }

    // smallest element index

    public static int minSearch(int nums[]){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mid>0 && nums[mid-1]>nums[mid]){
                return mid;
            }
            else if(nums[left]<=nums[mid] && nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        int nums[]={4,5,6,7,0,1,2,3};
        System.out.print(search(nums,a));
    }
}
