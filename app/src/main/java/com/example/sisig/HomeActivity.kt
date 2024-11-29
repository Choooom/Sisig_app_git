package com.example.sisig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sisig.R

class HomeActivity : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var orderSummarySection: View

    companion object {
        fun newInstance(): HomeActivity {
            return HomeActivity().apply {
                // Optional: Set arguments here if needed
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView and set its LayoutManager
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Inflate the order summary section dynamically
        orderSummarySection = LayoutInflater.from(requireContext())
            .inflate(R.layout.order_summary_section, view.findViewById(R.id.parent_layout), false)

        // Add the inflated order summary section above the RecyclerView
        val parentLayout = view.findViewById<LinearLayout>(R.id.parent_layout)
        parentLayout.addView(orderSummarySection, 0) // Adds to the top

        // Set up the adapter with the sample data and handle the "+" button click
        val menuItems = getSampleMenuItems()
        menuAdapter = MenuAdapter(menuItems) { menuItem ->
            // Handle the click event for the "+" button
            Toast.makeText(requireContext(), "Added ${menuItem.name} to cart!", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = menuAdapter
    }

    // Sample data for the menu items
    private fun getSampleMenuItems(): List<MenuItem> {
        return listOf(
            MenuItem("Akin Lang", "(Single serving)", "Meat, Rice, and Egg", 65, R.drawable.menu_akinlang),
            MenuItem("Share Kami", "(Good for 2)", "2 packs, Meat, 2 packs, Rice, and 2 pcs, Egg", 75, R.drawable.menu_sharekami),
            MenuItem("Pang Barkada", "(Good for 3 to 4)", "4 packs, Meat, 4 packs, Rice, and 4 pcs, Egg", 100, R.drawable.menu_pangbarkada),
            MenuItem("Pang Pamilya", "(Good for 5 to 6)", "5 packs, Meat, 5 packs, Rice, and 5 pcs, Egg", 120, R.drawable.menu_pangpamilya)
        )
    }
}



