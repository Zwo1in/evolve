package com.zwolin.evolve.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3

class TransformCpnt(
        var pos: Vector3 = Vector3.Zero.cpy(),
        var scale: Vector2 = Vector2(1f, 1f),
        var rotDeg: Float = 0f
) : Component
