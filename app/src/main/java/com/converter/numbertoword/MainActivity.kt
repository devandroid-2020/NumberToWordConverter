package com.converter.numbertoword

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.converter.numbertoword.contract.ConverterContract
import com.converter.numbertoword.engine.ConverterPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), ConverterContract.View {

    private var mPresenter: ConverterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mPresenter = ConverterPresenter(this)

        btnConvert.setOnClickListener { convertNumber() }
        imgClear.setOnClickListener { clearText() }
        textChangeListener()
    }

    override fun displayWord(convertedWord: String?) {
        tvConvertedWord.text = convertedWord
    }

    private fun clearText() {
        etEnterNumber.setText("")
        tvConvertedWord.text = ""
    }

    private fun convertNumber() {
        if (!TextUtils.isEmpty(etEnterNumber.text.toString())) {
            mPresenter!!.convertNumberToWord(etEnterNumber.text.toString())

        } else {
            Toast.makeText(
                applicationContext,
                getString(R.string.please_enter_number),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun textChangeListener() {
        etEnterNumber.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (etEnterNumber.text.isNotEmpty()) {
                    imgClear.visibility = View.VISIBLE
                } else {
                    imgClear.visibility = View.GONE
                }
            }
        })
    }
}
