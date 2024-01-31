package com.vlamik.nba.features.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vlamik.nba.R
import com.vlamik.nba.component.Toast

@Composable
fun PlayerDetailsScreen(detailsViewModel: PlayersDetailsViewModel) {
    val playerListUpdateState by detailsViewModel.updateState.collectAsState()

    when (val state = playerListUpdateState) {
        PlayersDetailsViewModel.UiState.ErrorFromAPI -> Toast(R.string.api_error)
        PlayersDetailsViewModel.UiState.LoadingFromAPI -> Unit
        is PlayersDetailsViewModel.UiState.Success -> {
            Column(
                modifier = Modifier
                    .systemBarsPadding()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.player_detail, state.player.title),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}