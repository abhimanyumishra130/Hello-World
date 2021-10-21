package com.example.dagger2

import android.util.Log
import javax.inject.Inject

class Bike @Inject constructor(engine: Engine,suspension: Suspension,wheel: Wheel) {

    fun drive(){
        Log.d("abhi","...driving")
    }

}