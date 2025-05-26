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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.do_not_have_an_account
import exampleapp.composeapp.generated.resources.enter_into_your_account
import exampleapp.composeapp.generated.resources.register
import exampleapp.composeapp.generated.resources.sign_in
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.feature.auth.presentation.login.LoginEvent
import ru.kpfu.itis.kmp.feature.auth.presentation.login.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel<LoginViewModel>()
) {
    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            SignInHeader(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Email(
                email = state.email,
                updateEmail = { obtainEvent(LoginEvent.UpdateEmail(it)) },
                modifier = Modifier.widthIn(max = 600.dp).padding(bottom = 48.dp)
            )
            Password(
                password = state.password,
                updatePassword = { obtainEvent(LoginEvent.UpdatePassword(it)) },
                modifier = Modifier.widthIn(max = 600.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            SignInButton(
                signIn = { obtainEvent(LoginEvent.SignIn) },
                modifier = Modifier.widthIn(max = 600.dp).padding(top = 16.dp)
            )
            RegistrationReference(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
        }
    }
}

@Composable
internal fun SignInHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.sign_in),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(Res.string.enter_into_your_account),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
internal fun SignInButton(
    modifier: Modifier = Modifier,
    signIn: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { signIn },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.sign_in),
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}

@Composable
internal fun RegistrationReference(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(Res.string.do_not_have_an_account),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = stringResource(Res.string.register),
            style = MaterialTheme.typography.bodyLarge,
            textDecoration = TextDecoration.Underline,
        )
    }
}
