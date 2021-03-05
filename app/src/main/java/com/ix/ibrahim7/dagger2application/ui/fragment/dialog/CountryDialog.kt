package com.ix.ibrahim7.dagger2application.ui.fragment.dialog


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.adapter.GenericAdapter
import com.ix.ibrahim7.dagger2application.databinding.DialogCountryBinding
import com.ix.ibrahim7.dagger2application.di.factory.ViewModelFactory
import com.ix.ibrahim7.dagger2application.model.country.CountryItem
import com.ix.ibrahim7.dagger2application.other.TAG
import com.ix.ibrahim7.dagger2application.ui.viewmodel.CountryViewModel
import com.ix.ibrahim7.dagger2application.util.MainApplication
import com.ix.ibrahim7.dagger2application.util.Resource
import javax.inject.Inject

class CountryDialog : BottomSheetDialogFragment(),GenericAdapter.OnListItemViewClickListener{

    private lateinit var mBinding: DialogCountryBinding

    private val countryAdapter by lazy {
        GenericAdapter<CountryItem>(R.layout.item_country, BR.Country)
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
                adapter = countryAdapter
            }


        }


        viewModel.dataCountrysLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        countryAdapter.apply {
                            this.addItems(data)
                            mBinding.loadingProgressBar.visibility=View.GONE
                            notifyDataSetChanged()
                        }
                        Log.e("$TAG posts", it.data.toString())
                    }
                }

                is Resource.Error -> {
                    mBinding.loadingProgressBar.visibility=View.INVISIBLE
                    Log.e("$TAG Error", it.message.toString())
                }
                is Resource.Loading -> {
                    mBinding.loadingProgressBar.visibility=View.VISIBLE
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

    override fun onClick(view: View, position: Int, type: Int) {

    }


}