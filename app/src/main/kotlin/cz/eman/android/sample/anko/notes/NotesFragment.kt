package cz.eman.android.sample.anko.notes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext

/**
 * @author vsouhrada (vaclav.souhrada@eman.cz)
 * @see[Fragment]
 */
class NotesFragment : Fragment() {

    private var notes = ArrayList<String>()

    private val view = NotesView(notes)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return view.createView(AnkoContext.Companion.create(inflater.context, this, false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        savedInstanceState?.let {
            notes = savedInstanceState.getStringArrayList(SAVED_ARG_NOTES)
            view.updateNotes(notes)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putStringArrayList(SAVED_ARG_NOTES, notes)
        super.onSaveInstanceState(outState)
    }

    companion object {

        const val SAVED_ARG_NOTES = "notes"
    }

}