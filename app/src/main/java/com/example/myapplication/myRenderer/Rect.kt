package com.example.myapplication.myRenderer

import androidx.compose.ui.geometry.Offset

data class Rect(var size: Offset, var position : Offset){
    fun getPivot() : Offset { return position }
    fun getLT() : Offset { return Offset(position.x - size.x / 2, position.y - size.y / 2)
    }
    fun getRB() : Offset { return Offset(position.x + size.x / 2, position.y + size.y / 2)
    }
}