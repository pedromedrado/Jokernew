package com.example.jokernew.presenter

import android.graphics.Color
import com.example.jokernew.Category
import com.example.jokernew.data.CategoryRemoteDataSource
import com.example.jokernew.data.ListCategoryCallback
import com.example.jokernew.view.HomeFragment


class HomePresent(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource
) : ListCategoryCallback {


    // A camada de View tem que ter uma conexão com camada de Present
    //E PRESENTER TEM QUE TER UMA CONEXÃO COM VIEW

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategory(this)
    }


    override fun onSucess(response: List<String>) {

        val start = 40
        val end = 190
        val diff = (end - start) / response.size


        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                (diff * index).toFloat(),  // H matiz
                100.0f, //S Saturação
                100.0f // V Valor
            )
            Category(s, Color.HSVToColor(hsv).toLong())

        }

        view.showCategories(categories)
    }

    override fun onComplete() {
        view.hideProgress()
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

//SIMULAR UMA REQUISIÇÃO HTTP


    class CategoryItem(Category: Any?) {

    }

}