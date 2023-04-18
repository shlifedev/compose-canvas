package com.example.myapplication.myRenderer

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

// 도형은 캔버스 아이템을 상속받아 draw, isDrawable을 구현한다.
sealed class Shape: IShape {
    abstract val id: Int
    abstract var rect : Rect
    override fun isDrawable(): Boolean {
        return true;
    }

    override fun drag(dragRate: Offset) {
        TODO("Not yet implemented")
    }

    override fun scale(scaleTo: Float) {
        TODO("Not yet implemented")
    }
}


data class Circle(
    override val id: Int,
    override var rect : Rect,
    var radius : Float
) : Shape(){
    override fun draw(drawScope: DrawScope) {
        drawScope.drawCircle(center = rect.position,
            radius = radius,
            color = Color.Blue
        )

        // 핸들러 위치 디버깅용
        drawScope.drawCircle(center = rect.getLT(),
            radius = radius/4,
            color = Color.Blue
        )
        drawScope.drawCircle(center = rect.getRB(),
            radius = radius/4,
            color = Color.Blue
        )
    }


}

data class Handle(
    override val id: Int,
    override var rect : Rect,
    var radius : Float
) : Shape(){
    override fun draw(drawScope: DrawScope) {
        drawScope.drawCircle(center = rect.getLT(),
            radius = radius/4,
            color = Color.Blue
        )
        drawScope.drawCircle(center = rect.getRB(),
            radius = radius/4,
            color = Color.Blue
        )
    }
}
