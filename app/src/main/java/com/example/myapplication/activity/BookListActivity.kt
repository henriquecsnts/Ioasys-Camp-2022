package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.BookListAdapter
import com.example.myapplication.model.Book

class BookListActivity : AppCompatActivity() {

    private lateinit var bookListAdapter: BookListAdapter
    private val rvBooks: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        setBookListData()
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter()
        rvBooks.adapter = bookListAdapter

        bookListAdapter.submitList(Book.getMockList())
    }
}