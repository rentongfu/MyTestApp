package com.tongfu.mytestapp.database.sqldelight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.runtime.rx.asObservable
import com.tongfu.mytestapp.Database
import com.tongfu.mytestapp.R
import io.reactivex.schedulers.Schedulers

class SqlDelightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_delight)
        val driver = AndroidSqliteDriver(Database.Schema , this , "sqlDelight.db")
        val database = Database(driver)
        database.playerQueries.selectAll().asObservable(Schedulers.io())

    }
}
