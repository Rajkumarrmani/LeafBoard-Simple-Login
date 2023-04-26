package com.raj.leafboard_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raj.leafboard_login.ui.theme.LeafBoardLoginTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            LeafBoardLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    SingUp()
                }
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SingUp() {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    var email by remember {
        mutableStateOf(
            ""
        )
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisibility: Boolean by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.leaf),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = stringResource(id = R.string.leafBoard),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

        }

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.work_without_limits),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.size(50.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp, bottom = 10.dp
                ),
            text = stringResource(id = R.string.your_email_address),
            fontWeight = FontWeight.Normal,
        )

        TextField(modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp),
            value = email,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            onValueChange = {
                email = it
            })

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp, bottom = 10.dp
                ),
            text = stringResource(id = R.string.choose_password),
            fontWeight = FontWeight.Normal,
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp),
            value = password,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {

                val image = if (passwordVisibility) Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Localized description for accessibility services
                val description = if (passwordVisibility) "Hide password" else "Show password"

                // Toggle button to hide or display password
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = image, description)
                }

            },
            onValueChange = {
                password = it
            },
        )

        Button(
            onClick = {
                focusManager.clearFocus()
                keyboardController?.hide()
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 5.dp, top = 20.dp, end = 5.dp, bottom = 0.dp
                ), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green, contentColor = Color.Black
            )
        ) {
            Text(text = stringResource(id = R.string.btnContinue))
        }

        Button(
            onClick = {

            }, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 5.dp, top = 20.dp, end = 5.dp, bottom = 0.dp
                ), colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White, contentColor = Color.Black
            ), border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Image(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.google),
                contentDescription = ""
            )
            Text(
                text = stringResource(id = R.string.sign_google), modifier = Modifier.padding(6.dp)
            )
        }


        Button(
            onClick = {

            }, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 5.dp, top = 20.dp, end = 5.dp, bottom = 0.dp
                ), colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White, contentColor = Color.Black
            ), border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Image(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.apple),
                contentDescription = ""
            )
            Text(text = stringResource(id = R.string.sign_apple), modifier = Modifier.padding(6.dp))
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeafBoardLoginTheme {
        SingUp()
    }
}