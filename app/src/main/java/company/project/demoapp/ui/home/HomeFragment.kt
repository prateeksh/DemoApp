package company.project.demoapp.ui.home

import android.R
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.badge.ExperimentalBadgeUtils
import company.project.demoapp.databinding.FragmentHomeBinding
import company.project.demoapp.ui.adapter.CoinsAdapter


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter:CoinsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var mNotify: ImageView
    private lateinit var mMessage: ImageView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.recyclerview
        mNotify = binding.notification
        mMessage = binding.message
        return root
    }

    @ExperimentalBadgeUtils
    @OptIn()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        if (requireContext().isConnectedToNetwork()) {
            Log.e("Fragment", "onViewCreated: network connected")
            homeViewModel.init()
        }else{
            Log.e("Fragment", "onViewCreated: network not connected")
        }

        mNotify.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val badgeDrawable = BadgeDrawable.create(context!!)
                //badgeDrawable.number = 32
                badgeDrawable.backgroundColor = ContextCompat.getColor(requireContext(), R.color.holo_blue_dark)
                badgeDrawable.badgeGravity = BadgeDrawable.TOP_END
                BadgeUtils.attachBadgeDrawable(badgeDrawable, mNotify)
                mNotify.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })

        mMessage.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val badgeDrawable = BadgeDrawable.create(context!!)
                //badgeDrawable.number = 32
                badgeDrawable.backgroundColor = ContextCompat.getColor(requireContext(), R.color.holo_blue_dark)
                badgeDrawable.badgeGravity = BadgeDrawable.TOP_END
                BadgeUtils.attachBadgeDrawable(badgeDrawable, mMessage)
                mMessage.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })


        if (homeViewModel.mCoinsData != null) {
            homeViewModel.mCoinsData!!.observe(viewLifecycleOwner, Observer {
                adapter = CoinsAdapter(homeViewModel.mCoinsData!!.value!!)
               recyclerView.adapter = adapter
               recyclerView.layoutManager =
                    GridLayoutManager(requireContext(),3)

            })
        }else{
            Log.e("Home Fragment", "coins data is null" )
        }
    }

    fun Context.isConnectedToNetwork(): Boolean {
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}