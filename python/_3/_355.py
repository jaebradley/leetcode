import heapq
from collections import defaultdict
from typing import List, Mapping

"""
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 

Example 1:

Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
 

Constraints:

1 <= userId, followerId, followeeId <= 500
0 <= tweetId <= 104
All the tweets have unique IDs.
At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
A user cannot follow himself.
"""


class Twitter:
    """
    Tweets need to have a global order. (No tweet deletion.)
    News feed is last 10 tweets authored or from followees.
    News feed uses heap based on tweet index of tweets by author.
    Take last 10 tweets for each author, and push the largest tweet indices from each list.
    Then pop the most recent tweet from the heap and add it to the news feed.
    """

    def __init__(self):
        self.tweets: List[int] = []
        self.tweets_by_author: Mapping[int, list] = defaultdict(list)
        self.followees_by_follower: Mapping[int, set] = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets.append(tweetId)
        self.tweets_by_author[userId].append(len(self.tweets) - 1)

    def getNewsFeed(self, userId: int) -> List[int]:
        most_recent_tweets_by_author = defaultdict(list)
        most_recent_tweets_by_author[userId].extend(self.tweets_by_author[userId][-10::])

        for author_id in self.followees_by_follower[userId]:
            most_recent_tweets_by_author[author_id].extend(self.tweets_by_author[author_id][-10::])

        news_feed, heap = [], []
        for _ in range(10):
            for author_id, tweets in most_recent_tweets_by_author.items():
                if tweets:
                    heapq.heappush(heap, -tweets.pop())

            if heap:
                news_feed.append(self.tweets[-heapq.heappop(heap)])

        return news_feed

    def follow(self, followerId: int, followeeId: int) -> None:
        self.followees_by_follower[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.followees_by_follower[followerId].discard(followeeId)

# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
