package company.project.demoapp.ui.scan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import company.project.demoapp.databinding.FragmentHomeBinding
import company.project.demoapp.databinding.FragmentScanBinding

class ScanFragment : Fragment() {


    // This property is only valid between onCreateView and
    // onDestroyView.
    private var _binding: FragmentScanBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
       /* val notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)*/

        _binding = FragmentScanBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
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