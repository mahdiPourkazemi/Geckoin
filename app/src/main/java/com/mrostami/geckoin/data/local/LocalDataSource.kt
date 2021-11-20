package com.mrostami.geckoin.data.local

import com.mrostami.geckoin.data.local.dao.GlobalInfoDao
import com.mrostami.geckoin.data.local.dao.PreferencesDao
import com.mrostami.geckoin.data.local.preferences.PreferencesHelper
import com.mrostami.geckoin.model.GlobalMarketInfo
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val cryptoDataBase: CryptoDataBase,
    private val preferencesHelper: PreferencesHelper
) : PreferencesDao, GlobalInfoDao {

    private val globalInfoDao: GlobalInfoDao by lazy { cryptoDataBase.globalInfoDao() }

    override fun setSelectedTheme(mode: Int) {
        preferencesHelper.selectedThemeMode = mode
    }

    override fun getSelectedTheme(): Int {
        return preferencesHelper.selectedThemeMode
    }

    override fun getAuthToken(): String? {
        return preferencesHelper.authToken
    }

    override fun setAuthToken(token: String) {
        preferencesHelper.authToken = token
    }

    override suspend fun putGlobalInfo(info: GlobalMarketInfo) {
        globalInfoDao.putGlobalInfo(info)
    }

    override suspend fun getGlobalMarketInfo(id: Int): GlobalMarketInfo? {
        return globalInfoDao.getGlobalMarketInfo(id = 1)
    }

    override suspend fun clearGlobalMarketInfo() {
        globalInfoDao.clearGlobalMarketInfo()
    }
}