//package com.tamine.changeprefix;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
///**
// * Created by huylv on 19-Mar-17.
// */
//public class ReviewCell extends SimpleCell<Contact, ReviewCell.ViewHolder> {
//
//    public ReviewCell(Contact item) {
//        super(item);
//    }
//
//    @Override
//    protected int getLayoutRes() {
//        return R.layout.item_review;
//    }
//
//    @NonNull
//    @Override
//    protected ReviewCell.ViewHolder onCreateViewHolder(ViewGroup viewGroup, View view) {
//        return new ViewHolder(view);
//    }
//
//    @Override
//    protected void onBindViewHolder(ReviewCell.ViewHolder viewHolder, int i, Context context, Object o) {
//        viewHolder.review_name.setText(getItem().getName());
//        viewHolder.review_number.setText(getItem().getNumber());
//        viewHolder.review_ignore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }
//
//    @Override
//    protected long getItemId() {
//        return 0;
//    }
//
//    class ViewHolder extends SimpleViewHolder {
//        @BindView(R.id.review_name)
//        TextView review_name;
//        @BindView(R.id.review_number)
//        TextView review_number;
//        @BindView(R.id.review_ignore)
//        Button review_ignore;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//    }
//}