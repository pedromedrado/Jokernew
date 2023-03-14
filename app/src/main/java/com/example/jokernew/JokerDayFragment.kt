package com.example.jokernew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.jokernew.model.Joke
import com.example.jokernew.presenter.JokePresenter
import com.example.jokernew.presenter.JokerDayPresenter
import com.squareup.picasso.Picasso

class JokerDayFragment : Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var presenter: JokerDayPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = JokerDayPresenter(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        return inflater.inflate(R.layout.fragment_joker_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        progressBar = view.findViewById(R.id.progress_jokeDay)
        textView = view.findViewById(R.id.txt_jokeday)
        imageView = view.findViewById(R.id.img_jokeday)


        presenter.findByDay()
    }


    fun showJokeday(joke: Joke) {
        textView.text = joke.text
        Picasso.get().load(joke.iconUrl).into(imageView)
    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    fun showFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}