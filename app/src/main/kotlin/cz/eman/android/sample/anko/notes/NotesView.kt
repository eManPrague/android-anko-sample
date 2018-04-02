package cz.eman.android.sample.anko.notes

import android.support.v4.content.ContextCompat
import android.text.InputType
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import cz.eman.android.sample.anko.MainActivity
import cz.eman.android.sample.anko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.titleResource
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.floatingActionButton

/**
 * UI layout definition for a [MainActivity]
 *
 * @author eMan s.r.o.
 * @see[AnkoComponent]
 * @see[MainActivity]
 */
class NotesView : AnkoComponent<NotesFragment> {

    private lateinit var ankoContext: AnkoContext<NotesFragment>

    override fun createView(ui: AnkoContext<NotesFragment>) = with(ui) {
        ankoContext = ui
        relativeLayout {
            lparams(width = matchParent, height = matchParent)

            floatingActionButton {
                imageResource = android.R.drawable.ic_input_add
                onClick {
                    showAddNewNoteDialog()
                }
            }.lparams {
                gravity = Gravity.BOTTOM or Gravity.END
                margin = dip(10)
                alignParentBottom()
                alignParentEnd()
                alignParentRight()
            }
        }
    }

    private fun showAddNewNoteDialog() {
        with(ankoContext) {
            alert {
                customView {
                    verticalLayout {
                        lparams(width = matchParent, height = matchParent)

                        toolbar {
                            titleResource = R.string.notes_dialog_new_note_title
                            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                            setTitleTextColor(ContextCompat.getColor(ctx, android.R.color.white))
                        }

                        val noteEditText = editText {
                            hintResource = R.string.notes_dialog_new_note_hint
                        }.lparams(width = matchParent, height = wrapContent) {
                            topMargin = dip(15)
                            bottomMargin = dip(15)
                            leftMargin = dip(20)
                            rightMargin = dip(20)
                        }

                        positiveButton(R.string.notes_dialog_new_note_button_positive) {

                        }

                        negativeButton(R.string.notes_dialog_new_note_button_negative)
                    }
                }
            }
        }.show()
    }

}