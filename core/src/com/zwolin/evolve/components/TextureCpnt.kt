package com.zwolin.evolve.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2

class TextureCpnt: Component {
    var tex: TextureRegion = TextureRegion()
    set(value) {
        field = value
        size = Vector2(
                field.regionWidth.toFloat(),
                field.regionHeight.toFloat())
        orig = Vector2(
                size.x/2f,
                size.y/3f)
    }

    var size: Vector2 = Vector2.Zero.cpy()
    var orig: Vector2 = Vector2.Zero.cpy()
}