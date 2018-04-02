package cz.eman.android.sample.anko

import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout

/**
 * @author vsouhrada (vaclav.souhrada@eman.cz)
 */
class ContainerView : AnkoComponent<ContainerActivity> {

    override fun createView(ui: AnkoContext<ContainerActivity>) = with(ui) {
        frameLayout {
            id = R.id.container
        }
    }

}