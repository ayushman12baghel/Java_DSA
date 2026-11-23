//Approach 1 Brute Force Approach O(k)
class ProductOfNumbers {
    Stack<Integer> stack;
    public ProductOfNumbers() {
        stack=new Stack<>();
    }
    
    public void add(int num) {
        stack.push(num);
    }
    
    public int getProduct(int k) {
        Stack<Integer> queue=new Stack<>();
        int prod=1;

        while(k-->0){   
            int num=stack.pop();
            prod*=num;
            queue.push(num);
        }

        while(!queue.isEmpty()){
            stack.push(queue.pop());
        }

        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

//Approach 2 Using Array O(1)class ProductOfNumbers {
    int arr[];
    int i;
    public ProductOfNumbers() {
        arr=new int[40006];
        arr[0]=1;
        i=1;
    }
    
    public void add(int num) {
        if(num==0){
            i=1;
        }else{
            arr[i]=(arr[i-1]*num);
            i++;
        }
    }
    
    public int getProduct(int k) {
        if(k>=i){
            return 0;
        }else{
            return arr[i-1]/arr[i-k-1];
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
