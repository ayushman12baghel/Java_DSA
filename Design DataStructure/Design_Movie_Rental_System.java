import java.util.*;

//T.C. : 

// MovieRentingSystem() -> O(n log n) for n entries (insert each entry into TreeSets)
// search(movie)        -> O(5) i.e. constant time to return first 5 cheapest shops
// rent(shop, movie)    -> O(log m + log r) per operation
//                         (log m to remove from available TreeSet of that movie, log r to insert into rented TreeSet)
// drop(shop, movie)    -> O(log m + log r) per operation
//                         (log m to insert back to available TreeSet, log r to remove from rented TreeSet)
// report()             -> O(5) i.e. constant time to return top 5 rented movies

// S.C. : 
// O(n + r) total
// available          -> O(n) (sum of all available movies)
// movieToShopPrice   -> O(n) (sum of all shop-price mappings)
// rented             -> O(r) (r = total rented movies)
class MovieRentingSystem {
    class PriceShop implements Comparable<PriceShop> {
        int price;
        int shop;

        public PriceShop(int price, int shop) {
            this.price = price;
            this.shop = shop;
        }

        @Override
        public int compareTo(PriceShop o) {
            if (this.price != o.price) {
                return this.price - o.price;
            }

            return this.shop - o.shop;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (!(o instanceof PriceShop)) {
                return false;
            }

            PriceShop object = (PriceShop) o;

            return this.price == object.price && this.shop == object.shop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, shop);
        }
    }

    class RentedMovie implements Comparable<RentedMovie> {
        int price;
        int shop;
        int movie;

        public RentedMovie(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }

        @Override
        public int compareTo(RentedMovie o) {
            if (this.price != o.price) {
                return this.price - o.price;
            }
            if (this.shop != o.shop) {
                return this.shop - o.shop;
            }

            return this.movie - o.movie;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (!(o instanceof RentedMovie)) {
                return false;
            }

            RentedMovie object = (RentedMovie) o;

            return this.price == object.price && this.shop == object.shop && this.movie == object.movie;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }

    Map<Integer, TreeSet<PriceShop>> available; // movie -> (price,shop)
    Map<Integer, Map<Integer, Integer>> movieToShopPrice; // movie -> (shop -> price)
    TreeSet<RentedMovie> rented; // sorted rented movies

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        movieToShopPrice = new HashMap<>();
        rented = new TreeSet<>();

        for (int entry[] : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];

            available.computeIfAbsent(movie, k -> new TreeSet<>()).add(new PriceShop(price, shop));
            movieToShopPrice.computeIfAbsent(movie, k -> new HashMap<>()).put(shop, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (available.containsKey(movie)) {
            int count = 0;

            for (PriceShop ps : available.get(movie)) {
                result.add(ps.shop);
                count++;

                if (count >= 5) {
                    break;
                }
            }
        }

        return result;
    }

    public void rent(int shop, int movie) {
        int price = movieToShopPrice.get(movie).get(shop);
        available.get(movie).remove(new PriceShop(price, shop));
        rented.add(new RentedMovie(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        int price = movieToShopPrice.get(movie).get(shop);
        available.get(movie).add(new PriceShop(price, shop));
        rented.remove(new RentedMovie(price, shop, movie));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();

        int count = 0;
        for (RentedMovie rm : rented) {
            result.add(Arrays.asList(rm.shop, rm.movie));
            count++;

            if (count >= 5) {
                break;
            }
        }

        return result;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */