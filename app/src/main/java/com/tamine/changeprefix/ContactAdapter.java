package com.tamine.changeprefix;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tonicartos.superslim.GridSLM;
import com.tonicartos.superslim.LinearSLM;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ghyeok.stickyswitch.widget.StickySwitch;

/**
 * Created by huylv on 23-Mar-17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private static final int VIEW_TYPE_HEADER = 0x01;
    private static final int VIEW_TYPE_CONTENT = 0x00;
    private static final int LINEAR = 0;
    ArrayList<Contact> contactList;
    Context context;
    private int mHeaderDisplay;
    private boolean mMarginsFixed;

    ContactAdapter(Context c, ArrayList<Contact> cc, int headermode) {
        context = c;
        contactList = cc;
        mHeaderDisplay = headermode;
        mMarginsFixed = true;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_header, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_contact, parent, false);
        }
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, final int position) {
        final Contact item = contactList.get(position);
        holder.item_name.setText(item.getName());


        View itemView = holder.itemView;
        GridSLM.LayoutParams lp = GridSLM.LayoutParams.from(itemView.getLayoutParams());
        if (item.isHeader) {
//            lp.headerDisplay = 40;
            if (lp.isHeaderInline() || (mMarginsFixed && !lp.isHeaderOverlay())) {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            } else {
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            }

            lp.headerEndMarginIsAuto = !mMarginsFixed;
            lp.headerStartMarginIsAuto = !mMarginsFixed;
        } else {
            holder.item_number.setText(item.getNumber());
            holder.item_sw.setDirection(item.change ? StickySwitch.Direction.LEFT : StickySwitch.Direction.RIGHT);
            holder.item_sw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.item_sw.setDirection(holder.item_sw.getDirection() == StickySwitch.Direction.LEFT ? StickySwitch.Direction.RIGHT : StickySwitch.Direction.LEFT);
                    item.change = !item.change;
                }
            });
        }

//        lp.setSlm(item.sectionManager == LINEAR ? LinearSLM.ID : GridSLM.ID);
        lp.setSlm(LinearSLM.ID);
        lp.setColumnWidth(context.getResources().getDimensionPixelSize(R.dimen.grid_column_width));
        lp.setFirstPosition(item.sectionFirstPosition);
        itemView.setLayoutParams(lp);

    }

    @Override
    public int getItemViewType(int position) {
        return contactList.get(position).isHeader ?
                VIEW_TYPE_HEADER : VIEW_TYPE_CONTENT;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


    class ContactViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_name)
        TextView item_name;
        @Nullable
        @BindView(R.id.item_number)
        TextView item_number;
        @Nullable
        @BindView(R.id.item_sw)
        StickySwitch item_sw;

        ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
