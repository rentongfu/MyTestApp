package com.tongfu.mytestapp.video

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import butterknife.BindView
import butterknife.ButterKnife
import com.tongfu.mytestapp.R
import com.tongfu.mytestapp.video.VideoPlayEntryActivity
import java.util.*

class VideoPlayEntryActivity : AppCompatActivity() {
    var loaderManager: LoaderManager? = null

    //    @BindView(R.id.et_url)
    //    EditText etUrl ;
    var viewUrls: MutableList<String> = ArrayList()

    @BindView(R.id.lv_main)
    lateinit var lvMain: ListView
    var adapter: BaseAdapter = object : BaseAdapter() {
        override fun getCount(): Int {
            return viewUrls.size
        }

        override fun getItem(position: Int): Any {
            return viewUrls[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView?:layoutInflater.inflate(R.layout.layout_video_list_view_item, parent, false)
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            tvName.text = viewUrls[position]
            return view
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play_entry)
        ButterKnife.bind(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
            }
        }
        loaderManager = LoaderManager.getInstance(this)
        loaderManager!!.initLoader(1, Bundle(), object : LoaderManager.LoaderCallbacks<Cursor> {
            override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
                return CursorLoader(this@VideoPlayEntryActivity,
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.Video.Thumbnails.DATA), null, null, null)
            }

            override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor) {
//                Toast.makeText(LoaderManagerActivity.this , "获取到" + data.size() + "条数据" , Toast.LENGTH_SHORT).show();
                while (data.moveToNext()) {
                    viewUrls.add(data.getString(data.getColumnIndex(MediaStore.Video.Thumbnails.DATA)))
                }
                adapter.notifyDataSetChanged()
            }

            override fun onLoaderReset(loader: Loader<Cursor>) {
                viewUrls.clear()
                adapter.notifyDataSetChanged()
                //                Toast.makeText(LoaderManagerActivity.this , "加载被重置" , Toast.LENGTH_SHORT).show();
            }
        }).forceLoad()
        lvMain?.adapter = adapter
        lvMain?.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val url = viewUrls[position]
            val intent = Intent(this@VideoPlayEntryActivity, ExoVideoPlayActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        }
    }

    //    @OnClick(R.id.btn_play)
    //    public void onClick(){
    //        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
    //            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
    //                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} , 1 );
    //            }else{
    //                checkAndToPlayActivity();
    //            }
    //        }else {
    //            checkAndToPlayActivity();
    //        }
    //    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                checkAndToPlayActivity();
            }
        }
    } //    void checkAndToPlayActivity(){
    //        if(etUrl.getText().length() == 0){
    //            Toast.makeText(this , "请输入视频文件路径" ,Toast.LENGTH_SHORT).show();
    //            return ;
    //        }
    //        String url = etUrl.getText().toString();
    //        File file = new File(url);
    //        if(!file.exists()){
    //            Toast.makeText(this , "视频文件不存在" ,Toast.LENGTH_SHORT).show();
    //            return ;
    //        }
    //        Intent intent = new Intent(this , VideoPlayActivity.class);
    //        intent.putExtra("url" , url );
    //        startActivity(intent);
    //    }
}