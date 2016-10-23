package com.atry.oji.colorcardlist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by oji on 16/10/23.
 */
public class ColorInfoAdapter extends ArrayAdapter<Card> {

    private List<Card> cardList = null;

    public ColorInfoAdapter(Context context, int resourceId, List<Card> cardList) {
        super(context, resourceId, cardList);

        this.cardList = cardList;
    }

    @Override
    public int getCount() {
        return cardList.size();
    }

    @Override
    public Card getItem(int position) {
        return cardList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, null);
            viewHolder  = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        final Card CARDINFO = getItem(position);
        if (CARDINFO != null) {
            viewHolder.getColorName().setText(CARDINFO.getColorName());
            viewHolder.getColorImage().setBackgroundColor(Color.parseColor(CARDINFO.getColorCode()));
            final View finalConvertView = convertView;
            finalConvertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), CARDINFO.getColorName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }

    private class ViewHolder {
        private ImageView colorImage = null;
        private TextView  colorName  = null;

        public ViewHolder(View view) {
            colorImage = (ImageView)view.findViewById(R.id.image);
            colorName  = (TextView) view.findViewById(R.id.text);
        }

        public ImageView getColorImage() {
            return this.colorImage;
        }

        public TextView getColorName() {
            return this.colorName;
        }

    }
}
