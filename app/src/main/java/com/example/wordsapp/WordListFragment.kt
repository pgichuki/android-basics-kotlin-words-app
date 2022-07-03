package com.example.wordsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.WordListFragment.Companion.LETTER
import com.example.wordsapp.databinding.FragmentLetterList2Binding
import com.example.wordsapp.databinding.FragmentWordList2Binding

class WordListFragment : Fragment() {
    companion object{
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private var _binding: FragmentWordList2Binding? = null
    private val binding get() = _binding!!
    private lateinit var letterId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWordList2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Retrieve the LETTER from the Intent extras
        // intent.extras.getString returns String? (String or null)
        // so toString() guarantees that the value will be a String
        //val letterId = activity?.intent?.extras?.getString(LETTER).toString()

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = WordAdapter(letterId, this.requireContext())

        // Adds a [DividerItemDecoration] between items
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        //title = getString(R.string.detail_prefix) + " " + letterId
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}