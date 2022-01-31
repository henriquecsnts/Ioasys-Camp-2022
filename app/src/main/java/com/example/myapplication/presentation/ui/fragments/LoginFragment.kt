package com.example.myapplication.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.presentation.viewmodel.LoginViewModel
import com.example.myapplication.util.ViewState

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        addObserver()
    }

    private fun setListener() {
        binding.btnEnter.setOnClickListener {
            binding.run {
                viewModel.login(
                    editTxtEmail.text.toString(),
                    editTxtPasswd.text.toString()
                )
                editTxtEmail.addTextChangedListener {
                    binding.txtError.visibility = View.GONE
                }
                editTxtPasswd.addTextChangedListener {
                    binding.txtError.visibility = View.GONE
                }
            }
        }
    }

    private fun addObserver() {
        viewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToBookListFragment()
                    )
                }
                is ViewState.Error -> {
                    binding.txtError.visibility = View.VISIBLE
                    binding.loginProgressBar.visibility = View.GONE
                }
                is ViewState.Loading -> {
                    binding.loginProgressBar.visibility = View.VISIBLE
                }
                else -> Unit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.resetViewState()
        _binding = null
    }

}