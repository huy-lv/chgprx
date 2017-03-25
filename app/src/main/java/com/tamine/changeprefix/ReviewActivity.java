package com.tamine.changeprefix;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.tonicartos.superslim.LayoutManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.tamine.changeprefix.Utils.CHANGING_TYPE_1;
import static com.tamine.changeprefix.Utils.CHANGING_TYPE_2;
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
    ArrayList<Changing> changeListIndex;
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
        changeListIndex = new ArrayList<>();
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
                        String number = c.getNumber();
                        if (number != null) {
                            String t1 = "0" + String.valueOf(old_new.get(j).getOldPrefix());
                            String t2 = "(0" + String.valueOf(old_new.get(j).getOldPrefix()) + ")";
                            if (number.startsWith(t1)) {
                                changeListIndex.add(new Changing(i, j, CHANGING_TYPE_1, t1.length()));
                                changeList.add(c);
                            } else if (number.startsWith(t2)) {
                                changeListIndex.add(new Changing(i, j, CHANGING_TYPE_2, t2.length()));
                                changeList.add(c);
                            }

                        }
                    }
//                    Log.e("cxz", "cc " + cha);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                review_pb.setVisibility(View.GONE);
                changeAdapter.redrawList(changeList);
                review_done.setEnabled(true);
                for (Changing c : changeListIndex) {
                    Log.e("cxz", "ccc " + c);
                }
                super.onPostExecute(aVoid);
            }
        }.execute();


    }

    @OnClick(R.id.review_done)
    void done() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("Ban chac chan muon cap nhat danh ba?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (ActivityCompat.checkSelfPermission(ReviewActivity.this, Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                    updateContacts();
                } else {
                    ActivityCompat.requestPermissions(ReviewActivity.this, new String[]{Manifest.permission.WRITE_CONTACTS}, 1);
                }
            }
        });
        b.setNegativeButton("NO", null);
        b.create().show();
    }

    private void updateContacts() {
        for (Changing cc : changeListIndex) {
            Prefix p = old_new.get(cc.indexInPrefix);
            String oldNumber = contacts.get(cc.indexInContacts).getNumber();
            oldNumber = oldNumber.substring(cc.length, oldNumber.length());
            String newNumber;
            if (cc.type == 1) {
                newNumber = "0" + p.getNewPrefix() + oldNumber;
            } else {
                newNumber = "(0" + p.getNewPrefix() + ")" + oldNumber;
            }
            contacts.get(cc.indexInContacts).setNumber(newNumber);
        }

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("Cap nhat thanh cong!");
        b.setPositiveButton("OK", null);
        b.create().show();
    }
}
