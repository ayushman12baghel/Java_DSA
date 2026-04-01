import java.util.*;

// Approach 1 Using Sorting and Stack O(nlogn)
class Solution {
    class Pair {
        int pos;
        int health;
        char direction;
        int index;

        public Pair(int pos, int health, char direction, int index) {
            this.pos = pos;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Pair nums[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            int pos = positions[i];
            int health = healths[i];
            char direction = directions.charAt(i);
            nums[i] = new Pair(pos, health, direction, i);
        }

        Arrays.sort(nums, (a, b) -> a.pos - b.pos);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            boolean destroyed = false;

            while (!stack.isEmpty() && nums[stack.peek()].direction == 'R' && nums[i].direction == 'L') {
                if (nums[stack.peek()].health < nums[i].health) {
                    stack.pop();
                    nums[i].health--;
                } else if (nums[stack.peek()].health == nums[i].health) {
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    nums[stack.peek()].health--;
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(i);
            }
        }

        List<Pair> temp = new ArrayList<>();

        while (!stack.isEmpty()) {
            temp.add(nums[stack.pop()]);
        }

        Collections.sort(temp, (a, b) -> a.index - b.index);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            ans.add(temp.get(i).health);
        }

        return ans;
    }
}

// Approach 2 Optimal O(nlogn)
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Integer indices[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);
        Stack<Integer> stack = new Stack<>();

        for (int index : indices) {
            if (directions.charAt(index) == 'R') {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && healths[index] > 0) {
                    int top = stack.peek();

                    if (healths[top] > healths[index]) {
                        healths[top]--;
                        healths[index] = 0;
                        break;
                    } else if (healths[top] < healths[index]) {
                        healths[top] = 0;
                        healths[index]--;
                        stack.pop();
                    } else {
                        healths[top] = 0;
                        healths[index] = 0;
                        stack.pop();
                        break;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) {
                ans.add(health);
            }
        }

        return ans;
    }
}