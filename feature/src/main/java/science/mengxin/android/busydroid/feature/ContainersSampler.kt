package science.mengxin.android.busydroid.feature

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_containers_sampler.*

class ContainersSampler : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_containers_sampler)

        pager.adapter = SampleAdapter(supportFragmentManager)
    }

    private inner class SampleAdapter internal constructor(mgr: FragmentManager): FragmentPagerAdapter(mgr) {
        override fun getCount(): Int {
            return (titles.size)
        }

        private val layouts:IntArray
        private val titles:Array<String>

        init{
            layouts = getLayoutsArray(R.array.layouts)
            titles = resources.getStringArray(R.array.titles)
        }
        override fun getItem(position:Int):Fragment {
            return (LayoutFragment.newInstance(layouts[position]))
        }
        override fun getPageTitle(position:Int):CharSequence {
            return (titles[position])
        }
        internal fun getLayoutsArray(arrayResourceId:Int):IntArray {
            val typedArray = resources.obtainTypedArray(arrayResourceId)
            val result = IntArray(typedArray.length())
            for (i in 0 until typedArray.length())
            {
                result[i] = typedArray.getResourceId(i, -1)
            }
            return (result)
        }
    }

     class LayoutFragment: Fragment() {

         override fun onCreateView(
             inflater: LayoutInflater,
             container: ViewGroup?,
             savedInstanceState: Bundle?
         ): View? {
             // return super.onCreateView(inflater.inflate(getArguments().getInt(ARG_LAYOUT), container, false)
             // return super.onCreateView(inflater, container, savedInstanceState)
             return (inflater.inflate(getArguments()?.getInt(ARG_LAYOUT)!!, container, false))
         }


         override fun onViewCreated(@NonNull view:View,
                                    @Nullable savedInstanceState:Bundle?) {
            /*val compassButton = view.findViewById(R.id.compassButton)
            if (compassButton != null)
            {
                compassButton.setOnClickListener({ v->
                    val group = view.findViewById(R.id.directions)
                    if (group.getVisibility() === View.VISIBLE)
                    {
                        group.setVisibility(View.GONE)
                    }
                    else
                    {
                        group.setVisibility(View.VISIBLE)
                    } })
            }*/
        }
        companion object {
            private val ARG_LAYOUT = "layout"
            internal fun newInstance(layoutId:Int):LayoutFragment {
                val result = LayoutFragment()
                val args = Bundle()
                args.putInt(ARG_LAYOUT, layoutId)
                result.setArguments(args)
                return (result)
            }
        }
    }
}
