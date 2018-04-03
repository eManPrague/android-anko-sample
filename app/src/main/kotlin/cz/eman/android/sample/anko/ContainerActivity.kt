package cz.eman.android.sample.anko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cz.eman.android.sample.anko.notes.NotesFragment
import org.jetbrains.anko.setContentView

/**
 * @author vsouhrada (vaclav.souhrada@eman.cz)
 * @see[AppCompatActivity]
 */
class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ContainerView().setContentView(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, NotesFragment()).commit()
        }
    }
}