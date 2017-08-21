package cz.eman.android.sample.anko

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cz.eman.android.sample.anko.sign_in.SignInActivity

/**
 * @author eMan s.r.o.
 * @see[AppCompatActivity]
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, SignInActivity::class.java))
    }
}
