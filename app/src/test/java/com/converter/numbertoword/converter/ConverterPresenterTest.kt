package com.converter.numbertoword.converter

import com.converter.numbertoword.contract.ConverterContract
import com.converter.numbertoword.engine.ConverterPresenter
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ConverterPresenterTest {

    private lateinit var contractPresenter: ConverterPresenter
    private val view: ConverterContract.View = mock()
    private val word: String = "Ten"
    private var words: HashMap<Int, String> = HashMap()

    @Before
    fun setUp() {
        this.contractPresenter = ConverterPresenter(view)
        this.contractPresenter.convertNumberToWord("10")
        words = mock()
    }

    @Test
    fun testConvertNumberToWordSuccess() {
        contractPresenter.convertNumberToWord("10")
        assertTrue(contractPresenter.isValidNumber())
        assertEquals(contractPresenter.getConvertedValue(), word)
    }

    @Test
    fun testConvertNumberToWordFail() {
        contractPresenter.convertNumberToWord("")
        assertFalse(contractPresenter.isValidNumber())
    }
}
