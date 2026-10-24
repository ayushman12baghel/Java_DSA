//Approach Converting Date to Days O(1)
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aStart=getDays(arriveAlice);
        int aEnd=getDays(leaveAlice);
        int bStart=getDays(arriveBob);
        int bEnd=getDays(leaveBob);

        int overlapStart=Math.max(aStart,bStart);
        int overlapEnd=Math.min(aEnd,bEnd);

        return Math.max(0,overlapEnd-overlapStart+1);
    }

    public int getDays(String str){
        int days=Integer.parseInt(str.substring(3));
        int month=Integer.parseInt(str.substring(0,2));

        int months[]={31,28,31,30,31,30,31,31,30,31,30,31};

        int totalDays=days;
        for(int i=0;i<month-1;i++){
            totalDays+=months[i];
        }

        return totalDays;
    }
}
