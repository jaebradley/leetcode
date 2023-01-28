package problems._71;

/**
 * https://leetcode.com/problems/simplify-path/
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * The canonical path should have the following format:
 * <p>
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * <p>
 * Return the simplified canonical path.
 */

import java.util.LinkedList;
import java.util.Stack;

/**
 * Approach:
 *
 * Directory identifiers, separated by arbitrary amount of /-s
 * Only two special identifiers, single dot (".") and double dot (".."), all other dot combinations are a file / directory name
 * Can't go higher than root directory
 * All paths are absolute paths
 * Given input, find first non backslash character
 * Iterate input until find next backslash character
 * Path element is captured string
 * If path element is ".." pop the input stack, unless input stack is empty, in which case do nothing
 * If path element is "." do nothing to the input stack
 * Build string from top of stack, "backwards", add "/" to front of string
 * Runtime: O(length of string)
 * Memory: O(length of string)
 */
class Solution {
    private static final String CURRENT_DIRECTORY = ".";
    private static final String PARENT_DIRECTORY = "..";

    public String simplifyPath(String path) {
        final LinkedList<String> elements = new LinkedList<>();
        int currentIndex = 0;
        do {
            currentIndex += 1;
        } while (currentIndex < path.length() && path.charAt(currentIndex) == '/');
        do {
            currentIndex = calculateNextPathElement(path, currentIndex, elements);
        } while (currentIndex < path.length());

        if (elements.isEmpty()) {
            return "/";
        }

        final StringBuilder sb = new StringBuilder();
        while (!elements.isEmpty()) {
            sb.append('/');
            sb.append(elements.pop());
        }
        return sb.toString();
    }

    private int calculateNextPathElement(final String path, final int startingIndex, final LinkedList<String> elements) {
        final StringBuilder sb = new StringBuilder();
        int endingIndex = startingIndex;
        for (; endingIndex < path.length(); endingIndex += 1) {
            final char currentCharacter = path.charAt(endingIndex);
            if (currentCharacter == '/') {
                break;
            }
            sb.append(currentCharacter);
        }

        final String element = sb.toString();
        if (element.equals(PARENT_DIRECTORY)) {
            if (!elements.isEmpty()) {
                elements.removeLast();
            }
        } else if (!element.equals(CURRENT_DIRECTORY)) {
            elements.addLast(element);
        }

        for (; endingIndex < path.length(); endingIndex += 1) {
            if (path.charAt(endingIndex) != '/') {
                break;
            }
        }

        return endingIndex;
    }
}
