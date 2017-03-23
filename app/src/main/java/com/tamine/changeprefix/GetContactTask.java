package com.tamine.changeprefix;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ProgressBar;

import static com.tamine.changeprefix.Utils.contacts;

/**
 * Created by huylv on 17-Mar-17.
 */

public class GetContactTask extends AsyncTask<Void,Void,Void> {
    Context context;
    ProgressBar pb;

    GetContactTask(Context c, ProgressBar p){
        context = c;
        pb = p;

    }

    @Override
    protected void onPreExecute() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    protected Void doInBackground(Void... params) {
        Cursor cursor = context.getContentResolver().query(   ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,null, null);
        int i=0;
        while (cursor.moveToNext()) {
            String name =cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add(new Contact(name,phoneNumber));
            i++;
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {

        pb.setVisibility(View.INVISIBLE);
    }
}
