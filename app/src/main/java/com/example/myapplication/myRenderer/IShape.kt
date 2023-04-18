package com.example.myapplication.myRenderer

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope

interface IShape {
    fun draw(scope : DrawScope)
    fun isDrawable() : Boolean
    fun drag(dragRate : Offset)
    fun scale(scaleTo : Float)
}

