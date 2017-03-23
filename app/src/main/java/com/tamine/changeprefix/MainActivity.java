package com.tamine.changeprefix;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;

import static com.tamine.changeprefix.Utils.contacts;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.contact_rv)  RecyclerView contact_rv;
    @BindView(R.id.contact_rv_scroller)    VerticalRecyclerViewFastScroller contact_rv_scroller;
    @BindView(R.id.contact_pb)    ProgressBar contact_pb;
    ContactAdapter contactAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        contactAdapter = new ContactAdapter(this,contacts);
        contact_rv.setLayoutManager(new LinearLayoutManager(this));
        contact_rv.setAdapter(contactAdapter);

        contact_rv_scroller.setRecyclerView(contact_rv);
        contact_rv.setOnScrollListener(contact_rv_scroller.getOnScrollListener());

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)== PackageManager.PERMISSION_GRANTED) {
            getContacts();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }
    }

    @OnClick(R.id.btScan)
    void scan(){
        startActivity(new Intent(MainActivity.this,ReviewActivity.class));
    }

    void getContacts(){
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                contact_pb.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Void... params) {
                Cursor cursor = getContentResolver().query(   ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,null, null);
                while (cursor.moveToNext()) {
                    String name =cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    contacts.add(new Contact(name,phoneNumber));
                }
                cursor.close();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                contact_pb.setVisibility(View.GONE);
            }
        }.execute();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if(requestCode==1){
            if(grantResults.length > 0){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    getContacts();
                }
            }
        }
    }
}
