import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Li_1_1_Mini_Twitter {
	class Node {
        public int order;
        public Tweet tweet;
        public Node(int o, Tweet t) {
            this.order = o;
            this.tweet = t;
        }
    }

    class SortByOrder implements Comparator {     
        public int compare(Object obj1,Object obj2) {     
            Node node1 = (Node) obj1;     
            Node node2 = (Node) obj2;  
            
            if (node1.order < node2.order){
                return 1;
            } else {
                return -1;
            }
        }
    }     

    private Map<Integer, Map<Integer, Boolean>> friends;
    private Map<Integer, List<Node>> users_tweets;
    private int order;
    
    public List<Node> getLastTen(List<Node> tmp) {
        int last = 10;
        
        if (tmp.size() < 10) {
            last = tmp.size();
        }
        
        return tmp.subList(tmp.size() - last, tmp.size());
    }

    public List<Node> getFirstTen(List<Node> tmp) {
        int last = 10;
        if (tmp.size() < 10) {
            last = tmp.size();
        }
        return tmp.subList(0, last);
    }

    public Li_1_1_Mini_Twitter() {
        this.friends = new HashMap<Integer, Map<Integer, Boolean>>();
        this.users_tweets = new HashMap<Integer, List<Node>>();
        this.order = 0;
    }

    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if (!users_tweets.containsKey(user_id)) {
            users_tweets.put(user_id, new ArrayList<Node>());
        }
        order += 1;
        users_tweets.get(user_id).add(new Node(order, tweet));
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        List<Node> tmp = new ArrayList<Node>();
        if (users_tweets.containsKey(user_id)) {
            tmp.addAll(getLastTen(users_tweets.get(user_id)));
        }

        if (friends.containsKey(user_id)) {
            for (Map.Entry<Integer, Boolean> entry : friends.get(user_id).entrySet()) {
                int user = entry.getKey();
                
                if (users_tweets.containsKey(user)) {
                    tmp.addAll(getLastTen(users_tweets.get(user)));
                }
            }
        }

        Collections.sort(tmp, new SortByOrder());
        List<Tweet> rt = new ArrayList<Tweet>();
        tmp = getFirstTen(tmp);
        for (Node node : tmp) {
            rt.add(node.tweet);
        }
        return rt;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        List<Node> tmp = new ArrayList<Node>();
        if (users_tweets.containsKey(user_id)) {
            tmp.addAll(getLastTen(users_tweets.get(user_id)));
        }

        Collections.sort(tmp, new SortByOrder());
        List<Tweet> rt = new ArrayList<Tweet>();
        tmp = getFirstTen(tmp);
        
        for (Node node : tmp) {
            rt.add(node.tweet);
        }
        return rt;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        if (!friends.containsKey(from_user_id)) {
            friends.put(from_user_id, new HashMap<Integer, Boolean>());
        }

        friends.get(from_user_id).put(to_user_id, true);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        if (friends.containsKey(from_user_id)) {
            friends.get(from_user_id).remove(to_user_id);
        }
    }
}


class Tweet {
	public int id;
	public int user_id;
	public String text;
	public static Tweet create(int user_id, String tweet_text) {
		return null;
	// This will create a new tweet object, and auto fill id
	}
}
