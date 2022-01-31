package com.example.myapplication.presentation.ui.fragments

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.BottomSheetBookDetailsBinding
import com.example.myapplication.domain.model.Book
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookDetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetBookDetailsBinding? = null
    private val binding: BottomSheetBookDetailsBinding get() = _binding!!
    private var book: Book? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = BottomSheetBookDetailsBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setListeners()
        setupBottomSheetHeight()
    }

    private fun setListeners() {
        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    private fun setupBottomSheetHeight() {
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    private fun setupView() {
        binding.apply {
            tvBookName.text = book?.name
            tvBookAuthor.text = book?.author
            tvInfoPages.text = book?.pages
            tvInfoEditor.text = book?.editor
            tvInfoDate.text = book?.date
            tvInfoLanguage.text = book?.language
            tvInfoOriginBookName.text = book?.originName
            tvInfoIsbn10.text = book?.isbn10
            tvInfoIsbn13.text = book?.isbn13

            val spannableString = SpannableString("   ${book?.review}")
            val imageSpan = ImageSpan(requireContext(), R.drawable.quotes_icon)
            spannableString.setSpan(imageSpan, 0, 1, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)

            tvReview.text = spannableString
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(book: Book? = null): BookDetailsBottomSheet {
            return BookDetailsBottomSheet().apply {
                this.book = book
            }
        }
    }

}