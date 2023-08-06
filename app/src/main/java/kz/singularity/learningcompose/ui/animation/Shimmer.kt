package kz.singularity.learningcompose.ui.animation

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoadingShimmerEffect(shimmerType: ShimmerType) {

    val gradient = listOf(
        Color.LightGray.copy(alpha = 0.9f), //darker grey (90% opacity)
        Color.LightGray.copy(alpha = 0.3f), //lighter grey (30% opacity)
        Color.LightGray.copy(alpha = 0.9f)
    )

    val transition = rememberInfiniteTransition(label = "") // animate infinite times

    val translateAnimation = transition.animateFloat( //animate the transition
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000, // duration for the animation
                easing = FastOutLinearInEasing
            )
        ), label = ""
    )
    val brush = linearGradient(
        colors = gradient,
        start = Offset(200f, 200f),
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        )
    )
    when (shimmerType) {
        ShimmerType.POSTS -> ShimmerForPosts(brush = brush)
        ShimmerType.ALBUMS -> ShimmerForAlbums(brush = brush)
        ShimmerType.USERS -> ShimmerForUsers(brush = brush)
        ShimmerType.COMPANY -> ShimmerForCompany(brush = brush)
        ShimmerType.ADDRESS -> ShimmerForAddress(brush = brush)
        ShimmerType.INFO -> ShimmerForInfo(brush = brush)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShimmerForAlbums(brush: Brush) {
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp),
        ) {
            Spacer(
                modifier = Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 1f)
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.8f)
                    .background(brush)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShimmerForUsers(brush: Brush) {
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp),
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.3f)
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(24.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.6f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.6f)
                    .background(brush)
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShimmerForPosts(brush: Brush) {
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            //modifier = Modifier
            //  .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp),
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.8f)
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 1f)
                    .background(brush)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShimmerForInfo(brush: Brush) {
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp),
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.8f)
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 1f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 1f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 1f)
                    .background(brush)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShimmerForCompany(brush: Brush) {
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp),
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.8f)
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 1f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 1f)
                    .background(brush)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShimmerForAddress(brush: Brush) {
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp),
        ) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.5f)
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.6f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.7f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(fraction = 0.7f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(16.dp)) //creates an empty space between
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction = 1f)
                    .height(40.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(brush)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShimmerPreview() {
    ShimmerForAddress(
        brush = linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.9f),
                Color.LightGray.copy(alpha = 0.4f),
                Color.LightGray.copy(alpha = 0.9f)
            )
        )
    )
}

enum class ShimmerType {
    POSTS,
    ALBUMS,
    USERS,
    COMPANY,
    ADDRESS,
    INFO
}