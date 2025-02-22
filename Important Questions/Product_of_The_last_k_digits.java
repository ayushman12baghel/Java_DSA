import java.util.*;

public class Product_of_The_last_k_digits {
    public static void main(String[] args) {
    }
}

// Approach 1 Brute Force
class ProductOfNumbers {
    List<Integer> list;
    int n;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        n = 0;
    }

    public void add(int num) {
        list.add(num);
        n++;
    }

    public int getProduct(int k) {
        int prod = 1;
        for (int i = n - k; i < n; i++) {
            prod *= list.get(i);
        }

        return prod;
    }
}

// Approach 2 Using Cumulative Product
class ProductOfNumbers2 {
    List<Integer> list;
    int n;

    public ProductOfNumbers2() {
        list = new ArrayList<>();
        n = 0;
    }

    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            n = 0;
        } else {
            if (n == 0) {
                list.add(num);
            } else {
                list.add(list.get(n - 1) * num);
            }
            n++;
        }
    }

    public int getProduct(int k) {
        if (k > n) {
            return 0;
        } else if (k == n) {
            return list.get(n - 1);
        } else {
            return list.get(n - 1) / list.get(n - k - 1);
        }
    }
}