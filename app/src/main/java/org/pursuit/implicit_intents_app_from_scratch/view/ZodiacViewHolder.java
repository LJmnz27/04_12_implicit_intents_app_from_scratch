package org.pursuit.implicit_intents_app_from_scratch.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.implicit_intents_app_from_scratch.DisplayActivity;
import org.pursuit.implicit_intents_app_from_scratch.R;
import org.pursuit.implicit_intents_app_from_scratch.models.Zodiac;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {
    TextView zodiacNameTextView;
    TextView zodiacDateTextView;


    public ZodiacViewHolder(@NonNull View itemView) {

        super(itemView);
        zodiacNameTextView = itemView.findViewById(R.id.zodiac_sign_text_view);
        zodiacDateTextView = itemView.findViewById(R.id.zodiac_date_text_view);
    }

    public void onBind(final Zodiac zodiac) {
        zodiacNameTextView.setText(zodiac.getName());
        zodiacDateTextView.setText(zodiac.getNumber());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DisplayActivity.class);
                intent.putExtra("name", zodiac.getName());
                intent.putExtra("date", zodiac.getNumber());
                intent.putExtra("image", zodiac.getImage());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
