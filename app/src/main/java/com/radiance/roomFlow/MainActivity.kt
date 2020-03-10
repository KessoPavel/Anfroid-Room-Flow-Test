package com.radiance.roomFlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.radiance.roomFlow.db.AppDatabase
import com.radiance.roomFlow.db.enity.User
import com.radiance.roomFlow.ui.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val adapter: UserAdapter by lazy {
        UserAdapter(ArrayList())
    }

    private val db by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "db")
            .allowMainThreadQueries().build()
    }

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        val userFlow = db.userDao().getAll()

        GlobalScope.launch(Dispatchers.Main) {
            userFlow.collect { userList ->
                adapter.data = userList
                adapter.notifyDataSetChanged()
            }
        }

        add.setOnClickListener {
            val firstName = first_name.text.toString()
            val secondName = second_name.text.toString()

            db.userDao().insertAll(User(0, firstName, secondName))
        }
    }


}
