package com.tamine.changeprefix;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

/**
 * Created by huylv on 17-Mar-17.
 */

public class Utils {

    public static ArrayList<Contact> contacts = new ArrayList<>();
    public static ArrayList<Prefix> old_new = new ArrayList<>();
    public static int CHANGING_TYPE_1 = 1;
    public static int CHANGING_TYPE_2 = 2;

    static {
        old_new.add(new Prefix("Sơn La", 22, 212));
        old_new.add(new Prefix("Lai Châu", 231, 213));
        old_new.add(new Prefix("Lào Cai", 20, 214));
        old_new.add(new Prefix("Điện Biên", 230, 215));
        old_new.add(new Prefix("Yên Bái", 29, 216));
        old_new.add(new Prefix("Quảng Bình", 52, 232));
        old_new.add(new Prefix("Quảng Trị", 53, 233));
        old_new.add(new Prefix("Thừa Thiên - Huế", 54, 234));
        old_new.add(new Prefix("Quảng Nam", 510, 235));
        old_new.add(new Prefix("Đà Nẵng", 511, 236));
        old_new.add(new Prefix("Thanh Hoá", 37, 237));
        old_new.add(new Prefix("Nghệ An", 38, 238));
        old_new.add(new Prefix("Hà Tĩnh", 39, 239));
        old_new.add(new Prefix("Quảng Ninh", 33, 203));
        old_new.add(new Prefix("Bắc Giang", 240, 204));
        old_new.add(new Prefix("Lạng Sơn", 25, 205));
        old_new.add(new Prefix("Cao Bằng", 26, 206));
        old_new.add(new Prefix("Tuyên Quang", 27, 207));
        old_new.add(new Prefix("Thái Nguyên", 280, 208));
        old_new.add(new Prefix("Bắc Cạn", 281, 209));
        old_new.add(new Prefix("Hải Dương", 320, 220));
        old_new.add(new Prefix("Hưng Yên", 321, 221));
        old_new.add(new Prefix("Bắc Ninh", 241, 222));
        old_new.add(new Prefix("Hải Phòng", 31, 225));
        old_new.add(new Prefix("Hà Nam", 351, 226));
        old_new.add(new Prefix("Thái Bình", 36, 227));
        old_new.add(new Prefix("Nam Định", 350, 228));
        old_new.add(new Prefix("Ninh Bình", 30, 229));
        old_new.add(new Prefix("Cà Mau", 780, 290));
        old_new.add(new Prefix("Bạc Liêu", 781, 291));
        old_new.add(new Prefix("Cần Thơ", 710, 292));
        old_new.add(new Prefix("Hậu Giang", 711, 293));
        old_new.add(new Prefix("Trà Vinh", 74, 294));
        old_new.add(new Prefix("An Giang", 76, 296));
        old_new.add(new Prefix("Kiên Giang", 77, 297));
        old_new.add(new Prefix("Sóc Trăng", 79, 299));
        old_new.add(new Prefix("Hà Nội", 4, 24));
        old_new.add(new Prefix("Hồ Chí Minh", 8, 28));
        old_new.add(new Prefix("Đồng Nai", 61, 251));
        old_new.add(new Prefix("Bình Thuận", 62, 252));
        old_new.add(new Prefix("Bà Rịa - Vũng Tàu", 64, 254));
        old_new.add(new Prefix("Quảng Ngãi", 55, 255));
        old_new.add(new Prefix("Bình Định", 56, 256));
        old_new.add(new Prefix("Phú Yên", 57, 257));
        old_new.add(new Prefix("Khánh Hoà", 58, 258));
        old_new.add(new Prefix("Ninh Thuận", 68, 259));
        old_new.add(new Prefix("Kon Tum", 60, 260));
        old_new.add(new Prefix("Đắk Nông", 501, 261));
        old_new.add(new Prefix("Đắk Lắk", 500, 262));
        old_new.add(new Prefix("Lâm Đồng", 63, 263));
        old_new.add(new Prefix("Gia Lai", 59, 269));
        old_new.add(new Prefix("Vĩnh Long", 70, 270));
        old_new.add(new Prefix("Bình Phước", 651, 271));
        old_new.add(new Prefix("Long An", 72, 272));
        old_new.add(new Prefix("Tiền Giang", 73, 273));
        old_new.add(new Prefix("Bình Dương", 650, 274));
        old_new.add(new Prefix("Bến Tre", 75, 275));
        old_new.add(new Prefix("Tây Ninh", 66, 276));
        old_new.add(new Prefix("Đồng Tháp", 67, 277));

    }


    public static void createAlertDialog(Context c, String message){
        AlertDialog.Builder b = new AlertDialog.Builder(c);
        b.setMessage(message);
        b.create().show();
    }
}
