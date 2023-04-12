package com.nicksemin.composestate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState()
    ) {
       items(
           items = list,
           key = { task -> task.id }
       ) { task ->
            WellnessTaskItem(taskName = task.label,
                checked = task.checked,
                onClose = { onCloseTask(task) },
                onCheckedChange = { checked -> onCheckedTask(task, checked) })
       }
    }
}