package com.example.mapdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by acamara on 6/29/17.
 */

class CustomWindowAdapter implements GoogleMap.InfoWindowAdapter {

    LayoutInflater mInflater;


    public CustomWindowAdapter(LayoutInflater  i) {
        mInflater = i;
    }


    // This defines the contents within the info window based on the marker
    @Override
    public View getInfoContents(Marker marker) {
        // Getting view from the layout file
        View v = mInflater.inflate(R.layout.custom_info_window, null);
        // Populate fields
        TextView title = (TextView) v.findViewById(R.id.tv_info_window_title);
        title.setText(marker.getTitle());

        TextView description = (TextView) v.findViewById(R.id.tv_info_window_description);
        description.setText(marker.getSnippet());

        ImageView ivThumbnail = (ImageView) v.findViewById(R.id.ivThumbnail);
//        String urlImage = imageStringMapMarker.get(marker).toString();
//        Picasso.with(context).load(Uri.parse(urlImage)).resize(250,250).into(ivThumbnail);

        // Return info window contents
        return v;
    }

    // This changes the frame of the info window; returning null uses the default frame.
    // This is just the border and arrow surrounding the contents specified above
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }
}

