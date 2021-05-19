package com.segun.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Flowable.just("sweet","sour","salty","tangy")
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.mainThread())
            .subscribe(
                {value -> println("Recieved: $value")},
                { error -> println("Error: $error")},
                { println("Completed")}
            ).dispose()
    }
}
