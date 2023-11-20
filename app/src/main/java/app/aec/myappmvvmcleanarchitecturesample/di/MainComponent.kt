package app.aec.myappmvvmcleanarchitecturesample.di

import app.aec.myappmvvmcleanarchitecturesample.displaynotes.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
}