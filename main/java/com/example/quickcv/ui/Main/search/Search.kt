package com.example.quickcv.ui.Main.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quickcv.ui.reusables.buttons.PrimaryButton
import com.example.quickcv.ui.reusables.text.TextNInput
import org.koin.androidx.compose.koinViewModel

@Composable
fun Search(vm: searchviewmodel = koinViewModel()) {

    Column() {
        TextNInput(
            label = " ",
            value = vm.search.collectAsState().value,
            onChange = { vm.set_search(it) },

            )
        PrimaryButton(
            "Search", modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(), onclick = { vm.onSearch() })
    }
}