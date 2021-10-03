package com.example.convidados.service.repository

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

//classe utilizada para pegar a instância do banco
abstract class GuestDataBase : RoomDatabase() {

    companion object {

        private lateinit var INSTANCE: GuestDataBase
        fun getDataBase(context: Context): GuestDataBase {
            if(!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context, GuestDataBase::class.java, "guestDB")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}