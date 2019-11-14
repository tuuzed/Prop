package com.tuuzed.androidx.prop;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.util.Set;

public class SharedPreferencesProp<T> implements Prop<T> {

    private SharedPreferences sp;
    private String key;
    private T defValue;

    public SharedPreferencesProp(@NonNull SharedPreferences sp, @NonNull String key, @NonNull T defValue) {
        this.sp = sp;
        this.key = key;
        this.defValue = defValue;
    }

    @Override
    public void set(T value) {
        set(sp, key, value);
    }

    @Override
    public T get() {
        return get(sp, key, defValue);
    }

    @Override
    public void clear() {
        sp.edit().clear().apply();
    }

    @SuppressWarnings("unchecked")
    private static void set(@NonNull SharedPreferences sp, @NonNull String key, @NonNull Object value) {
        final Class<?> clazz = value.getClass();
        SharedPreferences.Editor editor = sp.edit();

        if (value instanceof Boolean) {
            editor.putBoolean(key, (boolean) value);
        } else if (value instanceof Byte) {
            editor.putInt(key, (byte) value);
        } else if (value instanceof Character) {
            editor.putInt(key, (char) value);
        } else if (value instanceof Short) {
            editor.putInt(key, (short) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (int) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (float) value);
        } else if (value instanceof Double) {
            editor.putString(key, value.toString());
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set<String>) value);
        } else if (value instanceof Enum) {
            editor.putString(key, ((Enum) value).name());
        } else throw new IllegalArgumentException("不支持的类型(" + value.getClass() + ")");
        editor.apply();
    }

    @SuppressWarnings("unchecked")
    private static <T> T get(@NonNull SharedPreferences sp, @NonNull String key, @NonNull T defValue) {
        Object value = null;
        if (defValue instanceof Boolean) {
            value = sp.getBoolean(key, (Boolean) defValue);
        } else if (defValue instanceof Byte) {
            value = (byte) sp.getInt(key, (Byte) defValue);
        } else if (defValue instanceof Character) {
            value = (char) sp.getInt(key, (Character) defValue);
        } else if (defValue instanceof Short) {
            value = (short) sp.getInt(key, (Short) defValue);
        } else if (defValue instanceof Integer) {
            value = sp.getInt(key, (Integer) defValue);
        } else if (defValue instanceof Long) {
            value = sp.getLong(key, (Long) defValue);
        } else if (defValue instanceof Float) {
            value = sp.getFloat(key, (Float) defValue);
        } else if (defValue instanceof Double) {
            final String tmp = sp.getString(key, null);
            if (tmp != null) {
                try {
                    value = Double.parseDouble(tmp);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } else if (defValue instanceof String) {
            value = sp.getString(key, (String) defValue);
        } else if (defValue instanceof Set) {
            value = sp.getStringSet(key, (Set<String>) defValue);
        } else if (defValue.getClass().isEnum()) {
            final String tmp = sp.getString(key, null);
            if (tmp != null) {
                final Object[] enums = defValue.getClass().getEnumConstants();
                if (enums != null) {
                    for (Object e : enums) {
                        if (e instanceof Enum) {
                            if (tmp.equals(((Enum) e).name())) {
                                value = e;
                                break;
                            }
                        }
                    }
                }
            }
        } else throw new IllegalArgumentException("不支持的类型(" + defValue.getClass() + ")");
        return (T) (value == null ? defValue : value);
    }
}
