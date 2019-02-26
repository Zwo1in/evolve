package com.zwolin.evolve

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Polygon
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import com.zwolin.evolve.components.BoundsCpnt
import com.zwolin.evolve.components.TextureCpnt
import com.zwolin.evolve.components.TransformCpnt
import com.zwolin.evolve.components.TravelCpnt
import ktx.ashley.add
import ktx.ashley.entity
import ktx.assets.toInternalFile

class World (
    val engine: PooledEngine
) {
    fun create() {
        addApis()
    }

    private fun addApis() =
        engine.add {
            entity {
                with<TransformCpnt> {
                    pos = Vector3.Zero.cpy()
                    scale = Vector2(0.1f, 0.1f)
                    rotDeg = -90f
                }
                with<TravelCpnt> {
                    acc = Vector2.Zero.cpy()
                    vel = Vector2.Y.cpy()
                }
                with<BoundsCpnt> {
                    bounds = Polygon(
                        floatArrayOf(
                            0f, 0f,
                            2f, 4f,
                            4f, 0f))
                    bounds.setOrigin(2f, 1f)
                }
                with<TextureCpnt> {
                    tex = TextureRegion(
                        Texture("Amoeba_galaxy.png".toInternalFile()),
                            0, 0,
                            200, 250)
                    orig = Vector2(100f, 90f)
                }
            }
        }
}