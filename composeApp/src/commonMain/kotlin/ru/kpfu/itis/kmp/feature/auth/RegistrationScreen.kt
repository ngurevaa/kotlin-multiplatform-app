package ru.kpfu.itis.kmp.feature.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.already_have_an_account
import exampleapp.composeapp.generated.resources.create_your_new_account
import exampleapp.composeapp.generated.resources.email
import exampleapp.composeapp.generated.resources.login
import exampleapp.composeapp.generated.resources.password
import exampleapp.composeapp.generated.resources.sign_up
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.core.designsystem.component.CustomTextField
import ru.kpfu.itis.kmp.core.ui.noRippleClickable
import ru.kpfu.itis.kmp.feature.auth.presentation.registration.RegistrationAction
import ru.kpfu.itis.kmp.feature.auth.presentation.registration.RegistrationEvent
import ru.kpfu.itis.kmp.feature.auth.presentation.registration.RegistrationViewModel

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = koinViewModel<RegistrationViewModel>(),
    navigateToLogin: () -> Unit
) {
    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    LaunchedEffect(Unit) {
        viewModel.actions.collectLatest { action ->
            when (action) {
                is RegistrationAction.NavigateToLogin -> navigateToLogin()
                is RegistrationAction.ShowError -> {

                }
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            SignUpHeader(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Email(
                email = state.email,
                updateEmail = { obtainEvent(RegistrationEvent.UpdateEmail(it)) },
                modifier = Modifier.widthIn(max = 600.dp).padding(bottom = 48.dp)
            )
            Password(
                password = state.password,
                updatePassword = { obtainEvent(RegistrationEvent.UpdatePassword(it)) },
                modifier = Modifier.widthIn(max = 600.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            SignUpButton(
                signUp = { obtainEvent(RegistrationEvent.SignUp) },
                modifier = Modifier.widthIn(max = 600.dp).padding(top = 16.dp)
            )
            LoginReference(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                onClick = { obtainEvent(RegistrationEvent.ClickLoginReference) }
            )
        }
    }
}

@Composable
internal fun LoginReference(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
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
            modifier = Modifier.noRippleClickable { onClick() }
        )
    }
}

@Composable
internal fun SignUpButton(
    signUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { signUp() },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.sign_up),
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}

@Composable
internal fun SignUpHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.sign_up),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(Res.string.create_your_new_account),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
internal fun Email(
    email: String,
    modifier: Modifier = Modifier,
    updateEmail: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.email),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(email, updateEmail)
    }
}

@Composable
internal fun Password(
    modifier: Modifier = Modifier,
    password: String,
    updatePassword: (String) -> Unit
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.password),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            value = password,
            onValueChange = updatePassword,
            visualTransformation = if (isPasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = null,
                    modifier = Modifier.noRippleClickable { isPasswordVisible = !isPasswordVisible }
                )
            }
        )
    }
}
