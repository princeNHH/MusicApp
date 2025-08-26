package com.example.musicapp.view

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
//    LazyColumn (
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//            .padding(16.dp)
//    ) {
//        item {
//            Text(text = "Home Screen", color = Color.White, fontSize = 22.sp)
//
//        }
//    }
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val openBottomSheet = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ){
        TextButton(
            onClick = {
                openBottomSheet.value = true
            },
            content = {
                Text(text = "Home Screen", color = Color.White, fontSize = 22.sp)
            }
        )
    }
    if(openBottomSheet.value){
        ModalBottomSheet(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            onDismissRequest = { openBottomSheet.value = false },
            sheetState = sheetState,
            dragHandle = null,
            contentWindowInsets = { WindowInsets(0,0,0,0) }
        ) {
            PlayerScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}