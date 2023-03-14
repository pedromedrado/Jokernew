package com.example.jokernew.presenter

import com.example.jokernew.JokerDayFragment
import com.example.jokernew.data.JokeCallback
import com.example.jokernew.data.JokeDayCallback
import com.example.jokernew.data.JokeRemoteDataSource
import com.example.jokernew.data.JokerDayRemoteDataSource
import com.example.jokernew.model.Joke
import com.example.jokernew.view.JokeFragment

class JokerDayPresenter(
    private val view: JokerDayFragment,
    private val dataSource: JokerDayRemoteDataSource = JokerDayRemoteDataSource()
) : JokeDayCallback {

    fun findByDay() {
        view.showProgress()
        dataSource.findRandom(this)
    }


    override fun onSucess(response: Joke) {
        view.showJokeday(response)

    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}