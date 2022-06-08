package com.plcoding.errorhandlingcleanarch.data

import com.plcoding.errorhandlingcleanarch.domain.MyRepository
import com.plcoding.errorhandlingcleanarch.util.Resource
import com.plcoding.errorhandlingcleanarch.util.UiText
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyRepositoryImpl: MyRepository {
    override suspend fun submitEmail(email: String): Resource<Unit> {
        delay(500L)
        return if(Random.nextBoolean()) {
            Resource.Success(Unit)
        } else {
            if(Random.nextBoolean()) {
                Resource.Error(
                    UiText.DynamicString("Not authenticated")
                )
            } else Resource.Error(
                UiText.DynamicString("Server error")
            )
        }
    }
}