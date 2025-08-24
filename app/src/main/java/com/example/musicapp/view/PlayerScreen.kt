package com.example.musicapp.view

import android.graphics.drawable.Icon
import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.musicapp.MediaButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerScreen() {
    var isPlaying by rememberSaveable { mutableStateOf(true) }

    var sliderValue by remember { mutableFloatStateOf(0f) }

    var isAdded by rememberSaveable { mutableStateOf(false) }


    Scaffold { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF7E9AB0))
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.small)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(Color.LightGray)
            )

            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .padding(20.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(8f)
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
                    modifier = Modifier.weight(1.5f),
                    icon = Icons.Filled.Cancel,
                    contentDescription = "Remove from current playlist",
                    backGroundColor = Color.Transparent,
                    onClick = { /*TODO*/ }
                )

                MediaButton(
                    modifier = Modifier.weight(1.5f),
                    icon = if(isAdded) Icons.Filled.CheckCircle else Icons.Filled.AddCircleOutline,
                    contentDescription = "Add favorite song",
                    backGroundColor = Color.Transparent,
                    onClick = { isAdded = !isAdded }
                )
            }


            Slider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp),
                    value = sliderValue,
                    onValueChange = { newValue ->
                        sliderValue = newValue
                    },
                    colors = SliderDefaults.colors(
                        thumbColor = Color.White,
                        activeTrackColor = Color.White,
                        inactiveTrackColor = Color.LightGray
                    ),
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

@Preview
@Composable
fun PlayerScreenPreview() {
    PlayerScreen()
}