package com.tamine.changeprefix;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.tonicartos.superslim.LayoutManager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.tamine.changeprefix.Utils.contacts;
import static com.tamine.changeprefix.Utils.old_new;

/**
 * Created by huylv on 19-Mar-17.
 */
public class ReviewActivity extends AppCompatActivity {
    @BindView(R.id.review_rv)
    RecyclerView review_rv;
    @BindView(R.id.review_pb)
    ProgressBar review_pb;
    HashMap<Integer, Integer> changeListIndex;
    @BindView(R.id.review_done)
    Button review_done;
    ArrayList<Contact> changeList;
    ContactAdapter changeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);

        changeList = new ArrayList<>();
        changeListIndex = new HashMap<>();
        changeAdapter = new ContactAdapter(this, changeList);
        review_rv.setLayoutManager(new LayoutManager(this));
        review_rv.setAdapter(changeAdapter);


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                review_pb.setVisibility(View.VISIBLE);
                review_done.setEnabled(false);
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... params) {
                for (int i = 0; i < contacts.size(); i++) {
                    Contact c = contacts.get(i);
                    for (int j = 0; j < old_new.size(); j++) {
                        if (c.getNumber() != null) {
                            if (c.getNumber().startsWith("0" + String.valueOf(old_new.get(j).getOldPrefix()))) {
                                changeListIndex.put(i, j);
                                changeList.add(c);
                            }
                        }
                    }
                    Log.e("cxz", "cc " + c.getNumber());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                review_pb.setVisibility(View.GONE);
                changeAdapter.redrawList(changeList);
                review_done.setEnabled(true);
                super.onPostExecute(aVoid);
            }
        }.execute();


    }

    @OnClick(R.id.review_done)
    void done() {

    }
}
