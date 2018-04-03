package cz.eman.android.sample.anko.sign_in

import cz.eman.android.sample.anko.R
import org.jetbrains.anko.*

/**
 * UI layout definition for [SignInActivity]
 *
 * @author eMan s.r.o.
 * @see[AnkoComponent]
 * @see[SignInActivity]
 */
class SingInView : AnkoComponent<SignInActivity> {

    private lateinit var ankoContext: AnkoContext<SignInActivity>

    override fun createView(ui: AnkoContext<SignInActivity>) = with(ui) {
        ankoContext = ui

        verticalLayout {
            lparams(width = matchParent, height = matchParent)

            val username = editText {
                id = R.id.usernameEditText
                hintResource = R.string.sign_in_username
                textSize = 24f
            }.lparams(width = matchParent, height = wrapContent)

            val password = editText {
                id = R.id.passwordEditText
                hintResource = R.string.signIn_password
                textSize = 24f

            }.lparams(width = matchParent, height = wrapContent)

            button {
                id = R.id.signIn_button
                textResource = R.string.signIn_button

                onClick {
                    handleOnSignInButtonPressed(username = username.text.toString(), password = password.text.toString())
                }

            }.lparams(width = matchParent, height = wrapContent)
        }
    }

    private fun handleOnSignInButtonPressed(username: String, password: String) {
        with(ankoContext) {
            if (username.isBlank() or password.isBlank()) {
                alert(title = R.string.sigIn_alert_invalid_user_title,
                        message = R.string.sigIn_alert_invalid_user_message) {

                    positiveButton(R.string.dialog_button_close) {}
                }.show()
            } else {
                owner.authorizeUser(username, password)
            }
        }
    }

    fun showAccessDeniedAlertDialog() {
        with(ankoContext) {
            alert(title = R.string.sigIn_alert_access_denied_title,
                    message = R.string.sigIn_alert_access_denied_msg) {

                positiveButton(R.string.dialog_button_close) {}
            }.show()
        }
    }

}