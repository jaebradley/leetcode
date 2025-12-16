from _355 import Twitter


class TestSolution:
    def test(self):
        t = Twitter()
        t.postTweet(1, 5)
        assert t.getNewsFeed(1) == [5]
        t.follow(1, 2)
        t.postTweet(2, 6)
        assert t.getNewsFeed(1) == [6, 5]
        t.unfollow(1, 2)
        assert t.getNewsFeed(1) == [5]
