import java.util.*;

// Approach 1 Using HashMap
class Bank {
    HashMap<Integer, Long> accounts;
    int n;

    public Bank(long[] balance) {
        n = balance.length;
        accounts = new HashMap<>();

        for (int i = 0; i < balance.length; i++) {
            accounts.put(i, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        if (account1 < 0 || account2 < 0 || account1 >= n || account2 >= n) {
            return false;
        }

        long money1 = accounts.get(account1);
        if (money1 >= money) {
            accounts.put(account1, money1 - money);
            accounts.put(account2, accounts.get(account2) + money);

            return true;
        }

        return false;
    }

    public boolean deposit(int account, long money) {
        account--;
        if (account < 0 || account >= n) {
            return false;
        }

        long temp = accounts.get(account);
        accounts.put(account, temp + money);

        return true;
    }

    public boolean withdraw(int account, long money) {
        account--;
        if (account < 0 || account >= n) {
            return false;
        }

        long haveMoney = accounts.get(account);
        if (haveMoney >= money) {
            accounts.put(account, haveMoney - money);

            return true;
        }

        return false;
    }
}

// Approach 2 More Optimised Using Array
class Bank {
    long accounts[];
    int n;

    public Bank(long[] balance) {
        n = balance.length;
        this.accounts = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        if (account1 < 0 || account2 < 0 || account1 >= n || account2 >= n) {
            return false;
        }

        long money1 = accounts[account1];
        if (money1 >= money) {
            accounts[account1] = money1 - money;
            accounts[account2] += money;

            return true;
        }

        return false;
    }

    public boolean deposit(int account, long money) {
        account--;
        if (account < 0 || account >= n) {
            return false;
        }

        accounts[account] += money;

        return true;
    }

    public boolean withdraw(int account, long money) {
        account--;
        if (account < 0 || account >= n) {
            return false;
        }

        long haveMoney = accounts[account];
        if (haveMoney >= money) {
            accounts[account] -= money;

            return true;
        }

        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */