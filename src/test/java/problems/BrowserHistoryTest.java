package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrowserHistoryTest {
    @Test
    public void testSingleBack() {
        assertEquals(
                "google.com",
                new BrowserHistory("google.com").back(1)
        );
    }

    @Test
    public void testDoubleBackForSingleEntryReturnsSingleValue() {
        assertEquals(
                "google.com",
                new BrowserHistory("google.com").back(2)
        );
    }

    @Test
    public void testSingleForwardReturnsCurrentURLWhenAtMostRecentURL() {
        assertEquals(
                "google.com",
                new BrowserHistory("google.com").forward(1)
        );
    }

    @Test
    public void testSingleBackThenForwardReturnsCurrentURL() {
        BrowserHistory history = new BrowserHistory("google.com");
        history.back(1);
        assertEquals(
                "google.com",
                history.forward(1)
        );
    }

    @Test
    public void testThreeVisitsTwoBacks() {
        BrowserHistory history = new BrowserHistory("google.com");
        history.visit("facebook.com");
        history.visit("amazon.com");
        assertEquals(
                "google.com",
                history.back(2)
        );
    }

    @Test
    public void testThreeVisitsTwoBacksSingleForward() {
        BrowserHistory history = new BrowserHistory("google.com");
        history.visit("facebook.com");
        history.visit("amazon.com");
        history.back(2);
        assertEquals(
                "facebook.com",
                history.forward(1)
        );
    }

    @Test
    public void testThreeVisitsTwoBacksThenVisitNoForwardHistory() {
        BrowserHistory history = new BrowserHistory("google.com");
        history.visit("facebook.com");
        history.visit("amazon.com");
        history.back(2);
        history.visit("leetcode.com");
        assertEquals(
                "leetcode.com",
                history.forward(1)
        );

    }

    @Test
    public void testVisitsBackToBeginningAndThenForwardToFront() {
        BrowserHistory history = new BrowserHistory("google.com");
        history.visit("facebook.com");
        history.visit("amazon.com");
        history.visit("leetcode.com");
        history.back(10);
        assertEquals(
                "leetcode.com",
                history.forward(10)
        );

    }
}
