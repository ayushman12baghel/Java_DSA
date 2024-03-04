import java.util.ArrayList;

public class Lonely_numbers_in_ArrayList {

    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        ArrayList<Integer> lonelyNumbers = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int currentNum = nums.get(i);
            // Check if the current number is lonely
            if ((i == 0 || nums.get(i - 1) != currentNum + 1) &&
                    (i == nums.size() - 1 || nums.get(i + 1) != currentNum - 1)) {
                lonelyNumbers.add(currentNum);
            }
        }

        return lonelyNumbers;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(6);
        nums.add(5f);
        nums.add(8);

        ArrayList<Integer> lonely = findLonely(nums);
        System.out.println(lonely); // Output: [10, 8]
    }
}