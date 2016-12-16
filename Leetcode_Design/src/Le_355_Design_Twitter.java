import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
/*******
 * 
Design a simplified version of Twitter where users can post tweets, 
follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. 
Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. 
Each item in the news feed must be posted by users who the user followed or by the user herself. 
Tweets must be ordered from most recent to least recent.

follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.


Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);

 * 
 * */


public class Le_355_Design_Twitter {
	private int timeStamp = 0;
    private Map<Integer, user> userMap;
    
    private class tweet{
        public int id;
        public int time;
        public tweet next;
        
        public tweet(int id){
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }
    
    private class user{
        int id;
        tweet tweetHead;
        Set<Integer> followed;
        
        public user(int id){
            this.id = id;
            tweetHead = null;
            followed = new HashSet<Integer>();
            followed.add(id);
        }
        
        public void follow(int userId){
            followed.add(userId);
        }
        
        public void unfollow(int userId){
            followed.remove(userId);
        }
        
        public void post(int id){
            tweet t = new tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }
    
    /** Initialize your data structure here. */
    public Le_355_Design_Twitter() {
        userMap = new HashMap<Integer, user>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new user(userId));
        }
        
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(!userMap.containsKey(userId)) {
            return list;
        }
        
        Set<Integer> users = userMap.get(userId).followed;
        Queue<tweet> heap = new PriorityQueue<tweet>(1, new Comparator<tweet>(){
            public int compare(tweet left, tweet right){
                return right.time - left.time;
            }
        });
        
        for(int user : users){
            tweet t = userMap.get(user).tweetHead;
            
            if(t != null){
                heap.offer(t);
            }
        }
        
        int n = 0;
        
        while(!heap.isEmpty() && n < 10){
            tweet t = heap.poll();
            list.add(t.id);
            n++;
            
            if(t.next != null){
                heap.offer(t.next);
            }
        }
        
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId, new user(followerId));
        }
        
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new user(followeeId));
        }
        
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId) {
            return;
        }
        
        userMap.get(followerId).unfollow(followeeId);
    }
}
