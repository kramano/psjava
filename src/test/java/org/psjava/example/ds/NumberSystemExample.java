package org.psjava.example.ds;

import junit.framework.Assert;
import org.junit.Test;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.BigIntegerNumberSystem;
import org.psjava.ds.numbersystrem.DoubleNumberSystem;
import org.psjava.ds.numbersystrem.FractionNumberSystem;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.ds.numbersystrem.LongNumberSystem;
import org.psjava.ds.numbersystrem.ModularNumberSystem;
import org.psjava.goods.GoodDijkstraAlgorithm;

import java.math.BigInteger;

/**
 * @implementation {@link org.psjava.ds.numbersystrem.IntegerNumberSystem}
 * @implementation {@link org.psjava.ds.numbersystrem.BigIntegerNumberSystem}
 * @implementation {@link org.psjava.ds.numbersystrem.FractionNumberSystem}
 * @implementation {@link org.psjava.ds.numbersystrem.ModularNumberSystem}
 *
 * @see {@link org.psjava.example.algo.DijkstraAlgorithmExample}
 */
public class NumberSystemExample {

	@Test
	public void example() {
		// psjava has "NumberSystem" concept to support generalization of algorithms.
		// For example, you can run Dijkstra's algorithm with weights in BigInteger.

		MutableDirectedWeightedGraph<String, BigInteger> g = MutableDirectedWeightedGraph.create();
		g.insertVertex("A");
		g.insertVertex("B");
		g.insertVertex("C");
		g.addEdge("A", "B", new BigInteger("10000000000000000000000000000000000000000")); // So big!
		g.addEdge("B", "C", new BigInteger("20000000000000000000000000000000000000000"));

		// a -> c must be 30000000000000000000000000000000000000000
		BigInteger distance = GoodDijkstraAlgorithm.getInstance().calc(g, "A", BigIntegerNumberSystem.getInstance()).getDistance("C");

		// Various number systems are prepared.
		IntegerNumberSystem.getInstance();
		LongNumberSystem.getInstance();
		DoubleNumberSystem.getInstance();
		FractionNumberSystem.newInstance(LongNumberSystem.getInstance()); // Given number system is used for implementation of fraction.
		ModularNumberSystem.newInstance(IntegerNumberSystem.getInstance(), 10); // (mod 10)

		Assert.assertEquals(new BigInteger("30000000000000000000000000000000000000000"), distance);
	}

}