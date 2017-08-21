package cz.eman.android.sample.anko.sign_in

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView

/**
 * @author eMan s.r.o.
 * @see[AppCompatActivity]
 */
class SignInActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    SingInView().setContentView(this)
  }
}
