package company.project.demoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import company.project.demoapp.databinding.FragmentCollectionBinding
import company.project.demoapp.databinding.FragmentScanBinding

class CollectionFragment : Fragment() {

    private var _binding: FragmentCollectionBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /* val notificationsViewModel =
                 ViewModelProvider(this).get(NotificationsViewModel::class.java)*/

        _binding = FragmentCollectionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textNotifications
        /* notificationsViewModel.text.observe(viewLifecycleOwner) {
             textView.text = it
         }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}