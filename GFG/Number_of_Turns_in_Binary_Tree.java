class Solution {
    private boolean findPath(Node root, int target, StringBuilder path) {
        if (root == null) return false;
        if (root.data == target) return true;

        path.append('L');
        if (findPath(root.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(root.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    private int countTurns(String path) {
        int turns = 0;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != path.charAt(i - 1))
                turns++;
        }
        return turns;
    }

    public int numberOfTurns(Node root, int p, int q) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        if (!findPath(root, p, a) || !findPath(root, q, b))
            return -1;

        int i = 0;
        while (i < a.length() && i < b.length() &&
               a.charAt(i) == b.charAt(i)) {
            i++;
        }

        String pPath = a.substring(i);
        String qPath = b.substring(i);

        int turns = countTurns(pPath) + countTurns(qPath);

        if (!pPath.isEmpty() && !qPath.isEmpty() &&
            pPath.charAt(0) != qPath.charAt(0)) {
            turns++;
        }

        return turns == 0 ? -1 : turns;
    }
}
