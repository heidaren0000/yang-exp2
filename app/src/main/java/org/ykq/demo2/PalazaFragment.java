package org.ykq.demo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class PalazaFragment extends Fragment {
    ImageView mImageView;
    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStates) {
        View v = inflater.inflate(R.layout.fragments_with_image, container, false);
        mImageView = v.findViewById(R.id.image2show);
        mImageView.setImageResource(R.drawable.xianjian04);
        return v;
    }
}
