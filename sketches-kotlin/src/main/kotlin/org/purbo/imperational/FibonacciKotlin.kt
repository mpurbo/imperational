package org.purbo.imperational

/**
 * Basic imperative version.
 */
fun imperative(numberOfResult: Int): List<Int> {
    var fibonacciSequence = mutableListOf<Int>()
    for (i in 0 until numberOfResult) {
        if (i < 2) {
            fibonacciSequence.add(i);
        } else {
            fibonacciSequence.add(fibonacciSequence[i - 1] + fibonacciSequence[i - 2])
        }
    }
    return fibonacciSequence
}

/**
 * A naive recursive version, but fun nonetheless.
 */
fun functionalRecursive(
        numberOfResult: Int,
        currentSequence: List<Int> = if (numberOfResult < 2) (0 until numberOfResult).toList() else listOf(0, 1)
): List<Int> =
        if (currentSequence.size == numberOfResult)
            currentSequence
        else
            functionalRecursive(
                    numberOfResult,
                    currentSequence + listOf(currentSequence[currentSequence.size - 2] + currentSequence[currentSequence.size - 1]))

/**
 * Fold (a version of reduce that allows different initial/return value type.
 */
fun functionalFold(numberOfResult: Int): List<Int> =
        (0 until numberOfResult)
                .fold(listOf()) { acc, index ->
                    if (acc.size < 2) acc + index
                    else acc + (acc[index - 2] + acc[index - 1]) }

/**
 * Using lazy Sequence with Pair structure for representing previous 2 numbers being used for generating the next one.
 *
 * From: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/generate-sequence.html#generatesequence
 */
fun functionalSequence(numberOfResult: Int): List<Int> =
        (generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }.map { it.first })
                .take(numberOfResult)
                .toList()

