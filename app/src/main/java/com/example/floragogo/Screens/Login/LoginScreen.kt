package com.example.floragogo.Screens.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.floragogo.R

@Composable
fun LoginScreen() {
    val focusManager = LocalFocusManager.current

    Surface(modifier = Modifier.fillMaxSize()
        .clickable(interactionSource = remember {  MutableInteractionSource() },
            indication = null) { focusManager.clearFocus()},
        ) {
             Image(
                 painter = painterResource(R.drawable.pexels_kasperphotography_1042423),
                 contentDescription = null,
                 contentScale = ContentScale.Crop,
             )
             Text(
                 "FloraGoGo",
                 style = MaterialTheme.typography.displayLarge,
                 textAlign = TextAlign.Center,
                 modifier = Modifier.padding(top = 50.dp),
             )

        Card(modifier = Modifier.padding(top = 150.dp),
                 shape = RoundedCornerShape(
                     bottomStart = 0.dp,
                     bottomEnd = 0.dp,
                     topStart = 14.dp,
                     topEnd = 14.dp,
                 )
             ) {
                 Column(modifier = Modifier.fillMaxSize().padding(8.dp),
                       horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.Top,
                     ) {
                     Text(
                         modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                         text = stringResource(R.string.login_headline),
                         )
                     Text(
                         modifier = Modifier.fillMaxWidth(),
                         text = stringResource(R.string.email_address),
                         textAlign = TextAlign.Start,
                         )
                     OutlinedTextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = "",
                         onValueChange = { },
                         label = { Text(text = stringResource(R.string.email_address)) },
                         leadingIcon = {
                             Icon(
                                 imageVector = Icons.Default.Email,
                                 contentDescription = null,
                                 tint = MaterialTheme.colorScheme.primary
                             )
                         },
                     )
                     Text(
                         modifier = Modifier.fillMaxWidth(),
                         text = stringResource(R.string.password),
                         textAlign = TextAlign.Start,
                         )
                     OutlinedTextField(
                         modifier = Modifier.fillMaxWidth(),
                         leadingIcon = {
                             Icon(
                                 imageVector = Icons.Default.Email,
                                 contentDescription = null,
                                 tint = MaterialTheme.colorScheme.primary
                             )
                         },
                         value = "",
                         onValueChange = { },
                         label = { Text(text = stringResource(R.string.password)) },
                     )
                     Text(
                         modifier = Modifier.fillMaxWidth(),
                         text = stringResource(R.string.password),
                         textAlign = TextAlign.End,
                         color = MaterialTheme.colorScheme.primary
                         )
                     Button(
                         modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
                         shape = RoundedCornerShape(8.dp),
                         onClick = {} ){
                         Text("Login")
                     }

                     Text(
                         buildAnnotatedString {
                             withStyle(style = SpanStyle(color = Color.Black)) {
                                 append("Don't have an account? ")
                             }
                             withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)) {
                                 append("Sign in")
                             }
                         }
                     )
                 }
             }
     }
}

@Preview(showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}