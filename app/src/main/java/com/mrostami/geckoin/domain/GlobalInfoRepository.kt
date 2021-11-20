package com.mrostami.geckoin.domain

import com.mrostami.geckoin.domain.base.Result
import com.mrostami.geckoin.model.GlobalMarketInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GlobalInfoRepository {
    fun getMarketInfo(forceRefresh: Boolean) : Flow<Result<GlobalMarketInfo>> = flow {  }
}