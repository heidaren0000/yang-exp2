package io.yang.example.exp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MesgFragment extends Fragment {
    ImageView mImageView;
    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStates) {
        View v = inflater.inflate(R.layout.fragments_with_image, container, false);
        mImageView = v.findViewById(R.id.image2show);
        mImageView.setImageResource(R.drawable.xianjian02);
        return v;
    }
}
