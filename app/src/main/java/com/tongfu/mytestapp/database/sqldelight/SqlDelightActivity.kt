package com.tongfu.mytestapp.database.sqldelight

import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.runtime.rx.asObservable
import com.tongfu.mytestapp.Database
import com.tongfu.mytestapp.R
import com.tongfu.mytestapp.database.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class SqlDelightActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private var selectedItemIndex = 0
    private val hockeyPlayerList = ArrayList<HockeyPlayer>()
    private val arrayAdapter by lazy { ArrayAdapter(this, android.R.layout.simple_list_item_1, hockeyPlayerList); }

    @BindView(R.id.lv_content)
    lateinit var lvContent: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_delight)
        ButterKnife.bind(this)
        lvContent.adapter = arrayAdapter


        registerForContextMenu(lvContent)
        subscribe()


    }

    val subscribeSelectAll by lazy { database.playerQueries.selectAll() }

    private fun subscribe(){
        init()
        compositeDisposable.add(
                subscribeSelectAll
                .asObservable(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    hockeyPlayerList.clear()
                    hockeyPlayerList.addAll(it.executeAsList())
                    arrayAdapter.notifyDataSetChanged()
            })
    }

    lateinit var driver: AndroidSqliteDriver
    lateinit var database:Database

    private fun init() {
        driver = AndroidSqliteDriver(Database.Schema , this , "sqlDelight.db")
        database = Database(driver)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenuInfo) {
        val info = menuInfo as AdapterContextMenuInfo
        selectedItemIndex = info.position
        //        menu.setHeaderTitle("操作:" + mSources.get(selectedItemIndex).getName());
        val menuInflater = MenuInflater(this)
        menuInflater.inflate(R.menu.menu_database_list, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_delete -> {
                deleteById(hockeyPlayerList[selectedItemIndex].player_number)
            }
            R.id.item_update -> {
                val editText = EditText(this)
                val builder = AlertDialog.Builder(this)
                builder.setView(editText)
                builder.setTitle("更新用户")
                builder.setPositiveButton("确定") { dialog, which ->
                    val user = hockeyPlayerList[selectedItemIndex]
                    update(HockeyPlayer.Impl(user.player_number , editText.text.toString()))
                }
                builder.setNegativeButton("取消") { dialog, which -> }
                builder.create().show()
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun update(user: HockeyPlayer) {
        init()
        database.playerQueries.update(user.full_name , user.player_number)
        subscribeSelectAll.notifyDataChanged()
    }

    private fun deleteById(id: Long) {
        init()
        database.playerQueries.deleteById(id)
        subscribeSelectAll.notifyDataChanged()
    }
    private fun add(player: HockeyPlayer) {
        init()
        database.playerQueries.insert(System.currentTimeMillis() , player.full_name)
        subscribeSelectAll.notifyDataChanged()
    }

    @OnClick(R.id.btn_add)
    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_add -> {
                val editText = EditText(this)
                val builder = AlertDialog.Builder(this)
                builder.setView(editText)
                builder.setTitle("添加用户")
                builder.setPositiveButton("确定") { dialog, which ->
                    val player:HockeyPlayer = HockeyPlayer.Impl(0 , editText.text.toString())
                    add(player)
                }
                builder.setNegativeButton("取消") { dialog, which -> }
                builder.create().show()
            }
        }
    }


    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
