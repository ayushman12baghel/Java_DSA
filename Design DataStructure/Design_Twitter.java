import java.util.*;

class Twitter {
    static int timestamp = 0;

    class Tweet {
        int id;
        int time;

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }

    class User {
        int id;
        Set<Integer> followed;
        List<Tweet> tweets;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            tweets = new ArrayList<>();
            follow(id);
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            if (id != this.id) {
                followed.remove(id);
            }
        }

        public void post(int id) {
            tweets.add(new Tweet(id));
        }
    }

    Map<Integer, User> userMap;

    public Twitter() {
        this.userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        if (!userMap.containsKey(userId)) {
            return result;
        }

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        for (int user : users) {
            List<Tweet> tweets = userMap.get(user).tweets;
            int count = 0;

            for (int i = tweets.size() - 1; i >= 0 && count < 10; i--, count++) {
                pq.offer(tweets.get(i));
            }
        }

        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            result.add(pq.poll().id);
            n++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }

        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */