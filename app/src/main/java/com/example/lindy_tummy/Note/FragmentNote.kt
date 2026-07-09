package com.example.lindy_tummy.Note

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lindy_tummy.data.BinaDesaDatabase
import com.example.lindy_tummy.data.entity.BinaDesaNoteEntity
import com.example.lindy_tummy.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch

class FragmentNote : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: NoteAdapter
    private lateinit var db: BinaDesaDatabase
    private val notesList = mutableListOf<BinaDesaNoteEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi DB & Adapter
        db = BinaDesaDatabase.getInstance(requireContext())
        adapter = NoteAdapter(notesList, this)

        // Setup RecyclerView + Garis Pemisah (DividerItemDecoration)
        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.adapter = adapter

        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.rvNotes.addItemDecoration(divider)

        // FAB klik membuka Form Tambah Catatan
        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }

        fetchNotes()
    }

    // Ambil data dari Room pakai Coroutine
    private fun fetchNotes() {
        viewLifecycleOwner.lifecycleScope.launch {
            val data = db.binaDesaNoteDao().getAllNotes()
            notesList.clear()
            notesList.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    // Fungsi hapus data dipanggil dari adapter
    fun deleteNote(note: BinaDesaNoteEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.binaDesaNoteDao().deleteNote(note)
            fetchNotes() // Refresh list setelah hapus
        }
    }

    // Otomatis refresh data saat kembali dari FormActivity
    override fun onResume() {
        super.onResume()
        fetchNotes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}