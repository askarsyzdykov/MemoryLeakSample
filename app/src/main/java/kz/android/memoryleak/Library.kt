package kz.android.memoryleak

import android.content.Context

class Library {

    companion object {

        private var context: Context? = null

        fun initLibrary(context: Context) {
            this.context = context
        }
    }
}