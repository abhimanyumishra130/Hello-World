package com.example.dagger2

import dagger.Module
import dagger.Provides


@Module
class BikeModule {

    @Provides
    fun getWheel():Wheel{
        return Wheel()
    }

    @Provides
    fun getSuspension():Suspension{
        return Suspension()
    }

    @Provides
    fun getEngine():Engine{
        return Engine()
    }

    @Provides
    fun getBike(engine: Engine,suspension: Suspension,wheel: Wheel):Bike{
        return Bike(engine,suspension,wheel)
    }
}