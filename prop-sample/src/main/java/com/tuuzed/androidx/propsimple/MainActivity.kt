package com.tuuzed.androidx.propsimple

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tuuzed.androidx.prop.prop

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val config = Config(this)
        Log.d(TAG, "================================= defValue ===============================")
        Log.d(TAG, "bool:      ${config.bool.get()}")
        Log.d(TAG, "byte:      ${config.byte.get()}")
        Log.d(TAG, "char:      ${config.char.get()}")
        Log.d(TAG, "short:     ${config.short.get()}")
        Log.d(TAG, "int:       ${config.int.get()}")
        Log.d(TAG, "long:      ${config.long.get()}")
        Log.d(TAG, "float:     ${config.float.get()}")
        Log.d(TAG, "double:    ${config.double.get()}")
        Log.d(TAG, "string:    ${config.string.get()}")
        Log.d(TAG, "stringset: ${config.stringset.get()}")
        Log.d(TAG, "enum       ${config.enum.get()}")
        Log.d(TAG, "==========================================================================")
        config.bool.set(true)
        config.byte.set(Byte.MAX_VALUE)
        config.char.set('A')
        config.short.set(Short.MAX_VALUE)
        config.int.set(Int.MAX_VALUE)
        config.long.set(Long.MAX_VALUE)
        config.float.set(Float.MAX_VALUE)
        config.double.set(Double.MAX_VALUE)
        config.string.set("String")
        config.stringset.set(setOf("A", "Z"))
        config.enum.set(Enum.ENUM_A)
        Log.d(TAG, "================================= Value ===============================")
        Log.d(TAG, "bool:      ${config.bool.get()}")
        Log.d(TAG, "byte:      ${config.byte.get()}")
        Log.d(TAG, "char:      ${config.char.get()}")
        Log.d(TAG, "short:     ${config.short.get()}")
        Log.d(TAG, "int:       ${config.int.get()}")
        Log.d(TAG, "long:      ${config.long.get()}")
        Log.d(TAG, "float:     ${config.float.get()}")
        Log.d(TAG, "double:    ${config.double.get()}")
        Log.d(TAG, "string:    ${config.string.get()}")
        Log.d(TAG, "stringset: ${config.stringset.get()}")
        Log.d(TAG, "enum       ${config.enum.get()}")
        Log.d(TAG, "==========================================================================")
    }


    class Config(ctx: Context) {
        private val sp = ctx.getSharedPreferences(
            "config_${System.currentTimeMillis()}",
            Context.MODE_PRIVATE
        )
        val bool by sp.prop("bool", false)
        val byte by sp.prop("byte", 0x00.toByte())
        val char by sp.prop("char", ' ')
        val short by sp.prop("short", 0.toShort())
        val int by sp.prop("int", 0)
        val long by sp.prop("long", 0L)
        val float by sp.prop("float", 0.0f)
        val double by sp.prop("double", 0.0)
        val string by sp.prop("string by", "")
        val stringset by sp.prop("stringset", emptySet<String>())
        val enum by sp.prop("enum", Enum.ENUM_NONE)
    }

    enum class Enum {
        ENUM_NONE,
        ENUM_A,
        ENUM_B
    }
}
