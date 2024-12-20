package com.example.contactlist

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ContactAdapter(
    context: Activity,
    private val arrayList: ArrayList<UserData>
) : ArrayAdapter<UserData>(context, R.layout.contact_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Use a recycled view if available, otherwise inflate a new one
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)

        // Find the views in the layout
        val image: ImageView = view.findViewById(R.id.contact_image)
        val name: TextView = view.findViewById(R.id.contact_name)


        // Set the data
        image.setImageResource(arrayList[position].contactProfile)

        return view
    }
}
