import java.util.*;

class TaskManager {
    Map<Integer, Integer> id_user = new HashMap<>();
    TreeSet<int[]> id_priority = new TreeSet<>((a, b) -> (a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]));
    Map<Integer, Integer> map = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) { // m(log(m))
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            id_user.put(taskId, userId);
            id_priority.add(new int[] { taskId, priority });
            map.put(taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) { // log(n)
        id_user.put(taskId, userId);
        id_priority.add(new int[] { taskId, priority });
        map.put(taskId, priority);
    }

    public void edit(int taskId, int newPriority) { // (log(n))
        id_priority.remove(new int[] { taskId, map.get(taskId) });
        id_priority.add(new int[] { taskId, newPriority });
        map.put(taskId, newPriority);
    }

    public void rmv(int taskId) { // (log(n))
        id_user.remove(taskId);
        id_priority.remove(new int[] { taskId, map.get(taskId) });
        map.remove(taskId);
    }

    public int execTop() { // (log(n))
        int temp[] = id_priority.pollFirst();
        if (temp == null) {
            return -1;
        }
        map.remove(temp[0]);

        int ans = id_user.get(temp[0]);
        id_user.remove(temp[0]);

        return ans;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */