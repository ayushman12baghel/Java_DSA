import java.util.*;

//Approach 1 Brute Force O(num) 
class Robot {
    int row;
    int col;
    int width;
    int height;
    int dir[] = { 0, 1 };

    public Robot(int width, int height) {
        row = 0;
        col = 0;
        this.width = width;
        this.height = height;
    }

    public void step(int num) {
        for (int i = 0; i < num; i++) {
            int next[] = new int[] { dir[0] + row, dir[1] + col };

            if (next[0] >= height || next[1] >= width || next[0] < 0 || next[1] < 0) {
                dir = new int[] { dir[1], -dir[0] };
                step(num - i);
                return;
            }

            row = next[0];
            col = next[1];
        }
    }

    public int[] getPos() {
        return new int[] { col, row };
    }

    public String getDir() {
        if (dir[0] == 1 && dir[1] == 0) {
            return "North";
        } else if (dir[0] == 0 && dir[1] == 1) {
            return "East";
        } else if (dir[0] == 0 && dir[1] == -1) {
            return "West";
        } else {
            return "South";
        }
    }
}

// Approach 2 Math O(1)
class Robot {
    int width;
    int height;
    int pos;
    boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        pos = 0;
        moved = false;
    }

    public void step(int num) {
        moved = true;

        int perimeter = 2 * (width - 1) + 2 * (height - 1);

        pos = (pos + num) % perimeter;
    }

    public int[] getPos() {
        if (pos <= width - 1) {
            return new int[] { pos, 0 };
        } else if (pos <= width - 1 + height - 1) {
            return new int[] { width - 1, pos - (width - 1) };
        } else if (pos <= 2 * (width - 1) + (height - 1)) {
            return new int[] { width - 1 - (pos - (height - 1) - (width - 1)), height - 1 };
        } else {
            return new int[] { 0, (height - 1) - (pos - (2 * (width - 1) + (height - 1))) };
        }
    }

    public String getDir() {
        if (pos == 0) {
            return moved ? "South" : "East";
        }

        if (pos <= width - 1) {
            return "East";
        } else if (pos <= height - 1 + width - 1) {
            return "North";
        } else if (pos <= (height - 1) + 2 * (width - 1)) {
            return "West";
        }

        return "South";
    }
}