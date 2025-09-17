import java.util.*;

//O(mlog(m))
class FoodRatings {
    class Pair implements Comparable<Pair> {
        String food;
        int rating;

        public Pair(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating);
            }

            return this.food.compareTo(other.food);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }

            if (!(other instanceof Pair)) {
                return false;
            }

            Pair o = (Pair) other;

            return this.food.equals(o.food) && this.rating == o.rating;
        }

        @Override
        public int hashCode() {
            return Objects.hash(food, rating);
        }
    }

    Map<String, Integer> food_rating = new HashMap<>();
    Map<String, TreeSet<Pair>> cuisine_food_rating = new HashMap<>();
    Map<String, String> food_cuisine = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            food_rating.put(food, rating);
            food_cuisine.put(food, cuisine);

            cuisine_food_rating.computeIfAbsent(cuisine, k -> new TreeSet<>()).add(new Pair(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = food_cuisine.get(food);
        TreeSet<Pair> cuisineSet = cuisine_food_rating.get(cuisine);
        cuisineSet.remove(new Pair(food, food_rating.get(food)));

        food_rating.put(food, newRating);

        cuisineSet.add(new Pair(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisine_food_rating.get(cuisine).first().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */