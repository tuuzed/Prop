package com.tuuzed.androidx.prop;


import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods(
        @BindingMethod(type = TextView.class, attribute = "bind:prop", method = "bindProp")
)
public class BindingAdapters {

    @BindingAdapter("bind:prop")
    public void bindProp(TextView view, Prop<?> prop) {
        view.setText(prop.get().toString());
    }
}
