package com.cvlvxi.animedroid

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import kotlinx.coroutines.launch


@Composable
fun MyLottieAnim01(selected: Boolean = false, onClick: () -> Unit) {
    Box(modifier= Modifier
        .fillMaxSize()
        .clickable { onClick() }) {
        val intOffset: IntOffset by animateIntOffsetAsState(
            if (!selected) IntOffset(0, 0) else IntOffset(500, 0),
            animationSpec = tween(
                durationMillis = 5000,
                delayMillis = 1000,
                easing =  LinearEasing

            )
        )
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.catwalk))
        LottieAnimation(
            composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .width(100.dp)
                .height(300.dp)
                .offset(x = intOffset.x.dp, y = intOffset.y.dp)
        )
    }
}

@Composable
fun MyLottieAnim02(selected: Boolean = false, onClick: () -> Unit) {
    Box(modifier= Modifier
        .fillMaxSize()
        .clickable { onClick() })
    {
        val scope = rememberCoroutineScope()
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.catwalk))
        var offsetX by remember { mutableStateOf(0)}
        LaunchedEffect(Unit) {
            animate(
                initialValue = 0F,
                targetValue = 500F,
                initialVelocity = 0.1F,
                animationSpec = tween(
                    durationMillis = 5000,
                    delayMillis = 1000,
                    easing =  LinearEasing
                ),
                block= { value: Float, _: Float ->
                    run {
                        offsetX = value.toInt()
                    }
            })
        }

        LottieAnimation(
            composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .width(100.dp)
                .height(300.dp)
                .offset(x = offsetX.dp)
        )
    }
}

