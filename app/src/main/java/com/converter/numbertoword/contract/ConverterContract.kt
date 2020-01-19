package com.converter.numbertoword.contract

interface ConverterContract {

    interface View {
        fun displayWord(convertedWord: String?)
    }

    interface Presenter {
        fun convertNumberToWord(numberEntered: String)
        fun getConvertedValue(): String?
        fun isValidNumber(): Boolean
    }
}