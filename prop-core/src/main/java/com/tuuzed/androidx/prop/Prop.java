package com.tuuzed.androidx.prop;

public interface Prop<T> {

    void set(T value);

    T get();

    void clear();

}
