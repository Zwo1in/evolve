package com.zwolin.evolve.config

import com.badlogic.gdx.Gdx
import ktx.math.ImmutableVector2
import ktx.math.div

object GameConfig {
    val sWorld = ImmutableVector2(1600f, 800f)
    val sScreen = ImmutableVector2(
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat())
}