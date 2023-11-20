package app.aec.myappmvvmcleanarchitecturesample.di

import dagger.Module

@Module(subcomponents = [MainComponent::class, AddNotesComponent::class])
class AppSubcomponent