package com.dmp.rickandmortyapp.epoxy

import com.dmp.rickandmortyapp.R
import com.dmp.rickandmortyapp.databinding.ModelLoadingBinding

class LoadingEpoxyModel : ViewBindingKotlinModel<ModelLoadingBinding>(R.layout.model_loading) {

    override fun ModelLoadingBinding.bind() {
        // nothing to do
    }

    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
        return totalSpanCount
    }
}