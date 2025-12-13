import java.util.*;

// Approach 1 Using TreeMap O(N*L*logn)
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;

        HashMap<String, TreeMap<String, Integer>> map = new HashMap<>();
        map.put("electronics", new TreeMap<>());
        map.put("grocery", new TreeMap<>());
        map.put("pharmacy", new TreeMap<>());
        map.put("restaurant", new TreeMap<>());

        for (int i = 0; i < n; i++) {
            if (isActive[i] && map.containsKey(businessLine[i]) && isValid(code[i])) {
                map.get(businessLine[i]).put(code[i], map.get(businessLine[i]).getOrDefault(code[i], 0) + 1);
            }
        }

        List<String> items = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        items.add("electronics");
        items.add("grocery");
        items.add("pharmacy");
        items.add("restaurant");

        for (int i = 0; i < items.size(); i++) {
            TreeMap<String, Integer> treemap = map.get(items.get(i));

            for (Map.Entry<String, Integer> entry : treemap.entrySet()) {
                for (int j = 0; j < entry.getValue(); j++) {
                    ans.add(entry.getKey());
                }
            }
        }

        return ans;
    }

    public boolean isValid(String code) {
        if (code.length() == 0) {
            return false;
        }
        for (char c : code.toCharArray()) {
            if (c == '_' || Character.isLetterOrDigit(c)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}

// Approach 2 O(n * k + n log n)
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && isValid(code[i])) {
                switch (businessLine[i]) {
                    case "electronics":
                        electronics.add(code[i]);
                        break;
                    case "grocery":
                        grocery.add(code[i]);
                        break;
                    case "pharmacy":
                        pharmacy.add(code[i]);
                        break;
                    case "restaurant":
                        restaurant.add(code[i]);
                        break;
                }
            }
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        List<String> ans = new ArrayList<>();
        ans.addAll(electronics);
        ans.addAll(grocery);
        ans.addAll(pharmacy);
        ans.addAll(restaurant);

        return ans;
    }

    public boolean isValid(String code) {
        if (code.length() == 0) {
            return false;
        }
        for (char c : code.toCharArray()) {
            if (c == '_' || Character.isLetterOrDigit(c)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}