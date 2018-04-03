package cz.eman.android.sample.anko.notes

import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import cz.eman.android.sample.anko.R
import cz.eman.android.sample.anko.notes.adapter.NotesAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.titleResource
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * UI layout definition for a [NotesFragment]
 *
 * @author eMan s.r.o.
 * @see[AnkoComponent]
 * @see[NotesFragment]
 */
class NotesView(private val notes: MutableList<String>) : AnkoComponent<NotesFragment> {

    private lateinit var ankoContext: AnkoContext<NotesFragment>

    private lateinit var notesAdapter: NotesAdapter

    override fun createView(ui: AnkoContext<NotesFragment>) = with(ui) {
        ankoContext = ui
        notesAdapter = NotesAdapter(notes)

        relativeLayout {
            lparams(width = matchParent, height = matchParent)

            recyclerView {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
                adapter = notesAdapter
            }.lparams(width = matchParent, height = wrapContent) {
                alignParentTop()
            }

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

    fun updateNotes(notes: MutableList<String>) {
        notesAdapter.updateNotes(notes)
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
                            val note = noteEditText.text.toString()
                            if (note.isNotEmpty()) {
                                notesAdapter.addNote(noteEditText.text.toString())
                            } else {
                                toast(R.string.notes_dialog_error_empty_note)
                            }
                        }

                        negativeButton(R.string.notes_dialog_new_note_button_negative)
                    }
                }
            }
        }.show()
    }

}