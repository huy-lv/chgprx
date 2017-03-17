package com.tamine.changeprefix;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by huylv on 17-Mar-17.
 */

public class Utils {
    public static void createAlertDialog(Context c, String message){
        AlertDialog.Builder b = new AlertDialog.Builder(c);
        b.setMessage(message);
        b.create().show();
    }
}
