package com.converter.numbertoword.engine

import androidx.annotation.NonNull
import com.converter.numbertoword.contract.ConverterContract
import java.math.BigDecimal
import kotlin.math.floor

class ConverterPresenter(var view: ConverterContract.View?) : ConverterContract.Presenter {

    private var convertedValue: String? = ""
    private var isValidNumber = false

    /**
     * This will execute for number to word conversion
     */
    override fun convertNumberToWord(numberEntered: String) {
        try {
            //String converted into BigDecimal format
            val bigDecimalConvert = BigDecimal(numberEntered)

            var number = bigDecimalConvert.toLong()
            var no = bigDecimalConvert.toLong()
            val size = no.toString().length
            var i = 0
            val str = arrayListOf<String>()
            val words: HashMap<Int, String> = HashMap()

            words[0] = ""
            words[1] = "One"
            words[2] = "Two"
            words[3] = "Three"
            words[4] = "Four"
            words[5] = "Five"
            words[6] = "Six"
            words[7] = "Seven"
            words[8] = "Eight"
            words[9] = "Nine"
            words[10] = "Ten"
            words[11] = "Eleven"
            words[12] = "Twelve"
            words[13] = "Thirteen"
            words[14] = "Fourteen"
            words[15] = "Fifteen"
            words[16] = "Sixteen"
            words[17] = "Seventeen"
            words[18] = "Eighteen"
            words[19] = "Nineteen"
            words[20] = "Twenty"
            words[30] = "Thirty"
            words[40] = "Forty"
            words[50] = "Fifty"
            words[60] = "Sixty"
            words[70] = "Seventy"
            words[80] = "Eighty"
            words[90] = "Ninety"

            val digits = arrayOf("", "Hundred", "Thousand", "Lakh")

            //Iterate loop 1 to 6 times (depends on number length)
            while (i < size) {

                val divider = if ((i == 2)) 10 else 100
                number = no % divider
                no /= divider
                i += if (divider == 10) 1 else 2

                if (number > 0) {
                    val counter = str.size
                    val plural = if ((counter > 0 && number > 9)) "s" else ""
                    val tmp =
                        if ((number < 21))
                            words[Integer.valueOf(number.toInt())] + " " + digits[counter] + plural
                        else words[Integer.valueOf(
                            floor(
                                (number / 10).toDouble()
                            ).toInt() * 10
                        )] + " " + words[Integer.valueOf((number % 10).toInt())] + " " + digits[counter] + plural
                    str.add(tmp)

                } else {
                    str.add("")
                }
            }

            str.reverse()

            convertedValue = join(" ", str).trim()
            isValidNumber = true
            view?.displayWord(convertedValue)

        } catch (e: Exception) {
            isValidNumber = false
        }
    }

    private fun join(@NonNull delimiter: CharSequence, @NonNull tokens: Iterable<*>): String {
        val it = tokens.iterator()
        if (!it.hasNext()) {
            return ""
        }
        val sb = StringBuilder()
        sb.append(it.next())
        while (it.hasNext()) {
            sb.append(delimiter)
            sb.append(it.next())
        }
        return sb.toString()
    }

    override fun getConvertedValue(): String? {
        return convertedValue
    }

    override fun isValidNumber(): Boolean {
        return isValidNumber
    }
}