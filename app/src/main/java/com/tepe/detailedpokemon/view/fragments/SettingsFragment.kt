package com.tepe.detailedpokemon.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.tepe.detailedpokemon.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        view.findViewById<CardView>(R.id.cvLogout).setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            requireActivity().finish()
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}