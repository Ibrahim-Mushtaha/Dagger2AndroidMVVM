package com.ix.ibrahim7.dagger2application.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ix.ibrahim7.dagger2application.adapter.PostAdapter
import com.ix.ibrahim7.dagger2application.databinding.FragmentPostBinding
import com.ix.ibrahim7.dagger2application.di.factory.ViewModelFactory
import com.ix.ibrahim7.dagger2application.other.TAG
import com.ix.ibrahim7.dagger2application.ui.viewmodel.PostViewModel
import com.ix.ibrahim7.dagger2application.util.MainApplication
import com.ix.ibrahim7.dagger2application.util.Resource
import javax.inject.Inject


class PostFragment : Fragment() {

    lateinit var mBinding:FragmentPostBinding

    @Inject
    lateinit var viewModeFactory: ViewModelFactory<PostViewModel>

    private val viewModel: PostViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModeFactory).get(PostViewModel::class.java)
    }

    private val post_adapter by lazy {
        PostAdapter(ArrayList())
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
            adapter = post_adapter
        }


        viewModel.getpost()


        viewModel.dataPostLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        post_adapter.apply {
                            this.data.clear()
                            this.data.addAll(data)
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

}