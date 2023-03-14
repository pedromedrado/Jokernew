package com.example.jokernew.presenter

import com.example.jokernew.data.CategoryRemoteDataSource
import com.example.jokernew.data.JokeCallback
import com.example.jokernew.data.JokeRemoteDataSource
import com.example.jokernew.model.Joke
import com.example.jokernew.view.HomeFragment
import com.example.jokernew.view.JokeFragment

class JokePresenter (
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback{

    fun findBy(categoryName: String){
        view.showProgress()
        dataSource.findBy(categoryName,this)
    }

    override fun onSucess(response: Joke) {
    view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}
