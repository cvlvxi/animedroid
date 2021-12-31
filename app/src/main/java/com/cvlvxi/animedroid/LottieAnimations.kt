package com.cvlvxi.animedroid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.*


@Preview
@Composable
fun MyLottieAnim01() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.catwalk))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition,
//        progress,
        iterations = LottieConstants.IterateForever
    )
}