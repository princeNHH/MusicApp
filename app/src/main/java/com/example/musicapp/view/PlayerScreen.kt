package com.example.musicapp.view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.createBitmap
import androidx.palette.graphics.Palette
import com.example.musicapp.MediaButton
import com.example.musicapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerScreen(onclick : () -> Unit) {
    var isPlaying by rememberSaveable { mutableStateOf(true) }

    var sliderValue by remember { mutableFloatStateOf(0f) }

    var isAdded by rememberSaveable { mutableStateOf(false) }

    var backgroundColor: List<Color> by remember {
        mutableStateOf(
            listOf(
                Color.White,
                Color.White
            )
        )
    }

    val context = LocalContext.current
//    val drawable = AppCompatResources.getDrawable(context, R.drawable.ic_launcher_background)
    val drawable = AppCompatResources.getDrawable(context, R.mipmap.img_2)
    val bitmap = drawable?.let { drawableToBitmap(it) } ?: createBitmap(1, 1)

    // when update new thumbnail (bitmap)
    LaunchedEffect(bitmap) {
        getGradientColors(bitmap) { color ->
            backgroundColor = color
        }
    }

    Scaffold(
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.verticalGradient(backgroundColor))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onclick,
                    modifier = Modifier
                        .size(32.dp)
                        .weight(1f)

                ) {
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = "Back",
                    )
                }

                Text("Playlist Name", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(8f))
                Icon(Icons.Default.MoreVert, contentDescription = "More", modifier = Modifier.weight(1f))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                Spacer(modifier = Modifier.weight(1f))
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = MaterialTheme.shapes.small)
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .weight(5f)
                )

                Column(
                    modifier = Modifier.weight(4f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize()
                            .padding(top = 16.dp),
                    ) {
                        Column(
                            modifier = Modifier.weight(3f),
                        ) {
                            Text(
                                text = "Song Name",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "Artist Name",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        MediaButton(
                            modifier = Modifier.weight(1f),
                            icon = Icons.Filled.Cancel,
                            contentDescription = "Remove from current playlist",
                            backGroundColor = Color.Transparent,
                            onClick = { /*TODO*/ }
                        )

                        MediaButton(
                            modifier = Modifier.weight(1f),
                            icon = if (isAdded) Icons.Filled.CheckCircle else Icons.Filled.AddCircleOutline,
                            contentDescription = "Add favorite song",
                            backGroundColor = Color.Transparent,
                            onClick = { isAdded = !isAdded }
                        )
                    }

                    Slider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        value = sliderValue,
                        onValueChange = { newValue ->
                            sliderValue = newValue
                        },
                        colors = SliderDefaults.colors(
                            thumbColor = Color.White,
                            activeTrackColor = Color.White,
                            inactiveTrackColor = Color.LightGray
                        ),
                        thumb = {
                            Icon(
                                imageVector = Icons.Filled.Circle,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .padding(0.dp, 2.dp, 0.dp, 0.dp)
                                    .size(12.dp)
                            )
                        },
                        track = { sliderState ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(4.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color.LightGray)
                            )
                        },
                        valueRange = 0f..1f,
                    )


                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        MediaButton(
                            modifier = Modifier,
                            icon = Icons.Filled.Repeat,
                            contentDescription = "Repeat",
                            backGroundColor = Color.Transparent,
                            onClick = { /*TODO*/ }
                        )

                        MediaButton(
                            modifier = Modifier,
                            icon = Icons.Filled.SkipPrevious,
                            contentDescription = "Previous Song",
                            backGroundColor = Color.Transparent,
                            onClick = { /*TODO*/ }
                        )

                        MediaButton(
                            modifier = Modifier.padding(16.dp, 0.dp),
                            icon = if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                            contentDescription = if (isPlaying) "Pause" else "Play",
                            backGroundColor = Color.White,
                            iconColor = Color.Black,
                            onClick = {
                                isPlaying = !isPlaying
                            }
                        )

                        MediaButton(
                            modifier = Modifier,
                            icon = Icons.Filled.SkipNext,
                            contentDescription = "Next Song",
                            backGroundColor = Color.Transparent,
                            onClick = { /*TODO*/ }
                        )

                        MediaButton(
                            modifier = Modifier,
                            icon = Icons.Filled.Timer,
                            contentDescription = "Cancel",
                            backGroundColor = Color.Transparent,
                            onClick = { /*TODO*/ }
                        )

                    }
                }
            }
        }
    }
}

fun getGradientColors(bitmap: Bitmap, onFinish: (List<Color>) -> Unit) {
    Palette.from(bitmap).generate { palette ->
        val vibrant =
            palette?.getVibrantColor(android.graphics.Color.GRAY) ?: android.graphics.Color.GRAY
        val darkMuted = palette?.getDarkMutedColor(android.graphics.Color.DKGRAY)
            ?: android.graphics.Color.DKGRAY
        onFinish(listOf(Color(vibrant), Color(darkMuted)))
    }
}

fun drawableToBitmap(drawable: Drawable): Bitmap {
    return if (drawable is BitmapDrawable) {
        drawable.bitmap
    } else {
        val width = if (drawable.intrinsicWidth > 0) drawable.intrinsicWidth else 1
        val height = if (drawable.intrinsicHeight > 0) drawable.intrinsicHeight else 1
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        bitmap
    }
}

@Preview
@Composable
fun PlayerScreenPreview() {
    PlayerScreen(onclick = {})
}