package org.pursuit.implicit_intents_app_from_scratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.implicit_intents_app_from_scratch.R;
import org.pursuit.implicit_intents_app_from_scratch.models.Zodiac;
import org.pursuit.implicit_intents_app_from_scratch.view.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {
    private List<Zodiac> zodiacs;

    public ZodiacAdapter(List<Zodiac> zodiacs) {
        this.zodiacs = zodiacs;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zodiac_item_view, viewGroup, false);
        return new ZodiacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int i) {
        zodiacViewHolder.onBind(zodiacs.get(i));
    }

    @Override
    public int getItemCount() {
        return zodiacs.size();
    }
}
