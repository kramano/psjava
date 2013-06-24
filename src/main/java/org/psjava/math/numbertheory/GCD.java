package org.psjava.math.numbertheory;

import org.psjava.math.ns.AddInvert;
import org.psjava.math.ns.IntegerDivisableNumberSystem;


public class GCD {
	
	public static <T> T gcd(IntegerDivisableNumberSystem<T> ns, T a, T b) {
		if (ns.isNegative(a))
			return gcd(ns, AddInvert.calc(ns, a), b);
		if (ns.isNegative(b))
			return gcd(ns, a, AddInvert.calc(ns, b));
		if (ns.compare(a, b) > 0)
			return gcd(ns, b, a);
		while(true) {
			if (a.equals(ns.getZero()))
				return b;
			T temp = a;
			a = ns.integerRemainder(b, a);
			b = temp;
		}
	}

}
