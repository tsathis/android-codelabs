package com.github.tharindusathis.roomwordsample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


/***
 * Warning: Don't keep a reference to a context that has a shorter lifecycle than your ViewModel! Examples are:
 *
 * Activity
 * Fragment
 * View
 * Keeping a reference can cause a memory leak, e.g. the ViewModel has a reference to a destroyed Activity!
 * All these objects can be destroyed by the operating system and recreated when there's a configuration change,
 * and this can happen many times during the lifecycle of a ViewModel.
 *
 * If you need the application context (which has a lifecycle that lives as long as the application does),
 * use AndroidViewModel, as shown in this codelab.
 */


public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private final LiveData<List<Word>> mAllWords;

    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() { return mAllWords; }

    public void insert(Word word) { mRepository.insert(word); }
}
