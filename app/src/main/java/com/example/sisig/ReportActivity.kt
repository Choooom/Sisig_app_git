package com.example.sisig

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.sisig.data.AppDatabase
import kotlinx.coroutines.launch
import java.util.*

class ReportActivity : Fragment() {
    private lateinit var db: AppDatabase
    private lateinit var dailySalesTextView: TextView
    private lateinit var monthlySalesTextView: TextView
    private lateinit var yearlySalesTextView: TextView

    companion object {
        fun newInstance(): ReportActivity {
            return ReportActivity()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_report, container, false)

        // Initialize views
        dailySalesTextView = view.findViewById(R.id.daily_sales_amount)
        monthlySalesTextView = view.findViewById(R.id.monthly_sales_amount)
        yearlySalesTextView = view.findViewById(R.id.yearly_sales_amount)

        db = AppDatabase.getInstance(requireContext())

        val generateReportButton = view.findViewById<Button>(R.id.generateReportButton)
        generateReportButton.setOnClickListener {
            showDatePicker()
        }

        return view
    }

    private fun generateReport(year: Int, month: Int, day: Int) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.allOrderDao.getAllOrders().collect { orders ->
                // Filter orders by date
                val dailyOrders = orders.filter { order ->
                    // Add date filtering logic here
                    true // Currently showing all orders
                }
                val monthlyOrders = orders.filter { order ->
                    // Add month filtering logic here
                    true // Currently showing all orders
                }
                val yearlyOrders = orders.filter { order ->
                    // Add year filtering logic here
                    true // Currently showing all orders
                }

                val dailyTotal = dailyOrders.sumOf { it.totalAmount }
                val monthlyTotal = monthlyOrders.sumOf { it.totalAmount }
                val yearlyTotal = yearlyOrders.sumOf { it.totalAmount }

                dailySalesTextView.text = String.format("₱%.2f", dailyTotal)
                monthlySalesTextView.text = String.format("₱%.2f", monthlyTotal)
                yearlySalesTextView.text = String.format("₱%.2f", yearlyTotal)
            }
        }
    }


    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                generateReport(year, month + 1, day)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

}
