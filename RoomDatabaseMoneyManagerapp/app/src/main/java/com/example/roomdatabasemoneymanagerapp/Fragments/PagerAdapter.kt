package com.example.roomdatabasemoneymanagerapp.Fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.roomdatabasemoneymanagerapp.Fragments.Balance_fragement
import com.example.roomdatabasemoneymanagerapp.Fragments.Expense_Fragement
import com.example.roomdatabasemoneymanagerapp.Fragments.Income_Fragement


class PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return Income_Fragement()
            1 -> return Expense_Fragement()
            2 -> return Balance_fragement()
        }
        return Income_Fragement()
    }

    override fun getItemCount(): Int {
        return 3
    }
}