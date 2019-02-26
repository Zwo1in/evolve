package com.zwolin.evolve

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.zwolin.evolve.screen.GameScreen
import ktx.app.KtxGame
import ktx.app.clearScreen

class EvolveGame: KtxGame<Screen>() {

    lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()
        val game = GameScreen(batch)
        addScreen(game)
        setScreen<GameScreen>()
    }

    override fun render() {
        clearScreen(0.2f, 0.2f, 0.2f)
        super.render()
    }
}