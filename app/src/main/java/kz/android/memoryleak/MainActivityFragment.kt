package kz.android.memoryleak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_activity_main.*
import kotlin.random.Random

class MainActivityFragment : Fragment() {

    private val adapter =
        MainRecyclerViewAdapter() {
            (activity as MainActivity).replaceFragment()
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        retainInstance = true
        return inflater.inflate(R.layout.fragment_activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Fragment #${hashCode()}"
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        setAdapterData()
    }

    private fun setAdapterData() {
        val size = Random.nextInt(from = 3, until = 10)
        val items = mutableListOf<String>()
        for (i in 0..size) {
            items.add("Item $i")
        }
        adapter.setItems(items)
    }
}