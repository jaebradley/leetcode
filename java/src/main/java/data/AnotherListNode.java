package data;

import java.util.Objects;

public class AnotherListNode {
    public int val;
    public AnotherListNode next;

    public AnotherListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public AnotherListNode(int val, AnotherListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (!(obj instanceof AnotherListNode)) {
            return false;
        }

        AnotherListNode node = (AnotherListNode) obj;

        return Objects.equals(val, node.val) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
