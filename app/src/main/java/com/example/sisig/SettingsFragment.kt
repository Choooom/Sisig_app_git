package com.example.sisig

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    private lateinit var avatarImage: ImageView
    private lateinit var emailInput: EditText
    private lateinit var usernameInput: EditText
    private lateinit var preferredNameInput: EditText
    private lateinit var saveChangesButton: Button
    private lateinit var changeAvatar: TextView

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    private val PICK_IMAGE_REQUEST = 1000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        // Initialize UI elements
        avatarImage = view.findViewById(R.id.avatarImage)
        emailInput = view.findViewById(R.id.emailInput)
        usernameInput = view.findViewById(R.id.usernameInput)
        preferredNameInput = view.findViewById(R.id.preferredNameInput)
        saveChangesButton = view.findViewById(R.id.saveChangesButton)
        changeAvatar = view.findViewById(R.id.changeAvatar)

        // Set placeholder or default data
        emailInput.setText("") // Set to default email if available
        usernameInput.setText("") // Set to default username if available
        preferredNameInput.setText("") // Set to default name if available

        // Handle Change Avatar click
        changeAvatar.setOnClickListener {
            openImagePicker()
        }

        // Save Changes button click listener
        saveChangesButton.setOnClickListener {
            saveUserDetails()
        }

        return view
    }

    // Opens the image picker
    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    // Saves user details and validates input
    private fun saveUserDetails() {
        val email = emailInput.text.toString().trim()
        val username = usernameInput.text.toString().trim()
        val preferredName = preferredNameInput.text.toString().trim()

        // Clear focus from all EditText fields to hide the cursor
        emailInput.clearFocus()
        usernameInput.clearFocus()
        preferredNameInput.clearFocus()

        // Hide the soft keyboard if it's open
        val inputMethodManager = requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager
        inputMethodManager?.hideSoftInputFromWindow(view?.windowToken, 0)

        // Validate input and proceed with saving
        if (email.isNotEmpty() && username.isNotEmpty() && preferredName.isNotEmpty()) {
            // Handle saving data (e.g., send to backend or database)
            Toast.makeText(requireContext(), "Changes saved", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }



    // Handle result from image picker
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE_REQUEST) {
            val selectedImageUri = data?.data
            if (selectedImageUri != null) {
                avatarImage.setImageURI(selectedImageUri)
            } else {
                Toast.makeText(requireContext(), "Failed to select image", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


