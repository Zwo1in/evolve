package com.zwolin.evolve.screen

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.zwolin.evolve.World
import com.zwolin.evolve.config.GameConfig
import com.zwolin.evolve.systems.RenderSys
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.graphics.use

class GameScreen(
    var batch: SpriteBatch
): KtxScreen {
    lateinit var camera: OrthographicCamera
    lateinit var viewport: FitViewport

    var engine = PooledEngine()
    var world = World(engine)

    override fun show() {
        camera = OrthographicCamera(GameConfig.sScreen.x, GameConfig.sScreen.y)
        viewport = FitViewport(GameConfig.sWorld.x, GameConfig.sWorld.y, camera)
        engine.addSystem(RenderSys(batch, camera))
        world.create()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height,true)
    }

    override fun render(delta: Float) {
        clearScreen(0.15f,0.15f, 0.15f)
        engine.update(delta)
    }

    override fun dispose() {
        batch.dispose()
    }
}