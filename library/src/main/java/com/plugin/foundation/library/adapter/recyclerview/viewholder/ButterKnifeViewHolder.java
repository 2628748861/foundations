package com.plugin.foundation.library.adapter.recyclerview.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public class ButterKnifeViewHolder extends RecyclerView.ViewHolder {

    public ButterKnifeViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
