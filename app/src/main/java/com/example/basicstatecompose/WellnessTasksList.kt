package com.example.basicstatecompose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
    onCheckedTask: (WellnessTask,Boolean)-> Unit
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(items=list,
            key = {task -> task.id}
        ) { task ->
            WellnessTaskItem(taskName = task.label, onClose = {onCloseTask(task)},
                checked = task.checked, onCheckedChange = {checked->
                    onCheckedTask(task,checked)
                })
        }
    }
}