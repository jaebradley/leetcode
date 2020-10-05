package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindTheTownJudgeTest {
    @Test
    public void testEmptyTownDoesNotIdentifyJudge() {
        assertEquals(-1, new FindTheTownJudge().findJudge(0, new int[][]{}));
    }

    @Test
    public void testSinglePersonTownWithoutTrustRelationshipDoesIdentifyJudge() {
        assertEquals(1, new FindTheTownJudge().findJudge(1, new int[][]{}));
    }

    @Test
    public void testSinglePersonTownDoesNotIdentifyJudge() {
        assertEquals(-1, new FindTheTownJudge().findJudge(1, new int[][]{ new int[]{1, 1}}));
    }

    @Test
    public void testTwoPersonTownWherePeopleOnlyTrustThemSelvesDoesNotIdentifyJudge() {
        assertEquals(-1, new FindTheTownJudge().findJudge(2, new int[][]{ new int[]{ 1, 1 }, new int[]{ 2, 2 }}));
    }

    @Test
    public void testTwoPersonTownWherePeopleTrustTheOtherOneDoesNotIdentifyJudge() {
        assertEquals(
                -1,
                new FindTheTownJudge().findJudge(
                        2,
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 2, 1 }
                        }
                )
        );
    }

    @Test
    public void testTwoPersonTownWhereSinglePersonTrustsOtherPersonDoesIdentifyJudge() {
        assertEquals(
                1,
                new FindTheTownJudge().findJudge(
                        2,
                        new int[][]{
                                new int[]{ 2, 1 }
                        }
                )
        );
    }

    @Test
    public void testThreePersonTownWhereFirstAndSecondPersonTrustThirdPerson() {
        assertEquals(
                3,
                new FindTheTownJudge().findJudge(
                        3,
                        new int[][]{
                                new int[]{ 1, 3 },
                                new int[]{ 2, 3 }
                        }
                )
        );
    }

    @Test
    public void testThreePersonTownWhereFirstAndSecondPersonAreTrustedByEveryOtherPerson() {
        assertEquals(
                -1,
                new FindTheTownJudge().findJudge(
                        3,
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 2, 1 },
                                new int[]{ 3, 1 },
                                new int[]{ 3, 2 }
                        }
                )
        );
    }

    @Test
    public void testThreePersonTownWhereEachPersonOnlyHasOnePersonThatTrustsThem() {
        assertEquals(
                -1,
                new FindTheTownJudge().findJudge(
                        3,
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 2, 3 },
                                new int[]{ 3, 1 }
                        }
                )
        );
    }

    @Test
    public void testThreePersonTownWhereFirstAndSecondTrustThirdPersonAndThirdPersonTrustsOtherPerson() {
        assertEquals(
                -1,
                new FindTheTownJudge().findJudge(
                        3,
                        new int[][]{
                                new int[]{ 1, 3 },
                                new int[]{ 2, 3 },
                                new int[]{ 3, 1 }
                        }
                )
        );
    }

    @Test
    public void testFindJudgeInDegreeOutDegreeEmptyTownDoesNotIdentifyJudge() {
        assertEquals(-1, new FindTheTownJudge().findJudgeInDegreeOutDegree(0, new int[][]{}));
    }

    @Test
    public void testFindJudgeInDegreeOutDegreeSinglePersonTownWithoutTrustRelationshipDoesIdentifyJudge() {
        assertEquals(1, new FindTheTownJudge().findJudgeInDegreeOutDegree(1, new int[][]{}));
    }


    @Test
    public void testFindJudgeInDegreeOutDegreeTwoPersonTownWherePeopleOnlyTrustThemSelvesDoesNotIdentifyJudge() {
        assertEquals(-1, new FindTheTownJudge().findJudgeInDegreeOutDegree(2, new int[][]{ new int[]{ 1, 1 }, new int[]{ 2, 2 }}));
    }

    @Test
    public void testFindJudgeInDegreeOutDegreeTwoPersonTownWherePeopleTrustTheOtherOneDoesNotIdentifyJudge() {
        assertEquals(
                -1,
                new FindTheTownJudge().findJudgeInDegreeOutDegree(
                        2,
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 2, 1 }
                        }
                )
        );
    }

    @Test
    public void testFindJudgeInDegreeOutDegreeTwoPersonTownWhereSinglePersonTrustsOtherPersonDoesIdentifyJudge() {
        assertEquals(
                1,
                new FindTheTownJudge().findJudgeInDegreeOutDegree(
                        2,
                        new int[][]{
                                new int[]{ 2, 1 }
                        }
                )
        );
    }

    @Test
    public void testFindJudgeInDegreeOutDegreeThreePersonTownWhereFirstAndSecondPersonTrustThirdPerson() {
        assertEquals(
                3,
                new FindTheTownJudge().findJudgeInDegreeOutDegree(
                        3,
                        new int[][]{
                                new int[]{ 1, 3 },
                                new int[]{ 2, 3 }
                        }
                )
        );
    }

    @Test
    public void testFindJudgeInDegreeOutDegreeThreePersonTownWhereFirstAndSecondPersonAreTrustedByEveryOtherPerson() {
        assertEquals(
                -1,
                new FindTheTownJudge().findJudgeInDegreeOutDegree(
                        3,
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 2, 1 },
                                new int[]{ 3, 1 },
                                new int[]{ 3, 2 }
                        }
                )
        );
    }

    @Test
    public void testFindJudgeInDegreeOutDegreeThreePersonTownWhereEachPersonOnlyHasOnePersonThatTrustsThem() {
        assertEquals(
                -1,
                new FindTheTownJudge().findJudgeInDegreeOutDegree(
                        3,
                        new int[][]{
                                new int[]{ 1, 2 },
                                new int[]{ 2, 3 },
                                new int[]{ 3, 1 }
                        }
                )
        );
    }

    @Test
    public void testFindJudgeInDegreeOutDegreeThreePersonTownWhereFirstAndSecondTrustThirdPersonAndThirdPersonTrustsOtherPerson() {
        assertEquals(
                -1,
                new FindTheTownJudge().findJudgeInDegreeOutDegree(
                        3,
                        new int[][]{
                                new int[]{ 1, 3 },
                                new int[]{ 2, 3 },
                                new int[]{ 3, 1 }
                        }
                )
        );
    }
}
