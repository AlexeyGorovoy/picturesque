package com.github.alexeygorovoy.picturesque.ui.singlephoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.api.data.Photo
import com.github.alexeygorovoy.picturesque.ui.common.BaseFragment
import kotlinx.android.synthetic.main.single_photo_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class SinglePhotoFragment : BaseFragment() {

    private val viewModel: SinglePhotoViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.single_photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refresh.setOnClickListener { viewModel.onRefresh() }

        viewModel.progress.observe(this, Observer { progress ->
            if (progress) {
                showProgress()
            } else {
                hideProgress()
            }
        })

        viewModel.singlePhotoResult.observe(this, Observer { photoResult ->
            photoResult.fold({ photo ->
                showPhotoDetails(photo)
            }, { throwable ->
                showError(throwable.message ?: "An error occurred")
            })
        })

        viewModel.onRefresh()
    }

    private fun showPhotoDetails(photo: Photo) {
        Glide.with(requireContext())
            .load(photo.urls.small)
            .into(photoView)
        description.text = photo.description
    }

    private fun showError(errorMessage: String) {
        errors.text = errorMessage
    }

    private fun showProgress() {
        errors.text = "Loading..."
    }

    private fun hideProgress() {
        errors.text = ""
    }

    companion object {
        fun newInstance() = SinglePhotoFragment()
    }
}