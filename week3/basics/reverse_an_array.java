import java.util.*;

public class reverse_an_array {
	// public static void reverse(int numbers[]){
	// int reverse[]=new int[numbers.length];
	// int a=numbers.length;
	// for(int i=0;i<numbers.length;i++){
	// reverse[a-1]=numbers[i];
	// a-=1;
	// }
	// for (int i=0;i<reverse.length;i++){
	// System.out.println(reverse[i]);
	// }

	// }
	// public static void main(String args[]){
	// int numbers[]={1,2,3,4,5,6,7,8,9,10};
	// System.out.println(numbers);
	// reverse(numbers);
	// }
	// }

	// return by Shraddha mam

	public static void reverse(int numbers[]) {
		int first = 0, last = numbers.length - 1;

		while (first < last) {
			int temp = numbers[last];
			numbers[last] = numbers[first];
			numbers[first] = temp;
			first++;
			last--;
		}
	}

	public static void main(String[] args) {
		int numbers[]={2,4,6,8,10};
		reverse(numbers);
		for (int i=0;i<numbers.length;i++){
			System.out.print(numbers[i]+" ");
		}
	}
}
