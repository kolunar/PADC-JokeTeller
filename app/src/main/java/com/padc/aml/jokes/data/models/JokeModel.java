package com.padc.aml.jokes.data.models;

import android.content.Context;

import com.padc.aml.jokes.JokeTellerApp;
import com.padc.aml.jokes.R;
import com.padc.aml.jokes.data.vos.JokeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/26/2016.
 */
public class JokeModel {

    private static JokeModel objInstance;

    private List<JokeVO> jokeList;

    private JokeModel() {
        jokeList = setUpInitialJokes();
    }

    public static JokeModel getInstance() {
        if (objInstance == null) {
            objInstance = new JokeModel();
        }

        return objInstance;
    }

    private List<JokeVO> setUpInitialJokes() {
        Context context = JokeTellerApp.getContext();

        List<JokeVO> jokeList = new ArrayList<>();
        jokeList.add(new JokeVO(context.getString(R.string.joke_one_title), context.getString(R.string.joke_one_content), R.drawable.joke_1));
        jokeList.add(new JokeVO(context.getString(R.string.joke_two_title), context.getString(R.string.joke_two_content), R.drawable.joke_2));
        jokeList.add(new JokeVO(context.getString(R.string.joke_three_title), context.getString(R.string.joke_three_content), R.drawable.joke_3));
        return jokeList;
    }

    public JokeVO getJoke(int index) {
        return jokeList.get(index);
    }
}
