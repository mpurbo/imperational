package org.purbo.imperational.gof.abstractfactory.animal

import kotlin.math.abs

const val MAGIC_NUMBER_UNIT_PER_WINGS_FLAP = 15
const val MAGIC_NUMBER_UNIT_PER_JUMP = 5
const val MAGIC_NUMBER_UNIT_PER_STROKE = 5

data class Position(val x: Int, val y: Int) {

    fun relativeTo(anotherPosition: Position): Position =
        Position(x - anotherPosition.x, y - anotherPosition.y)

    fun direction(): Position = Position(x / abs(x), y / abs(y))
}

fun animal(
    run: (Position, Position) -> Position,
    medium: (Position) -> Position,
    safeCheck: (Position, Position) -> Boolean
): (Position, Position) -> Position {

    fun recursiveAnimal(fromPosition: Position, currentPosition: Position): Position =
        if (safeCheck(fromPosition, currentPosition))
            currentPosition
        else
            recursiveAnimal(
                fromPosition,
                run(fromPosition, medium(currentPosition))
            )

    return ::recursiveAnimal
}

fun animal(
    animalInstance: (Position, Position) -> Position,
    initialPosition: Position
): (Position) -> Position = { position ->
    animalInstance(position, initialPosition)
}

fun bird(): (Position, Position) -> Position {
    return animal(
        { fromPosition, currentPosition ->
            val direction = currentPosition.relativeTo(fromPosition)
            Position(
                currentPosition.x + MAGIC_NUMBER_UNIT_PER_WINGS_FLAP * direction.x,
                currentPosition.y + MAGIC_NUMBER_UNIT_PER_WINGS_FLAP * direction.y
            )
        },
        { position -> Position(position.x + 1, position.y - 1) },
        { fromPosition, position -> distance(position, fromPosition) > 100 }
    )
}

fun dog(): (Position, Position) -> Position {
    return animal(
        { fromPosition, currentPosition ->
            val direction = currentPosition.relativeTo(fromPosition)
            Position(
                currentPosition.x + MAGIC_NUMBER_UNIT_PER_JUMP * direction.x,
                currentPosition.y + MAGIC_NUMBER_UNIT_PER_JUMP * direction.y
            )
        },
        { position -> Position(position.x + 3, position.y - 3) },
        { fromPosition, position -> distance(position, fromPosition) > 200 }
    )
}

fun fish(): (Position, Position) -> Position {
    return animal(
        { fromPosition, currentPosition ->
            val direction = currentPosition.relativeTo(fromPosition)
            Position(
                currentPosition.x + MAGIC_NUMBER_UNIT_PER_STROKE * direction.x,
                currentPosition.y + MAGIC_NUMBER_UNIT_PER_STROKE * direction.y
            )
        },
        { position -> Position(position.x + 5, position.y - 5) },
        { fromPosition, position -> distance(position, fromPosition) > 75 }
    )
}

fun distance(position1: Position, position2: Position): Int {
    val deltax = position1.x - position2.x
    val deltay = position1.y - position2.y
    return deltax * deltax + deltay * deltay
}