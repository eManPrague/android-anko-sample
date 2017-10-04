package cz.eman.android.sample.anko.sign_in.bl

import cz.eman.android.sample.anko.sign_in.model.AuthCredentials

/**
 * @author eMan s.r.o.
 * @see[ISignInBL]
 */
class SignInBL : ISignInBL {

  override fun checkUserCredentials(credentials: AuthCredentials): Boolean {
    return ("frosty" == credentials.username && "snowman" == credentials.password)
  }
}