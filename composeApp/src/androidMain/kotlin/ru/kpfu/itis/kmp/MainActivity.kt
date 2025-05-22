package ru.kpfu.itis.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.already_have_an_account
import exampleapp.composeapp.generated.resources.create_your_new_account
import exampleapp.composeapp.generated.resources.email
import exampleapp.composeapp.generated.resources.login
import exampleapp.composeapp.generated.resources.password
import exampleapp.composeapp.generated.resources.sign_up
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.feature.BookScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme { BookScreen() }
        }
    }
}

@Preview
@Composable
fun RegistrationScreen() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                SignUpHeader(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 100.dp)
                )
                Email(
                    modifier = Modifier.padding(bottom = 48.dp)
                )
                Password()
                Spacer(modifier = Modifier.weight(1f))
                SignUpButton()
                LoginReference(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 64.dp)
                )
            }
        }
    }
}

@Composable
fun LoginReference(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(Res.string.already_have_an_account),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = stringResource(Res.string.login),
            style = MaterialTheme.typography.bodyLarge,
            textDecoration = TextDecoration.Underline,
        )
    }
}

@Composable
fun SignUpButton() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = stringResource(Res.string.sign_up),
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Composable
fun SignUpHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Sign up",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(Res.string.create_your_new_account),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Email(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.email),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField("", {})
    }
}

@Composable
fun Password(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.password),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField("", {})
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.surfaceContainerHighest,
                        RoundedCornerShape(percent = 30)
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.weight(1f)) {
                    innerTextField()
                }
            }
        },
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation
    )
}
