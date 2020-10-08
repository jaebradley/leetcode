package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/design-browser-history/
 *
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
 *
 * Implement the BrowserHistory class:
 *
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 *
 *
 * Example:
 *
 * Input:
 * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
 * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
 * Output:
 * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
 *
 * Explanation:
 * BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
 * browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
 * browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
 * browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
 * browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
 * browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
 * browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
 * browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
 * browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
 * browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
 * browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
 *
 * Approach:
 *
 * 1. Two stacks - one to keep track of current history and the other to take care of "forward" history
 * 2. When visit is called, the "forward" history stack is cleared and the history stack is pushed to
 * 3. When back is called, the number of "back" operations is pushed to the "forward" history stack
 */

public class BrowserHistory {
    private final String homepage;
    private final Stack<String> history;
    private final Stack<String> forwardHistory;

    private String currentURL;


    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        this.history = new Stack<>();
        this.forwardHistory = new Stack<>();
        this.currentURL = this.homepage;
    }

    public void visit(String url) {
        this.history.push(this.currentURL);
        this.currentURL = url;

        while (!this.forwardHistory.isEmpty()) {
            this.forwardHistory.pop();
        }
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (this.history.isEmpty()) {
                this.currentURL = this.homepage;
                return this.currentURL;
            }
            this.forwardHistory.push(this.currentURL);
            this.currentURL = this.history.pop();
        }
        return this.currentURL;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (this.forwardHistory.isEmpty()) {
                return this.currentURL;
            }
            this.history.push(this.currentURL);
            this.currentURL = this.forwardHistory.pop();
        }
        return this.currentURL;
    }
}
