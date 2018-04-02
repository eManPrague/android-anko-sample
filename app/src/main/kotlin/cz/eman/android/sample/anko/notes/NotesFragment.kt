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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return NotesView().createView(AnkoContext.Companion.create(inflater.context, this, false))
    }

}