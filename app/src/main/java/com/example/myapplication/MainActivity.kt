package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import com.example.myapplication.myRenderer.Circle
import com.example.myapplication.myRenderer.Handle
import com.example.myapplication.myRenderer.IShape
import com.example.myapplication.myRenderer.Rect
import com.example.myapplication.myRenderer.Shape
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Renderer()
                }
            }
        }
    }
}



@Composable
fun Renderer() {

    val renderList = remember { mutableStateListOf<IShape>() }
    LaunchedEffect(renderList){
    }

    Box(modifier = Modifier.fillMaxSize()){
        Canvas(modifier = Modifier
            .fillMaxSize()
            .border(color = Color.Magenta, width = Dp(32f))
            .pointerInput(Unit) {
                detectTapGestures {
                    renderList.add(Circle(0, Rect(Offset(0f, 0f), Offset(it.x, it.y)), 16f));
                }
            }, onDraw = {
                for (item in renderList)
                    item.draw(this);
        })
    }



}
