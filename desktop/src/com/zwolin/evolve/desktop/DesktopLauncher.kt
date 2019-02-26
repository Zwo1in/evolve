package com.zwolin.evolve.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.zwolin.evolve.EvolveGame

fun main() {
    val config = LwjglApplicationConfiguration()
    config.width = 1080
    config.height = 720
    LwjglApplication(EvolveGame(), config)
}
