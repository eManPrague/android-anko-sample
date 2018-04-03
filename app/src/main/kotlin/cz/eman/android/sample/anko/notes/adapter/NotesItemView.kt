package cz.eman.android.sample.anko.notes.adapter

import android.support.v4.widget.TextViewCompat
import android.view.ViewGroup
import cz.eman.android.sample.anko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * UI represents a single item contains a note.
 *
 * @author eMan s.r.o.
 * @see[AnkoComponent]
 */
class NotesItemView : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)

            cardView {

                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(10)

                    textView {
                        id = R.id.txtNote
                        TextViewCompat.setTextAppearance(this, R.style.Base_TextAppearance_AppCompat_Medium)
                    }.lparams(width = matchParent, height = wrapContent)
                }

            }.lparams(width = matchParent, height = matchParent) {
                margin = dip(5)
            }

        }
    }

}