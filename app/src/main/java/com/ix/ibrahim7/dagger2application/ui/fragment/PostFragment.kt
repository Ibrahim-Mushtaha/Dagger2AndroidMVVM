package com.ix.ibrahim7.dagger2application.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.adapter.GenericAdapter
import com.ix.ibrahim7.dagger2application.databinding.FragmentPostBinding
import com.ix.ibrahim7.dagger2application.di.factory.ViewModelFactory
import com.ix.ibrahim7.dagger2application.model.post.PostItem
import com.ix.ibrahim7.dagger2application.other.TAG
import com.ix.ibrahim7.dagger2application.ui.fragment.dialog.CountryDialog
import com.ix.ibrahim7.dagger2application.ui.viewmodel.PostViewModel
import com.ix.ibrahim7.dagger2application.util.MainApplication
import com.ix.ibrahim7.dagger2application.util.Resource
import androidx.databinding.library.baseAdapters.BR
import javax.inject.Inject


class PostFragment : Fragment() ,GenericAdapter.OnListItemViewClickListener{

    lateinit var mBinding:FragmentPostBinding

    @Inject
    lateinit var viewModeFactory: ViewModelFactory<PostViewModel>

    private val viewModel: PostViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModeFactory).get(PostViewModel::class.java)
    }

    private val postAdapter by lazy {
        GenericAdapter<PostItem>(R.layout.item_post,BR.Post)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentPostBinding.inflate(inflater,container,false).apply {
            executePendingBindings()
        }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity().application as MainApplication).getAppComponent().apply {
            getFragmentComponent().build().injectfragment(this@PostFragment)
        }


        mBinding.rcPostList.apply {
            adapter = postAdapter
        }

        mBinding.btnShowCountry.setOnClickListener {
            CountryDialog().show(childFragmentManager,"")
        }

        viewModel.getpost()
        postAdapter.setOnListItemViewClickListener(this)

        viewModel.dataPostLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        postAdapter.apply {
                            this.addItems(data)
                            mBinding.loadingProgressBar.visibility=View.INVISIBLE
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


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(view: View, position: Int,type:Int) {
       when(type){
           1->{
             Toast.makeText(requireContext(),postAdapter.data[position].title,Toast.LENGTH_SHORT).show()
           }
       }
    }

}