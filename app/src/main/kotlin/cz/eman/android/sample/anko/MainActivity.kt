package cz.eman.android.sample.anko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cz.eman.android.sample.anko.sign_in.SignInActivity
import org.jetbrains.anko.intentFor

/**
 * @author eMan s.r.o.
 * @see[AppCompatActivity]
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(intentFor<SignInActivity>())

        finish()
    }
}
