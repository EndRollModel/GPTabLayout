package com.endrollmodel.gpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.endrollmodel.gptablayout.GPTabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gpTab = findViewById<GPTabLayout>(R.id.gptab)
        val vp = findViewById<ViewPager2>(R.id.vp2)
        vp.adapter = FragmentAdapter(this)

        // use viewpager2
        gpTab.setData(vp) { index, view ->
            view.text = index.toString()
        }
    }
    internal class FragmentAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> FragmentA()
                1 -> FragmentB()
                2 -> FragmentC()
                else -> FragmentA()
            }
        }

        override fun getItemCount(): Int {
            return 3
        }
    }

    class FragmentA : Fragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val view: View = inflater.inflate(R.layout.fragment_blank, container, false)
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.colorTodoBlue, null))
            tv.text = "A"
            return view
        }
    }

    class FragmentB : Fragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val view: View = inflater.inflate(R.layout.fragment_blank, container, false)
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.colorTodoRed, null))
            tv.text = "B"
            return view
        }
    }

    class FragmentC : Fragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val view: View = inflater.inflate(R.layout.fragment_blank, container, false)
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.setBackgroundColor(
                ResourcesCompat.getColor(
                    resources,
                    R.color.colorTodoYellow,
                    null
                )
            )
            tv.text = "C"
            return view
        }
    }
}