package io.yang.example.exp2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerCollectionAdapter extends FragmentStateAdapter {
    public PagerCollectionAdapter(Fragment fragment) {
        super(fragment);
    }

    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if(position < 5) {
            switch (position) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new MesgFragment();
                    break;
                case 2:
                    fragment = new FriendsFragment();
                    break;
                case 3:
                    fragment = new PalazaFragment();
                    break;
                case 4:
                    fragment = new MoreFragment();
                    break;
            }
            return fragment;
        }
        // other fragments
        fragment = new PagerObjectFragment();
        Bundle args = new Bundle();

        args.putInt(PagerObjectFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
