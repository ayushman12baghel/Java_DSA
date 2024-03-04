public class fast_exponentiation {
    public static int fast_expo(int a,int n){
        int ans=1;
        while(n>0){
            if((n&1)!=0){
                ans*=a;
            }
            a*=a;
            n=n>>1;
        }
        return ans;
       
        // return (int)Math.pow(a,n);
    }
    public static void main(String[] args) {
        System.out.println(fast_expo(5,100000));
    }
}
