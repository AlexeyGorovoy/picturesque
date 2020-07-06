package com.github.alexeygorovoy.picturesque.ui.common

import androidx.fragment.app.Fragment
import es.dmoral.toasty.Toasty

open class BaseFragment : Fragment() {

    protected val baseActivity: BaseActivity
        get() = requireActivity() as BaseActivity

    fun showInfoToast(message: CharSequence) {
        Toasty.info(requireActivity(), message.toString()).show()
    }

    fun showErrorToast(message: CharSequence) {
        Toasty.error(requireActivity(), message.toString()).show()
    }

    fun showSuccessToast(message: CharSequence) {
        Toasty.success(requireActivity(), message.toString()).show()
    }

    /**
     * @return true if handled in this method
     */
    fun onBackPressed(): Boolean {
        return false
    }
}
