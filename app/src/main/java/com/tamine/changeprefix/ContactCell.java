//package com.tamine.changeprefix;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.jaychang.srv.SimpleCell;
//import com.jaychang.srv.SimpleViewHolder;
//
//import org.jetbrains.annotations.NotNull;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import io.ghyeok.stickyswitch.widget.StickySwitch;
//
///**
// * Created by huylv on 23-Mar-17.
// */
//
//public class ContactCell extends SimpleCell<Contact,ContactCell.ContactVH> {
//
//
//    public ContactCell(Contact item) {
//        super(item);
//    }
//
//    @Override
//    protected int getLayoutRes() {
//        return R.layout.item_contact;
//    }
//
//    @NonNull
//    @Override
//    protected ContactVH onCreateViewHolder(ViewGroup viewGroup, View view) {
//        return new ContactVH(view);
//    }
//
//    @Override
//    protected void onBindViewHolder(ContactVH contactVH, int i, Context context, Object o) {
//        contactVH.item_name.setText(getItem().getName());
//        contactVH.item_number.setText(getItem().getNumber());
//        contactVH.item_sw.;
//        contactVH.item_sw.setOnSelectedChangeListener(new StickySwitch.OnSelectedChangeListener() {
//            @Override
//            public void onSelectedChange(@NotNull StickySwitch.Direction direction) {
////                if(direction==)
//            }
//        });
//    }
//
//    @Override
//    protected long getItemId() {
//        return getItem().getId();
//    }
//
//    class ContactVH extends SimpleViewHolder{
//        @BindView(R.id.item_name)        TextView item_name;
//        @BindView(R.id.item_number) TextView item_number;
//        @BindView(R.id.item_sw)        StickySwitch item_sw;
//        public ContactVH(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this,itemView);
//        }
//    }
//}
