package org.psjava.algo.sequence.rmq;

import java.util.Comparator;


import org.psjava.ds.array.Array;

public interface RangeMinimumQuery {
	<T> PreprecessedRMQ preprocess(Array<T> a, Comparator<T> comp);
}