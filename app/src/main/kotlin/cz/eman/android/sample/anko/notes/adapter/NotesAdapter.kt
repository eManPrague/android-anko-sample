package cz.eman.android.sample.anko.notes.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_notes_item.view.*
import org.jetbrains.anko.AnkoContext

/**
 * An adapter which contains list of all available notes.
 *
 * @author vsouhrada (vaclav.souhrada@eman.cz)
 * @see[RecyclerView.Adapter]
 */
class NotesAdapter(private var notes: MutableList<String>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        return NotesViewHolder(NotesItemView().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: NotesViewHolder?, position: Int) {
        holder?.bindItem(notes[position])
    }

    override fun getItemCount() = notes.size

    fun updateNotes(notes: MutableList<String>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    fun addNote(note: String) {
        notes.add(note)
        notifyItemChanged(notes.size - 1)
    }

    /**
     * Describes an item note view about its place within the RecyclerView.
     *
     * @author eMan s.r.o.
     * @see[RecyclerView.ViewHolder]
     */
    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(note: String) {
            itemView.txtNote.text = note
        }

    }
}