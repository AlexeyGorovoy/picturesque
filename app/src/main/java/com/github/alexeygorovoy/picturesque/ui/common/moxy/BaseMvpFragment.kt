package com.github.alexeygorovoy.picturesque.ui.common.moxy

import com.github.alexeygorovoy.picturesque.dagger.activity.ActivityComponent
import com.github.alexeygorovoy.picturesque.ui.common.BaseActivity
import es.dmoral.toasty.Toasty

open class BaseMvpFragment : MvpAppCompatFragment(), BaseMvpView {

    protected val activityComponent: ActivityComponent
        get() = baseActivity.getActivityComponent()

    protected val baseActivity: BaseActivity
        get() = requireActivity() as BaseActivity

    override fun showInfoToast(message: CharSequence) {
        Toasty.info(requireActivity(), message.toString()).show()
    }

    override fun showErrorToast(message: CharSequence) {
        Toasty.error(requireActivity(), message.toString()).show()
    }

    override fun showSuccessToast(message: CharSequence) {
        Toasty.success(requireActivity(), message.toString()).show()
    }

    /**
     * @return true if handled in this method
     */
    fun onBackPressed(): Boolean {
        return false
    }
}
