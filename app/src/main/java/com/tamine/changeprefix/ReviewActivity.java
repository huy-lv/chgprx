package com.tamine.changeprefix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huylv on 19-Mar-17.
 */
public class ReviewActivity extends AppCompatActivity {
    @BindView(R.id.review_rv)
    RecyclerView review_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);


    }
}
