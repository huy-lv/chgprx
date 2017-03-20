package com.tamine.changeprefix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huylv on 19-Mar-17.
 */
public class ReviewAdapter extends SimpleCell<Contact, ReviewAdapter.ViewHolder> {

    public ReviewAdapter(Contact item) {
        super(item);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_review;
    }

    @NonNull
    @Override
    protected ReviewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(ReviewAdapter.ViewHolder viewHolder, int i, Context context, Object o) {
        viewHolder.review_name.setText(getItem().getName());
        viewHolder.review_number.setText(getItem().getNumber());
        viewHolder.review_ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected long getItemId() {
        return 0;
    }

    class ViewHolder extends SimpleViewHolder {
        @BindView(R.id.review_name)
        TextView review_name;
        @BindView(R.id.review_number)
        TextView review_number;
        @BindView(R.id.review_ignore)
        Button review_ignore;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}