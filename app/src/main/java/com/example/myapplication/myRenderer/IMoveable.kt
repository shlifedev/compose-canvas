package com.example.myapplication.myRenderer

import androidx.compose.ui.geometry.Offset

interface IMoveable{
    fun getMovedShape(offset : Offset) : IShape
}