package org.purbo.imperational

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FibonacciKotlinTest {

    private val fibonacci1 = listOf(0)
    private val fibonacci2 = listOf(0, 1)
    private val fibonacci3 = listOf(0, 1, 1)
    private val fibonacci29 = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811)

    @Test
    fun imperative() {
        assertEquals(imperative(fibonacci1.size), fibonacci1)
        assertEquals(imperative(fibonacci2.size), fibonacci2)
        assertEquals(imperative(fibonacci3.size), fibonacci3)
        assertEquals(imperative(fibonacci29.size), fibonacci29)
    }

    @Test
    fun functionalRecursive() {
        assertEquals(functionalRecursive(fibonacci1.size), fibonacci1)
        assertEquals(functionalRecursive(fibonacci2.size), fibonacci2)
        assertEquals(functionalRecursive(fibonacci3.size), fibonacci3)
        assertEquals(functionalRecursive(fibonacci29.size), fibonacci29)
    }

    @Test
    fun functionalFold() {
        assertEquals(functionalFold(fibonacci1.size), fibonacci1)
        assertEquals(functionalFold(fibonacci2.size), fibonacci2)
        assertEquals(functionalFold(fibonacci3.size), fibonacci3)
        assertEquals(functionalFold(fibonacci29.size), fibonacci29)
    }

    @Test
    fun functionalSequence() {
        assertEquals(functionalSequence(fibonacci1.size), fibonacci1)
        assertEquals(functionalSequence(fibonacci2.size), fibonacci2)
        assertEquals(functionalSequence(fibonacci3.size), fibonacci3)
        assertEquals(functionalSequence(fibonacci29.size), fibonacci29)
    }
}