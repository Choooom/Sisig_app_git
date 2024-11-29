package com.example.sisig

import NewStockDialogFragment
import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class InventoryActivity : Fragment() {

    companion object {
        fun newInstance(): InventoryActivity {
            return InventoryActivity()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inventory, container, false)

        val newStockButton: Button = view.findViewById(R.id.instock_button)
        val setAlertButton: Button = view.findViewById(R.id.set_alert_button)

        newStockButton.setOnClickListener { showNewStockDialog() }

        setAlertButton.setOnClickListener {
            val dialogFragment = SetAlertDialogFragment()
            dialogFragment.show(parentFragmentManager, "SetAlertDialogFragment")
        }

        parentFragmentManager.setFragmentResultListener("stockResult", this) { _, bundle ->
            val productName = bundle.getString("productName")
            val items = bundle.getString("items")
            val category = bundle.getString("category")
            if (productName != null && items != null && category != null) {
                displayNewStock(productName, items, category)
            }
        }

        parentFragmentManager.setFragmentResultListener("alertResult", this) { _, bundle ->
            val productName = bundle.getString("productName")
            val alertAmount = bundle.getString("alertAmt")
            val items = bundle.getString("items")
            if (productName != null && alertAmount != null && items != null) {
                displayAlertStock(productName, alertAmount, items)
            }
        }

        return view
    }

    private fun showNewStockDialog() {
        val dialog = NewStockDialogFragment()
        dialog.show(parentFragmentManager, "NewStockDialog")
    }

    private fun displayNewStock(productName: String, items: String, category: String) {
        val displayLayout: LinearLayout? = view?.findViewById(R.id.display_added_stock)

        displayLayout?.let {
            // Parent container to hold both row and separator
            val parentContainer = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.VERTICAL
            }

            // Create a row layout
            val rowLayout = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.HORIZONTAL
                weightSum = 4f
            }

            // Create and configure TextViews for productName, items, and category
            val productNameTextView = TextView(requireContext()).apply {
                text = productName
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val itemsTextView = TextView(requireContext()).apply {
                text = items
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val categoryTextView = TextView(requireContext()).apply {
                text = category
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            // Create and configure the Edit button (using ImageButton for the icon)
            val editButton = ImageButton(requireContext()).apply {
                setImageResource(R.drawable.icon_edit_inventory_vector) // Set the Edit icon
                background = null // Make the background transparent
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f)
                setOnClickListener {
                    // Open the edit dialog
                    showEditDialog(productNameTextView, itemsTextView, categoryTextView)
                }
            }

            // Create and configure the Delete button (using ImageButton for the icon)
            val deleteButton = ImageButton(requireContext()).apply {
                setImageResource(R.drawable.icon_delete_inventory_vector) // Set the Delete icon
                background = null // Make the background transparent
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f)
                setOnClickListener {
                    // Remove the parent container, which includes the row and separator
                    (parentContainer.parent as? ViewGroup)?.removeView(parentContainer)
                    Toast.makeText(requireContext(), "Stock Deleted", Toast.LENGTH_SHORT).show()
                }
            }

            // Add views to the row layout
            rowLayout.addView(productNameTextView)
            rowLayout.addView(itemsTextView)
            rowLayout.addView(categoryTextView)
            rowLayout.addView(editButton)
            rowLayout.addView(deleteButton)

            // Add the row layout to the parent container
            parentContainer.addView(rowLayout)

            // Add a separator below the row
            val separator = View(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    2 // Height of separator line
                ).apply {
                    setMargins(0, 8, 0, 8)
                }
                setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))
            }
            parentContainer.addView(separator)

            // Add the parent container to the display layout
            it.addView(parentContainer)
        }
    }


    private fun displayAlertStock(productName: String, alertAmount: String, items: String) {
        val displayLayout: LinearLayout? = view?.findViewById(R.id.display_alert_stock)

        displayLayout?.let {
            // Parent container to hold both row and separator
            val parentContainer = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.VERTICAL
            }

            // Create a row layout
            val rowLayout = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.HORIZONTAL
                weightSum = 4f // Adjust weight for dynamic alignment
            }

            // Create and configure TextViews for productName, alertAmount, and items
            val productNameTextView = TextView(requireContext()).apply {
                text = productName
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val alertAmountTextView = TextView(requireContext()).apply {
                text = alertAmount
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val itemsTextView = TextView(requireContext()).apply {
                text = items
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            // Create and configure the Edit button (using ImageButton for the icon)
            val editButton = ImageButton(requireContext()).apply {
                setImageResource(R.drawable.icon_edit_inventory_vector) // Set the icon
                background = null // Make the background transparent
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f)
                setOnClickListener {
                    // Open the edit dialog for the Stock Alert
                    showEditDialog(productNameTextView, alertAmountTextView, itemsTextView, isAlertStock = true)
                }
            }

            // Create and configure the Delete button (using ImageButton for the icon)
            val deleteButton = ImageButton(requireContext()).apply {
                setImageResource(R.drawable.icon_delete_inventory_vector) // Set the icon
                background = null // Make the background transparent
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f)
                setOnClickListener {
                    // Remove the parent container, which includes the row and separator
                    (parentContainer.parent as? ViewGroup)?.removeView(parentContainer)
                    Toast.makeText(requireContext(), "Alert Deleted", Toast.LENGTH_SHORT).show()
                }
            }

            // Add views to the row layout
            rowLayout.addView(productNameTextView)
            rowLayout.addView(alertAmountTextView)
            rowLayout.addView(itemsTextView)
            rowLayout.addView(editButton)
            rowLayout.addView(deleteButton)

            // Add the row layout to the parent container
            parentContainer.addView(rowLayout)

            // Add a separator below the row
            val separator = View(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    2 // Height of separator line
                ).apply {
                    setMargins(0, 8, 0, 8)
                }
                setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))
            }
            parentContainer.addView(separator)

            // Add the parent container to the display layout
            it.addView(parentContainer)
        }
    }



    private fun showEditDialog(productName: TextView, items: TextView, category: TextView, isAlertStock: Boolean = false) {
        // Inflate the appropriate dialog layout based on stock type
        val dialogView = if (isAlertStock) {
            LayoutInflater.from(requireContext()).inflate(R.layout.edit_alert_stock_dialog_layout, null)
        } else {
            LayoutInflater.from(requireContext()).inflate(R.layout.edit_stock_dialog_layout, null)
        }

        val productNameInput = dialogView.findViewById<EditText>(R.id.edit_product_name)
        val itemsInput = dialogView.findViewById<EditText>(R.id.edit_items)

        // If it's alert stock, we need to find the alert amount field as well
        val alertAmountInput = if (isAlertStock) {
            dialogView.findViewById<EditText>(R.id.edit_alert_amount)
        } else {
            null
        }

        // For non-alert stock, the category field will be populated as normal
        val categoryInput = dialogView.findViewById<EditText>(R.id.edit_category) // Make sure you have a category input in your layout

        // Populate the input fields with existing data
        productNameInput.setText(productName.text)
        itemsInput.setText(items.text)

        if (isAlertStock && alertAmountInput != null) {
            alertAmountInput.setText(category.text) // Reusing category as the alert amount in the stock edit view
        } else {
            categoryInput.setText(category.text) // For normal stock, populate category field
        }

        // Create the dialog
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()
        dialogBuilder.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Programmatically create buttons
        val buttonContainer = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 16, 0, 0) // Add some spacing
            }
        }

        // Create and style the Save button
        val saveButton = Button(requireContext()).apply {
            text = "Save"
            setBackgroundResource(R.drawable.rounded_textfield_confrim_btn) // Use your custom drawable
            setTextColor(ContextCompat.getColor(requireContext(), R.color.golden_yellow)) // Ensure the text is visible
            setPadding(24, 0, 24, 0)
            setOnClickListener {
                // Update the TextViews with new values
                productName.text = productNameInput.text.toString()
                items.text = itemsInput.text.toString()

                if (isAlertStock && alertAmountInput != null) {
                    category.text = alertAmountInput.text.toString() // Update alert amount
                } else {
                    category.text = categoryInput.text.toString() // Update category for normal stock
                }

                Toast.makeText(requireContext(), if (isAlertStock) "Alert Stock Updated" else "Stock Updated", Toast.LENGTH_SHORT).show()
                dialogBuilder.dismiss() // Close the dialog
            }
        }

        // Create and style the Cancel button
        val cancelButton = Button(requireContext()).apply {
            text = "Cancel"
            setBackgroundResource(R.drawable.rounded_cancel_btn) // Use your custom drawable
            setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black))
            setPadding(24, 0, 24, 0)
            setOnClickListener {
                dialogBuilder.dismiss() // Close the dialog without saving
            }
        }

        // Add buttons to the container
        buttonContainer.addView(saveButton)
        buttonContainer.addView(cancelButton)

        // Add the button container to the dialog layout
        (dialogView as LinearLayout).addView(buttonContainer)

        // Show the dialog
        dialogBuilder.show()
    }


}








