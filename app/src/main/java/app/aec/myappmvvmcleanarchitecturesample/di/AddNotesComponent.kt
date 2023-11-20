package app.aec.myappmvvmcleanarchitecturesample.di

import app.aec.myappmvvmcleanarchitecturesample.addnotes.AddNotesActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface AddNotesComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AddNotesComponent
    }

    fun inject(activity: AddNotesActivity)
}