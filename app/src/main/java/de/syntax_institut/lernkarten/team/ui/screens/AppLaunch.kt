package de.syntax_institut.lernkarten.team.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import de.syntax_institut.lernkarten.team.R
import kotlinx.coroutines.delay
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Composable
fun AppLaunch(

    duration: Duration,
    onLaunchComplete: () -> Unit
) {

    LaunchedEffect(Unit) {

        delay(duration.inWholeMilliseconds)
        onLaunchComplete()
    }

    Box(

        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {

        // TODO sts 28.04.25 - animation implement ?!?!

        Image(

            painter = painterResource(R.drawable.launch_bg),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppLauncherPreview() {

    AppLaunch(
        duration = 100.seconds,
        onLaunchComplete = { }
    )
}