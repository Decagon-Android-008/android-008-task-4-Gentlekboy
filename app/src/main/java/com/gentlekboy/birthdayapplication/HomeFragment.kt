package com.gentlekboy.birthdayapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val birthdayList = arrayListOf(
            Birthdays("Ola Machiavelli", R.drawable.person_1, R.drawable.bar_1),
            Birthdays("Samuel Garfield", R.drawable.person_2, R.drawable.bar_2),
            Birthdays("Kome Holmes", R.drawable.person_3, R.drawable.bar_3),
            Birthdays("Ola Machiavelli", R.drawable.person_1, R.drawable.bar_1),
            Birthdays("Samuel Garfield", R.drawable.person_2, R.drawable.bar_2),
            Birthdays("Kome Holmes", R.drawable.person_3, R.drawable.bar_3),
            Birthdays("Ola Machiavelli", R.drawable.person_1, R.drawable.bar_1),
            Birthdays("Samuel Garfield", R.drawable.person_2, R.drawable.bar_2),
            Birthdays("Kome Holmes", R.drawable.person_3, R.drawable.bar_3),
            Birthdays("Omolade Rogers", R.drawable.person_4, R.drawable.bar_4)
        )

        val birthdayAdapter = BirthdayAdapter(birthdayList)
        val recyclerViewContainer = view.findViewById<RecyclerView>(R.id.recyclerViewContainer)
        recyclerViewContainer.adapter = birthdayAdapter
        recyclerViewContainer.layoutManager = LinearLayoutManager(requireContext())
        birthdayAdapter.notifyDataSetChanged()

        val imageList = arrayListOf(
            Images(R.drawable.slider_1),
            Images(R.drawable.slider_1),
            Images(R.drawable.slider_1),
            Images(R.drawable.slider_1),
            Images(R.drawable.slider_1)
        )

        val viewpagerAdapter = ViewpagerAdapter(imageList)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter = viewpagerAdapter

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.setPadding(-9, 0, 99, 0)

        val compoTrans = CompositePageTransformer()
        compoTrans.addTransformer { page, position ->
            val r: Float = 1 - kotlin.math.abs(position)
            page.translationX = 60f
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPager2.setPageTransformer(compoTrans)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}