package com.example.androidmockassignment_iv

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.exampCle.androidmockassignment_iv.ui.ContactsAdapter
import com.exampCle.androidmockassignment_iv.ui.ItemClickListener
import com.example.androidmockassignment_iv.data.database.Contact
import com.example.androidmockassignment_iv.databinding.ActivityMainBinding
import com.example.androidmockassignment_iv.viewModel.ContactViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemClickListener {
    private val CONTACT_PERMISSION_CODE = 100

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ContactsAdapter
    var contactList: ArrayList<Contact> = ArrayList()

    private var list = arrayListOf<Contact>()

    private val viewModel: ContactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ActivityCompat.requestPermissions(
            this@MainActivity,
            arrayOf(Manifest.permission.READ_CONTACTS),
            CONTACT_PERMISSION_CODE
        )
        fetchData()

    }

    private fun fetchData() {

        getContactList()
//        viewModel.deleteAll()
        viewModel.insertToDb(contactList)

        viewModel.getAllContacts().observe(this, Observer {
            list.clear()
            list.addAll(it)
            viewModel.getAllData(list).observe(this, Observer {
                CoroutineScope(Dispatchers.IO).launch {
                    adapter.submitData(it)
                }
            })
            adapter.notifyDataSetChanged()
        })

        adapter = ContactsAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.apply {
            rcRecyclerView.adapter = adapter
            rcRecyclerView.layoutManager = linearLayoutManager
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showToast("Permissions granted.")
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    permissions[0]!!
                )
            ) {
                showToast("Permissions denied.")
            } else {
                showToast("Permissions denied by selecting do not show again")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    private val PROJECTION = arrayOf(
        ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
        ContactsContract.Contacts.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER
    )

    private fun getContactList() {
        val cr = contentResolver
        val cursor: Cursor? = cr.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            PROJECTION,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        if (cursor != null) {
            val mobileNoSet = HashSet<String>()
            try {
                val nameIndex: Int = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                val numberIndex: Int =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                var name: String
                var number: String
                while (cursor.moveToNext()) {
                    name = cursor.getString(nameIndex)
                    number = cursor.getString(numberIndex)
                    number = number.replace(" ", "")
                    if (!mobileNoSet.contains(number)) {
                        contactList.add(Contact(name, number))
                        mobileNoSet.add(number)
                        Log.d(
                            "hvy", "onCreaterrView  Phone Number: name = " + name
                                    + " No = " + number
                        )
                    }
                }
            } finally {
                cursor.close()
            }
        }
    }

    override fun onItemClicked(contact: Contact) {
        val rank = contact.rank

        if (rank != null) {
            contact.rank = rank + 1
        }

        showToast("$rank")
        viewModel.updateContact(contact)
    }
}