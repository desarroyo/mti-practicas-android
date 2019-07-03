package com.desarroyo.practica6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.desarroyo.practicas.R
import kotlinx.android.synthetic.main.card_contact.view.*

class ContactAdapter(val context: Context, val listContacts: ArrayList<Contact>) : RecyclerView.Adapter<ContactAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.card_contact, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listContacts.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(position, listContacts[position])
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setData(pos: Int, current: Contact){

            itemView.txtUserId.text = current.userId
            itemView.txtJobTitleName.text = current.jobTitleName
            itemView.txtFirstName.text = current.firstName
            itemView.txtLastName.text = current.lastName
            itemView.txtPreferredFullName.text = current.preferredFullName
            itemView.txtEmployeeCode.text = current.employeeCode
            itemView.txtRegion.text = current.region
            itemView.txtPhoneNumber.text = current.phoneNumber
            itemView.txtEmailAddress.text = current.emailAddress

            itemView.setOnClickListener {
                Toast.makeText(context, "Posición: " + pos, Toast.LENGTH_SHORT).show()
            }

        }

    }

}