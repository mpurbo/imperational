package org.purbo.imperational;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciJavaTest {

    final List<Integer> fibonacci1 = List.of(0);
    final List<Integer> fibonacci2 = List.of(0, 1);
    final List<Integer> fibonacci3 = List.of(0, 1, 1);
    final List<Integer> fibonacci29 = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811);

    @Test
    void testImperative() {
        assertEquals(FibonacciJava.imperative(fibonacci1.size()), fibonacci1);
        assertEquals(FibonacciJava.imperative(fibonacci2.size()), fibonacci2);
        assertEquals(FibonacciJava.imperative(fibonacci3.size()), fibonacci3);
        assertEquals(FibonacciJava.imperative(fibonacci29.size()), fibonacci29);
    }

    @Test
    void testFunctional() {
        assertEquals(FibonacciJava.functional(fibonacci1.size()), fibonacci1);
        assertEquals(FibonacciJava.functional(fibonacci2.size()), fibonacci2);
        assertEquals(FibonacciJava.functional(fibonacci3.size()), fibonacci3);
        assertEquals(FibonacciJava.functional(fibonacci29.size()), fibonacci29);
    }

}
