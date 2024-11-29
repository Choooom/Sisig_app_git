package com.example.sisig

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

class ReportActivity : Fragment() {

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

        // Find the Generate Report button
        val generateReportButton = view.findViewById<Button>(R.id.generateReportButton)

        // Set up click listener
        generateReportButton.setOnClickListener {
            showDatePicker()
        }

        return view
    }

    private fun showDatePicker() {
        // Get the current date
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Create and show the DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                // Handle the selected date (month is 0-indexed)
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                Toast.makeText(requireContext(), "Selected Date: $selectedDate", Toast.LENGTH_SHORT).show()

                // TODO: Generate your report here using the selected date
            },
            year, month, day
        )
        datePickerDialog.show()
    }
}
