package cz.eman.android.sample.anko.sign_in

import cz.eman.android.sample.anko.R
import org.jetbrains.anko.*

/**
 * @author eMan s.r.o.
 * @see[AnkoComponent]
 * @see[SignInActivity]
 */
class SingInView : AnkoComponent<SignInActivity> {

    override fun createView(ui: AnkoContext<SignInActivity>) = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = matchParent)

            editText {
                id = R.id.usernameEditText
                hintResource = R.string.sign_in_username
                textSize = 24f

            }.lparams(width = matchParent, height = wrapContent)

            editText {
                id = R.id.passwordEditText
                hintResource = R.string.signIn_password
                textSize = 24f

            }.lparams(width = matchParent, height = wrapContent)

            button {
                id = R.id.signIn_button
                textResource = R.string.signIn_button

            }.lparams(width = matchParent, height = wrapContent)
        }
    }

}