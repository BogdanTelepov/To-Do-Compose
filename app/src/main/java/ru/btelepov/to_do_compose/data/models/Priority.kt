package ru.btelepov.to_do_compose.data.models


import androidx.compose.ui.graphics.Color
import ru.btelepov.to_do_compose.ui.theme.HighPriorityColor
import ru.btelepov.to_do_compose.ui.theme.LowPriorityColor
import ru.btelepov.to_do_compose.ui.theme.MediumPriorityColor
import ru.btelepov.to_do_compose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {

    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)


}