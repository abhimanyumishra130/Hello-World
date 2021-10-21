package com.example.dagger2

import dagger.Component


@Component(modules = [BikeModule::class])
interface BIkeComponent {
    fun getBike():Bike
    fun inject(mainActivity: MainActivity)
}