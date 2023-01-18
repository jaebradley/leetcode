package problems._559;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class BFSSolutionTest extends TestCase {
    public void test() {
        Assert.assertEquals(
                0,
                new BFSSolution().maxDepth(null)
        );

        Assert.assertEquals(
                1,
                new BFSSolution().maxDepth(
                        new BFSSolution.Node(1)
                )
        );

        Assert.assertEquals(
                2,
                new BFSSolution().maxDepth(
                        new BFSSolution.Node(1, List.of(new BFSSolution.Node(2)))
                )
        );

        Assert.assertEquals(
                3,
                new BFSSolution().maxDepth(
                        new BFSSolution.Node(
                                1,
                                List.of(
                                        new BFSSolution.Node(
                                                3,
                                                List.of(
                                                        new BFSSolution.Node(5),
                                                        new BFSSolution.Node(6)
                                                )
                                        ),
                                        new BFSSolution.Node(2),
                                        new BFSSolution.Node(4)
                                )
                        )
                )
        );
    }
}