package com.github.alexeygorovoy.picturesque.ui.developer.singlephoto.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.github.alexeygorovoy.picturesque.R
import com.github.alexeygorovoy.picturesque.api.data.Photo
import com.github.alexeygorovoy.picturesque.dagger.ui.developer.SinglePhotoModule
import com.github.alexeygorovoy.picturesque.ui.common.moxy.BaseMvpFragment
import com.github.alexeygorovoy.picturesque.ui.developer.singlephoto.presenter.SinglePhotoPresenter
import kotlinx.android.synthetic.main.single_photo_fragment.*
import javax.inject.Inject

class SinglePhotoFragment : BaseMvpFragment(), SinglePhotoView {

    @Inject
    @InjectPresenter
    lateinit var presenter: SinglePhotoPresenter

    @ProvidePresenter
    fun providePresenter(): SinglePhotoPresenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.plus(SinglePhotoModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.single_photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh.setOnClickListener { presenter.onRefresh() }
    }

    override fun showPhotoDetails(photo: Photo) {
        Glide.with(requireContext())
            .load(photo.urls.small)
            .into(photoView)
        description.text = photo.description
    }

    override fun showError(errorMessage: String) {
        errors.text = errorMessage
    }

    override fun showProgress() {
        errors.text = "Loading..."
    }

    override fun hideProgress() {
        errors.text = ""
    }

    companion object {
        fun newInstance() = SinglePhotoFragment()
    }
}