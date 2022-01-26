package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Book

class BookListAdapter : ListAdapter<Book, BookListAdapter.BookListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        return BookListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem == newItem
        }
    }

    class BookListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val bookTitle: AppCompatTextView = view.findViewById(R.id.book_title)
        private val bookAuthor: AppCompatTextView = view.findViewById(R.id.book_author)
        private val bookPages: AppCompatTextView = view.findViewById(R.id.book_pages)
        private val bookEditor: AppCompatTextView = view.findViewById(R.id.book_editor)
        private val bookDate: AppCompatTextView = view.findViewById(R.id.book_date)

        fun bind(book: Book) {
            bookTitle.text = book.name
            bookAuthor.text = book.author
            bookPages.text = book.pages
            bookEditor.text = book.editor
            bookDate.text = book.date
        }

        companion object {
            fun create(parent: ViewGroup): BookListViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
                return BookListViewHolder(view)
            }
        }

    }


}