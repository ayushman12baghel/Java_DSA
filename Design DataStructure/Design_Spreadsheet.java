import java.util.*;

class Spreadsheet {
    private int sheet[][];

    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = 0;
    }

    public int getValue(String formula) {
        String s = formula.substring(1);

        int index = s.indexOf('+');
        String left = s.substring(0, index);
        String right = s.substring(index + 1);

        return solve(left) + solve(right);
    }

    public int solve(String s) {
        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }

        int col = s.charAt(0) - 'A';
        int row = Integer.parseInt(s.substring(1)) - 1;

        return sheet[row][col];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */