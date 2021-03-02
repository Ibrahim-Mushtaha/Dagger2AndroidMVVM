package com.ix.ibrahim7.dagger2application.ui.fragment.dialog


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.ix.ibrahim7.dagger2application.adapter.CountryAdapter
import com.ix.ibrahim7.dagger2application.databinding.DialogCountryBinding
import com.ix.ibrahim7.dagger2application.di.factory.ViewModelFactory
import com.ix.ibrahim7.dagger2application.other.TAG
import com.ix.ibrahim7.dagger2application.ui.viewmodel.CountryViewModel
import com.ix.ibrahim7.dagger2application.ui.viewmodel.PostViewModel
import com.ix.ibrahim7.dagger2application.util.MainApplication
import com.ix.ibrahim7.dagger2application.util.Resource
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class CountryDialog : BottomSheetDialogFragment(){

    private lateinit var mBinding: DialogCountryBinding

    private val country_Adapter by lazy {
        CountryAdapter(ArrayList())
    }

    @Inject
    lateinit var viewModeFactory: ViewModelFactory<CountryViewModel>

    private val viewModel: CountryViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModeFactory).get(CountryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DialogCountryBinding.inflate(inflater, container, false).apply {
            executePendingBindings()
        }
        dialog!!.setCancelable(false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().application as MainApplication).getAppComponent().apply {
            getFragmentComponent().build().injectDialog(this@CountryDialog)
        }


        mBinding.apply {

            rclistcountry.apply {
                adapter = country_Adapter
            }


        }


        viewModel.dataCountrysLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        country_Adapter.apply {
                            this.data.clear()
                            this.data.addAll(data)
                            notifyDataSetChanged()
                        }
                        Log.e("$TAG posts", it.data.toString())
                    }
                }

                is Resource.Error -> {
                    Log.e("$TAG Error", it.message.toString())
                }
                is Resource.Loading -> {

                }
            }
        })

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }








}