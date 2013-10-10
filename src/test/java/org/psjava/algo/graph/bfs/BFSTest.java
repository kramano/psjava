package org.psjava.algo.graph.bfs;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.util.VarargsIterable;

public class BFSTest {

	@Test
	public void testTraverse() {
		String[][] data = { { "A", "B" }, { "B", "C" }, { "A", "C" }, { "B", "D" } };
		Graph<String, DirectedEdge<String>> g = TestGraphFactory.createDirected(data);
		final DynamicArray<String> log = DynamicArray.create();
		BFS.traverse(AdjacencyListFromGraph.create(g), VarargsIterable.create("A"), new BFSVisitor<String, DirectedEdge<String>>() {
			@Override
			public void onDiscover(String vertex, int depth, BFSStopper stopper) {
				log.addToLast(vertex + "(" + depth + ")");
			}

			@Override
			public void onWalk(DirectedEdge<String> e) {
				log.addToLast(e.toString());
			}
		});
		assertEquals("(A(0),A->B,B(1),A->C,C(1),B->D,D(2))", log.toString());
	}

}