package com.ut.mis49m.phonebooklab;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.RecyclerViewHolder> {

    static OnItemClickListener onItemClickListener;

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
        final Contact contact = MainActivity.CONTACTS.get(i);
        viewHolder.name.setText(contact.name);
        viewHolder.phone.setText(contact.phone);
        ((GradientDrawable) viewHolder.circle.getBackground()).setColor(Color.parseColor(contact.color));
    }

    @Override
    public int getItemCount() {
        return MainActivity.CONTACTS.size();
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.onItemClickListener = mItemClickListener;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone;
        View circle;
        LinearLayout holder;

        RecyclerViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            phone = (TextView) itemView.findViewById(R.id.phone);
            circle = itemView.findViewById(R.id.circle);
            holder = (LinearLayout) itemView.findViewById(R.id.holder);

            holder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(itemView, getPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}