package com.thrivae.testgithub.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import com.thrivae.testgithub.data.db.HistoryUserDbModel
import com.thrivae.testgithub.data.api.ApiFactory
import com.thrivae.testgithub.data.db.AppDatabase
import com.thrivae.testgithub.databinding.FragmentDetailsBinding
import com.thrivae.testgithub.domain.DetailsInfUserDto
import kotlinx.coroutines.launch

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<DetailsViewModel>()
    private lateinit var userDetails: DetailsInfUserDto
    private var userId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userId = arguments?.getString("myArg").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            getDetails()
            setDbHistory()
        }
    }


    private suspend fun getDetails(){
        userDetails = viewModel.getDetailsUser(userId)
        Picasso.get()
            .load(userDetails.avatarUrl)
            .into(binding.imDetAvatar)
        binding.tvDetName.text = userDetails.name
        binding.tvDetType.text = userDetails.type ?: "Empty"
        binding.tvDetEmail.text = userDetails.email ?: "Empty"
        binding.tvDetOrganization.text = userDetails.company ?: "Empty"
        binding.tvDetFollowing.text = userDetails.following ?: "Empty"
        binding.tvDetFollowers.text = userDetails.followers ?: "Empty"
        binding.tvDetCreationDate.text = userDetails.createdAt ?: "Empty"
    }

    private suspend fun setDbHistory(){
        try {
            viewModel.insertDbHistory(userDetails)
        } catch (e: Exception) {
            Log.d("test2", "error $e")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}