package com.example.lindy_tummy.Home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lindy_tummy.Home.TabCaptureFragment
import com.example.lindy_tummy.Home.TabQrCodeFragment
import com.example.lindy_tummy.Home.TabScanFragment

class CameraTabsAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCaptureFragment()
            1 -> TabScanFragment()
            2 -> TabQrCodeFragment()
            else -> throw IllegalStateException("Posisi tab tidak valid")
        }
    }
}