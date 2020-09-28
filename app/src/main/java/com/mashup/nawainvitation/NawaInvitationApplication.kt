package com.mashup.nawainvitation

import android.app.Application
import android.provider.Settings
import com.mashup.nawainvitation.base.util.Dlog
import com.mashup.nawainvitation.data.room.database.DatabaseProvider

class NawaInvitationApplication : Application() {

    companion object {

        lateinit var INSTANCE: NawaInvitationApplication
    }

    val deviceIdentifier by lazy {
        Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        DatabaseProvider.initDatabase(this)
        Dlog.d("deviceIdentifier : ${INSTANCE.deviceIdentifier}")
    }
}