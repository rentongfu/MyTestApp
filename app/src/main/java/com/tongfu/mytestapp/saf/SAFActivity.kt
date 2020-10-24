package com.tongfu.mytestapp.saf

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toFile
import androidx.documentfile.provider.DocumentFile
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R
import java.io.*
import java.lang.StringBuilder
import java.net.URI

class SAFActivity : AppCompatActivity() {

    val REQUEST_CODE_CREATE = 1
    val REQUEST_CODE_OPEN = 2
    val REQUEST_CODE_OPEN_TREE = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_a_f)
        ButterKnife.bind(this)
    }
    @OnClick(R.id.btn_create_document , R.id.btn_open_document , R.id.btn_open_document_tree)
    fun onClick(view:View){
        when(view.id){
            R.id.btn_create_document->{
                val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.setType("mytype/*")
                intent.putExtra(Intent.EXTRA_TITLE , "abc.mytype")
                startActivityForResult(intent , REQUEST_CODE_CREATE)
            }
            R.id.btn_open_document->{
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.setType("mytype/*")
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE , true)
                startActivityForResult(intent , REQUEST_CODE_OPEN)
            }
            R.id.btn_open_document_tree->{
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
                startActivityForResult(intent , REQUEST_CODE_OPEN_TREE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            REQUEST_CODE_CREATE->{
                if(data == null||data.data == null){
                    Toast.makeText(this , "获取数据失败 " , Toast.LENGTH_SHORT).show()
                    return
                }
                var writer:Writer?=null
                try {
                    val os = contentResolver.openOutputStream(data.data!!)
                    writer = BufferedWriter(OutputStreamWriter(os))
                    writer.write("千里之行，始于足下")
                    Toast.makeText(this , "写入成功 " , Toast.LENGTH_SHORT).show()
                }catch (e:IOException){
                    Toast.makeText(this , "写入失败 " , Toast.LENGTH_SHORT).show()
                }finally {
                    try {
                        writer?.close()
                    }catch (e:IOException){}
                }
            }
            REQUEST_CODE_OPEN->{
                if(data == null||data.data == null){
                    Toast.makeText(this , "获取数据失败 " , Toast.LENGTH_SHORT).show()
                    return
                }
                val cursor = contentResolver.query(data.data!! ,null ,null , null ,null,null)
                if(cursor!=null&& cursor.moveToFirst()){
                    val documentId = cursor.getString(cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DOCUMENT_ID))
                    val name = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                    val size = cursor.getString(cursor.getColumnIndex(OpenableColumns.SIZE))

                    Log.i("SAFActivity" ,"documentId:$documentId,name:$name,size:$size")
                }

                var reader : Reader? = null
                try {
                    val instream = contentResolver.openInputStream(data.data!!)
                    reader =BufferedReader( InputStreamReader(instream))
                    var line :String?= reader.readLine()
                    val sb = StringBuffer()
                    while(null != line ){
                        sb.append(line)
                        line = reader.readLine()
                    }
                    Toast.makeText(this , "文件内容：${sb.toString()}" , Toast.LENGTH_SHORT).show()
                }catch (e:IOException){
                    Toast.makeText(this , "读取文件失败" , Toast.LENGTH_SHORT).show()
                }finally {
                    try {
                        reader?.close()
                    }catch (e:IOException){}
                }

            }
            REQUEST_CODE_OPEN_TREE->{
                if(data == null||data.data == null){
                    Toast.makeText(this , "获取数据失败 " , Toast.LENGTH_SHORT).show()
                    return
                }
                val takeFlags = (intent.flags
                        and (Intent.FLAG_GRANT_READ_URI_PERMISSION
                        or Intent.FLAG_GRANT_WRITE_URI_PERMISSION))
                contentResolver.takePersistableUriPermission(data.data!! , takeFlags)

//                val cursor = contentResolver.query(data.data!! ,null ,null , null ,null,null)
//                if(cursor!=null&& cursor.moveToFirst()){
//                    val documentId = cursor.getString(cursor.getColumnIndex(DocumentsContract.Document.COLUMN_DOCUMENT_ID))
//                    val name = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                    val size = cursor.getString(cursor.getColumnIndex(OpenableColumns.SIZE))
//
//                    Log.i("SAFActivity" ,"documentId:$documentId,name:$name,size:$size")
//
//                    val documentUri = DocumentsContract.buildDocumentUriUsingTree(data.data!! ,documentId)
//                }

                val document = DocumentFile.fromTreeUri(this , data.data!!)
                if(document == null){
                    Toast.makeText(this , "读取文件失败，可能是由于SDK版本低于21导致的" , Toast.LENGTH_SHORT).show()
                    return
                }
                var abcDocument :DocumentFile? = null
                document.listFiles().forEach {
                    if(it.name == "abc.mytype"){
                        abcDocument= it
                    }
                }
                val messageSB = StringBuilder("读取文件树成功，文件数量为${document.listFiles().size}，")
                if(abcDocument == null){
                    messageSB.append("abc.mytype未创建。")
                }else{
                    messageSB.append("abc.mytype已创建。")
                }

                val dialogBuilder = AlertDialog.Builder(this).setMessage(messageSB.toString())
                        .setTitle("成功")
                if(abcDocument == null){
                    dialogBuilder.setPositiveButton("创建abc.mytype") { dialog, which->
                        abcDocument = document.createFile("mytype/*" , "abc.mytype")
                        if(abcDocument==null){
                            Toast.makeText(this@SAFActivity , "创建abc.mytype失败" ,Toast.LENGTH_SHORT).show()
                            return@setPositiveButton
                        }
                        var writer:Writer?=null
                        try {
                            val os = contentResolver.openOutputStream(abcDocument!!.uri)
                            writer = BufferedWriter(OutputStreamWriter(os))
                            writer?.write("壁立千仞，无欲则刚")
                            Toast.makeText(this , "写入成功 " , Toast.LENGTH_SHORT).show()
                        }catch (e:IOException){
                            Toast.makeText(this , "写入失败 " , Toast.LENGTH_SHORT).show()
                        }finally {
                            try {
                                writer?.close()
                            }catch (e:IOException){}
                        }
                    }
                }else{
                    dialogBuilder.setPositiveButton("读取abc.mytype") { dialog, which->
                        var reader : BufferedReader? = null
                        try {
                            val instream = contentResolver.openInputStream(abcDocument!!.uri)
                            reader =BufferedReader( InputStreamReader(instream))
                            var line :String?= reader?.readLine()
                            val sb = StringBuffer()
                            while(null != line ){
                                sb.append(line)
                                line = reader?.readLine()
                            }
                            Toast.makeText(this , "文件内容：${sb.toString()}" , Toast.LENGTH_SHORT).show()
                        }catch (e:IOException){
                            Toast.makeText(this , "读取文件失败" , Toast.LENGTH_SHORT).show()
                        }finally {
                            try {
                                reader?.close()
                            }catch (e:IOException){}
                        }

                    }
                }
                dialogBuilder.setNegativeButton("取消") { _,_->
                }
                dialogBuilder.create().show()

            }
            else->{
                super.onActivityResult(requestCode, resultCode, data)
            }
        }

    }
}
