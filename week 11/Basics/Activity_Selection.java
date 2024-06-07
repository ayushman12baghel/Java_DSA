import java.util.*;

class Activity_Selection {
    public static void main(String args[]) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        // sorting
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basis sorted
        int maxAct2 = 0;
        ArrayList<Integer> ans2 = new ArrayList<>();

        // 1st activity
        maxAct2 = 1;
        ans2.add(activities[0][0]);
        int lastEnd2 = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd2) {
                // activity select
                maxAct2++;
                ans2.add(activities[i][0]);
                lastEnd2 = activities[i][2];
            }
        }
        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                // activity select
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Max activity: " + maxAct);
        System.out.println("Max activity: " + maxAct2);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}