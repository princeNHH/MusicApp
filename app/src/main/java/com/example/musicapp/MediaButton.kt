package com.example.musicapp

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MediaButton(
    modifier: Modifier,
    icon: ImageVector,
    contentDescription: String,
    backGroundColor: Color,
    iconColor: Color = Color.White,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .size(50.dp)
            .background(backGroundColor, shape = MaterialTheme.shapes.extraLarge),
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = iconColor
        )
    }
}

//@Preview
//@Composable
//fun MediaButtonPreview() {
//    MediaButton(
//        icon = Icons.Default.PlayArrow,
//        contentDescription = "Play",
//        backGroundColor = Color.White,
//        onClick = {}
//    )
//}