package com.vlamik.core.domain

import com.vlamik.core.commons.logd
import com.vlamik.core.data.repositories.PlayerRepository
import com.vlamik.core.domain.models.PlayerDetails
import com.vlamik.core.domain.models.toModel
import javax.inject.Inject

class GetPlayer @Inject constructor(
    private val playerRepository: PlayerRepository,
) {
    suspend operator fun invoke(id: Int): Result<PlayerDetails> {
        return playerRepository.getPlayerDetails(id).map { playerDetails ->
            logd(" PlayerId: " + playerDetails.id)
            playerDetails.toModel()
        }
    }
}
