package com.login.menu
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.math.BigDecimal
import java.math.RoundingMode
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

fun inputIsNotEmpty(): Boolean {
    var b = true
    if (editText1.text.toString().trim().isEmpty()) {
        editText1.error = "Enter Number"
        b = false
    }
    if (editText2.text.toString().trim().isEmpty()) {
        editText2.error = "Enter number"
        b = false
    }
    return b
}

fun add(view: View) {
    if (inputIsNotEmpty()) {
        val input1 = editText1.text.toString().trim().toBigDecimal()
        val input2 = editText2.text.toString().trim().toBigDecimal()
        ans.text = "Answer\n ${input1.add(input2)}"
    }

}

fun sub(view: View) {
    if (inputIsNotEmpty()) {
        val input1 = editText1.text.toString().trim().toBigDecimal()
        val input2 = editText2.text.toString().trim().toBigDecimal()
        ans.text = "Answer\n ${input1.subtract(input2)}"
    }
}

fun multiply(view: View) {
    if (inputIsNotEmpty()) {
        val input1 = editText1.text.toString().trim().toBigDecimal()
        val input2 = editText2.text.toString().trim().toBigDecimal()
        ans.text = "Answer\n ${input1.multiply(input2)}"
    }

}

fun divide(view: View) {
    if (inputIsNotEmpty()) {
        val input1 = editText1.text.toString().trim().toBigDecimal()
        val input2 = editText2.text.toString().trim().toBigDecimal()
        if (input2.compareTo(BigDecimal.ZERO) == 0) {
            editText2.error = "Number is Invalid"
        } else {
            ans.text = "Answer\n ${input1.divide(input2)}"
        }
    }
}

fun calculate(view: View) {
    val input1 = editText1.text.toString().trim().toBigDecimal()
    val input2 = editText2.text.toString().trim().toBigDecimal()
    ans.text = input1.add(input2).toString()
}
}
