package cz.eman.android.sample.anko.sign_in.bl

import cz.eman.android.sample.anko.sign_in.model.AuthCredentials

/**
 * @author eMan s.r.o.
 */
interface ISignInBL {

  fun checkUserCredentials(credentials: AuthCredentials): Boolean

}