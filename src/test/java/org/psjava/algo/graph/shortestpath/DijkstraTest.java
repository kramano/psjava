package org.psjava.algo.graph.shortestpath;

import org.junit.Test;
import org.psjava.ds.heap.BinaryHeapFactory;

public class DijkstraTest {

	private static final Dijkstra ALGO = new Dijkstra(new BinaryHeapFactory());

	@Test
	public void testSizeOneGraph() {
		SingleSourceShortestPathTestCommon.testSizeOneGraph(ALGO);
	}

	@Test
	public void testNotReachableVertex() {
		SingleSourceShortestPathTestCommon.testNotReachableVertex(ALGO);
	}

	@Test
	public void testCLRSExample() {
		SingleSourceShortestPathTestCommon.testCLRSExample(ALGO);
	}

	@Test
	public void testCalcEdgePath() {
		SingleSourceShortestPathTestCommon.testCalcEdgePath(ALGO);
	}

}
