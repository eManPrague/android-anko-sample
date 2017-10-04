package cz.eman.android.sample.anko.sign_in

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cz.eman.android.sample.anko.sign_in.bl.ISignInBL
import cz.eman.android.sample.anko.sign_in.bl.SignInBL
import cz.eman.android.sample.anko.sign_in.model.AuthCredentials
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

/**
 * @author eMan s.r.o.
 * @see[AppCompatActivity]
 */
class SignInActivity : AppCompatActivity() {

  private val signInBL: ISignInBL = SignInBL()
  private lateinit var view: SingInView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    view = SingInView()
    view.setContentView(this)
  }

  fun authorizeUser(username: String, password: String) {
    doAsync {
      val authorized = signInBL.checkUserCredentials(AuthCredentials(username = username, password = password))

      activityUiThread {
        if (authorized) toast("Signed!!!") else view.showAccessDeniedAlertDialog()
      }
    }
  }
}
