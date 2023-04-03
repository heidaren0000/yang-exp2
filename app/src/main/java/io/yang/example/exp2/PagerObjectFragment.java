package io.yang.example.exp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class PagerObjectFragment extends Fragment {
    public static final String ARG_OBJECT = "object_key";
    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pager_object, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle args = getArguments();
        ((TextView) view.findViewById(R.id.pager_indicate)).setText(Integer.toString(args.getInt(ARG_OBJECT)));
    }
}
