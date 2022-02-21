package com.example.myapplication.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.presentation.viewmodel.LoginViewModel
import com.example.myapplication.util.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val loginViewModel: LoginViewModel by lazy {
        getViewModel()
    }

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
                loginViewModel.login(
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
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->
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
        loginViewModel.resetViewState()
        _binding = null
    }
}

