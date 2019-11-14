package com.tuuzed.androidx.prop;


import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter("bind:prop")
    public void bindProp(TextView view, Prop<?> prop) {
        view.setText(prop.get().toString());
    }
}
