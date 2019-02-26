package com.zwolin.evolve.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Vector2

class TravelCpnt(
        var vel: Vector2 = Vector2.Zero.cpy(),
        var acc: Vector2 = Vector2.Zero.cpy()
): Component
