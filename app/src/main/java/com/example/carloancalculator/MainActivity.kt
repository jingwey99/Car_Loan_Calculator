package com.example.carloancalculator

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {

            val carPrice: Int = etCarPrice.text.toString().toInt()
            val downPayment: Int = etDownPayment.text.toString().toInt()
            val loanPeriod: Int = etLoanPeriod.text.toString().toInt()
            val intRate: Double = etIntRate.text.toString().toDouble() / 100

            val carLoan = carPrice - downPayment
            val interest = carLoan * intRate * loanPeriod
            val monthlyRepay = (carLoan + interest) / loanPeriod / 12


            txtCarLoan.visibility = View.VISIBLE
            txtInterest.visibility = View.VISIBLE
            txtMonthlyRepay.visibility = View.VISIBLE

            carLoanDisplay.text = carLoan.toString()
            interestDisplay.text = "%.2f".format(interest)
            monthlyRepayDisplay.text = "%.2f".format(monthlyRepay)

            val inputManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                currentFocus.windowToken,
                InputMethodManager.SHOW_FORCED
            )

        }

        btnClear.setOnClickListener {

            etCarPrice.text.clear()
            etDownPayment.text.clear()
            etIntRate.text.clear()
            etLoanPeriod.text.clear()

            txtCarLoan.visibility = View.INVISIBLE
            txtInterest.visibility = View.INVISIBLE
            txtMonthlyRepay.visibility = View.INVISIBLE

            carLoanDisplay.text = ""
            interestDisplay.text = ""
            monthlyRepayDisplay.text = ""

            etCarPrice.requestFocus()

        }

    }

}
