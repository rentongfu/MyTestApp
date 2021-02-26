package com.tongfu.mytestapp.contact

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.tongfu.mytestapp.R

class ContactActivity : AppCompatActivity() {
    data class MyContact(public val contactId:String, public val displayName:String , public val phoneNumber:String){
    }
    private val lvContact by lazy { findViewById<ListView>(R.id.lv_contact) }
    private val myContactList = ArrayList<MyContact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        lvContact.adapter = object: BaseAdapter() {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val view = convertView ?: layoutInflater.inflate(R.layout.layout_contact_item , parent ,false)
                val contact = getItem(position) as MyContact
                view.findViewById<TextView>(R.id.tv_display_name).text = contact.displayName
                view.findViewById<TextView>(R.id.tv_contact_id).text = contact.contactId
                view.findViewById<TextView>(R.id.tv_phone).text = contact.phoneNumber
                return view
            }

            override fun getItem(position: Int): Any = myContactList[position]

            override fun getItemId(position: Int): Long = position.toLong()

            override fun getCount(): Int = myContactList.size
        }

//        val permissionList = arrayOf<String>(Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            loadContact()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
                    requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 1)
                } else {
                    requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 1)
                    Toast.makeText(this, "权限已被多次拒绝，需要到设置中手动设置", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            loadContact()
        }else{
            Toast.makeText(this , "权限请求被拒绝" , Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadContact(){
        myContactList.clear()
        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null , null , null ,null)
        if(cursor==null){
            Toast.makeText(this , "load contact failed!" , Toast.LENGTH_SHORT).show()
            return
        }
        while(cursor.moveToNext()){
            val contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
            val displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            val phoneCursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI , null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+contactId , null , null)
            val phone = if(phoneCursor!=null){
                val tmpPhone = if(phoneCursor.moveToNext()){
                    phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                }else{
                    ""
                }
                phoneCursor.close()
                tmpPhone
            }else{
                ""
            }
            myContactList.add(MyContact(contactId , displayName , phone))
        }
        cursor.close()
    }
}