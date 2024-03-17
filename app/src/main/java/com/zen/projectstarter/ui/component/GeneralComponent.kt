package com.zen.projectstarter.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.zen.projectstarter.R
import com.zen.projectstarter.ui.theme.editTextCursorColor
import com.zen.projectstarter.ui.theme.generalPadding
import com.zen.projectstarter.ui.theme.halfGeneralPadding
import com.zen.projectstarter.ui.theme.normalTextSize
import com.zen.projectstarter.ui.theme.onSurface
import com.zen.projectstarter.ui.theme.placeholder
import com.zen.projectstarter.ui.theme.surface

@Composable
fun GeneralEditText(
    text : MutableState<String>,
    modifier: Modifier,
    singleLine : Boolean = true,
    enable : Boolean = true
) {
    Box {
        BasicTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = modifier
                .padding(horizontal = generalPadding, vertical = halfGeneralPadding)
                .clip(RoundedCornerShape(generalPadding))
                .background(surface)
                .padding(generalPadding),
            singleLine = singleLine,
            cursorBrush = Brush.linearGradient(listOf(editTextCursorColor, editTextCursorColor)),
            textStyle = TextStyle.Default.copy(
                color = onSurface,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontSize = normalTextSize
            ),
            enabled = enable
        ){
            it()
            if(text.value.isEmpty()) {
                Text(
                    text = "Enter text",
                    style = TextStyle.Default.copy(
                        color = placeholder,
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = normalTextSize
                    )
                )
            }
        }
    }
}

