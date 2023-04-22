package com.thrivae.testgithub.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.thrivae.testgithub.R
import com.thrivae.testgithub.domain.UserMainDto
import com.thrivae.testgithub.data.api.ApiFactory
import com.thrivae.testgithub.databinding.FragmentUsersBinding
import kotlinx.coroutines.launch


class UsersFragment : Fragment(), MyAdapter.OnUserClickListener {


    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MainViewModel>()

    private lateinit var myAdapter: MyAdapter
    private var countUsersPage = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btHistory.setOnClickListener {
            findNavController().navigate(R.id.action_usersFragment_to_historyFragment)
        }
        myAdapter = MyAdapter()
        myAdapter.onItemClick = this@UsersFragment
        binding.recyclerId.adapter = myAdapter
        lifecycleScope.launch {
            try {
                val users = viewModel.getAllUsers(countUsersPage, 10)
                myAdapter.users = users
            } catch (e: Exception) {
                Log.d("test2", "$e")
            }

        }


        binding.swipeRefreshLayout.setOnRefreshListener {
            lifecycleScope.launch {
                countUsersPage += 10
                try {
                    val users = viewModel.getAllUsers(countUsersPage, 10)
                    myAdapter.users = users
                } catch (e: Exception) {
                    Log.d("test2", "$e")
                }
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onUserClick(user: UserMainDto) {
        val bundle = bundleOf("myArg" to user.login)
        findNavController().navigate(R.id.action_usersFragment_to_deteledFragment, bundle)
    }

}