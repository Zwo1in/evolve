package com.zwolin.evolve.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.zwolin.evolve.components.TextureCpnt
import com.zwolin.evolve.components.TransformCpnt
import ktx.ashley.allOf
import ktx.ashley.get
import ktx.ashley.mapperFor
import ktx.collections.GdxArray
import ktx.graphics.use

class RenderSys(
    val batch: SpriteBatch,
    val camera: OrthographicCamera
): IteratingSystem(
    allOf(
        TransformCpnt::class,
        TextureCpnt::class
    ).get()
) {
    var texMap = mapperFor<TextureCpnt>()
    var transMap = mapperFor<TransformCpnt>()
    var entities = GdxArray<Entity>()

    override fun update(deltaTime: Float) {
        super.update(deltaTime)

        camera.update()
        batch.projectionMatrix = camera.combined

        batch.use { b ->
            entities.forEach { en ->
                val tex = en[texMap]!!.tex
                val size = en[texMap]!!.size
                val orig = en[texMap]!!.orig
                val pos = en[transMap]!!.pos
                val scl = en[transMap]!!.scale
                val rot = en[transMap]!!.rotDeg
                b.draw(
                    tex,
                    pos.x-orig.x, pos.y-orig.y,
                    orig.x, orig.y,
                    size.x, size.y,
                    scl.x, scl.y,
                    rot)
            }
        }
    }

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        entities.add(entity)
    }
}