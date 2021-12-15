package org.purbo.imperational.gof.abstractfactory.animal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FunctionalEcosystemKotlinTest {

    private val disasterLocation = Position(10, 10)

    fun assertPosition(positions: List<Position>) {
        assertEquals(positions[0].x, 58)
        assertEquals(positions[0].y, 26)
        assertEquals(positions[1].x, 52)
        assertEquals(positions[1].y, -32)
        assertEquals(positions[2].x, 64)
        assertEquals(positions[2].y, -44)
    }

    @Test
    fun testFunctional() {
        assertPosition(listOf(
            animal(bird(), Position(12, 12)),
            animal(fish(), Position(12, 8)),
            animal(dog(), Position(8, 12)),
        ).map { f -> f(disasterLocation) })
    }

}