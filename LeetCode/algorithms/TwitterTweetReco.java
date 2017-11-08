package algorithms;

import java.util.*;

public class TwitterTweetReco {
    static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges,
                                      int targetUser, int minLikeThreshold) {
        List<Integer> targetUserAdmirers = new ArrayList<>();
        for(int i[]: followGraph_edges){
            if(i[0] == targetUser){
                targetUserAdmirers.add(i[1]);
            }
        }
        Map<Integer,Integer> allRecommendedTweets = new HashMap<>();
        for(int j[]: likeGraph_edges){
            int count = 0;
            if(targetUserAdmirers.contains(j[0])){
                if( allRecommendedTweets.containsKey(j[1]) ){
                    count = allRecommendedTweets.get(j[1]);
                }
                allRecommendedTweets.put(j[1], count+1);
            }
        }
        List<Integer> tweetsBelowThresh = new ArrayList<>();
        for (Map.Entry<Integer, Integer> temp : allRecommendedTweets.entrySet())
        {
            if(temp.getValue()<minLikeThreshold){
                tweetsBelowThresh.add(temp.getKey());
            }
        }
        for(Iterator<Integer> iterator = tweetsBelowThresh.iterator(); iterator.hasNext(); ){
            Integer key = iterator.next();
            allRecommendedTweets.remove(key);
        }
        Set<Integer> creamTweets = allRecommendedTweets.keySet();
        int output[] = new int[creamTweets.size()];
        int index = 0;
        for(Integer element : creamTweets)
            output[index++] = element.intValue();

        return output;
    }
}
