package com.example.jokernew.data

import com.example.jokernew.model.Joke

interface JokeDayCallback {

    fun onSucess(response : Joke)

    fun onError(response: String)

    fun onComplete()

}





