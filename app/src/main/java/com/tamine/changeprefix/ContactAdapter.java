package com.tamine.changeprefix;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by huylv on 17-Mar-17.
 */

public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    Context c;
    ArrayList<Contact> contactList;

    ContactAdapter(Context context, ArrayList<Contact> cc){
        c = context;
        contactList = cc;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_contact,parent,false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact c = contactList.get(position);
        holder.item_name.setText(c.getName());
        holder.item_number.setText(c.getNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView item_name;
        TextView item_number;

        ContactViewHolder(View itemView) {
            super(itemView);
            item_name = (TextView)itemView.findViewById(R.id.item_name);
            item_number = (TextView)itemView.findViewById(R.id.item_number);
        }

    }
}
