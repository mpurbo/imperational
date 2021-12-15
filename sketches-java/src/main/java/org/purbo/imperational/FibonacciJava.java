package org.purbo.imperational;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Different ways to generate Fibonacci sequence in Java.
 */
public class FibonacciJava {

    static List<Integer> imperative(int numberOfResult) {
        // The collection to contain the Fibonacci Sequence created by this function.
        // This structure will be mutated in the loop
        var fibonacciSequence = new ArrayList<Integer>();
        for (int i = 0; i < numberOfResult; i++) {
            if (i < 2) {
                // Fibonacci Sequence starts with 0, 1
                fibonacciSequence.add(i);
            } else {
                // sum of the previous 2 numbers
                fibonacciSequence.add(fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2));
            }
        }
        return fibonacciSequence;
    }

    static List<Integer> functional(int numberOfResult) {
        if (numberOfResult < 2)
            return IntStream
                    .range(0, numberOfResult)
                    .boxed()
                    .toList();
        else
            return functionalRecursive(numberOfResult, List.of(0, 1));
    }

    static List<Integer> functionalRecursive(int numberOfResult, List<Integer> currentSequence) {
        // stop recursively constructing sequence when the size of the current sequence is as expected.
        if (currentSequence.size() == numberOfResult)
            return currentSequence;
        else
            return functionalRecursive(numberOfResult, Stream
                    .concat(
                            // concatenating previously constructed sequence
                            currentSequence.stream(),
                            // with the sum of previous two numbers
                            Stream.of(currentSequence.get(currentSequence.size() - 2) + currentSequence.get(currentSequence.size() - 1)))
                    .toList());
    }

    // Unfortunately Java Stream API is not expressive enough to build collection from elements using reduce.

}