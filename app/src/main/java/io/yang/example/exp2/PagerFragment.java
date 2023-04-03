package io.yang.example.exp2;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PagerFragment extends Fragment {
    PagerCollectionAdapter mPagerCollectionAdapter;
    ViewPager2 mViewPager2;

    // for tabs:
    private int[] navIcons = {
            R.drawable.icon_home_nor,
            R.drawable.icon_meassage_nor,
            R.drawable.icon_selfinfo_nor,
            R.drawable.icon_square_nor,
            R.drawable.icon_more_nor
    };
    private int[] navIconsSel = {
            R.drawable.icon_home_sel,
            R.drawable.icon_meassage_sel,
            R.drawable.icon_selfinfo_sel,
            R.drawable.icon_square_sel,
            R.drawable.icon_more_sel
    };
    private int[] navLabels = {
            R.string.label_home,
            R.string.label_mesg,
            R.string.label_friends,
            R.string.label_plaza,
            R.string.label_more
    };

    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStates) {
        View v = inflater.inflate(R.layout.fragment_pager, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPagerCollectionAdapter = new PagerCollectionAdapter(this);
        mViewPager2 = view.findViewById(R.id.content_pager);
        mViewPager2.setAdapter(mPagerCollectionAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_bar);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        new TabLayoutMediator(tabLayout, mViewPager2, (tab, position) -> {
            if(position < 5){
                tab.setCustomView(makeTabView(position, false));
            } else {
                tab.setText("Object " + (position + 1));
            }
        }).attach();
        tabLayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int index = tab.getPosition();
                        if(index < 5) {
                            View v = tab.getCustomView();
                            v.setBackgroundResource(R.drawable.home_btn_bg);
                            ImageView icon = v.findViewById(R.id.nav_icon);
                            icon.setImageResource(navIconsSel[index]);
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        int index = tab.getPosition();
                        if(index < 5) {
                            View v = tab.getCustomView();
                            v.setBackgroundResource(R.drawable.maintab_toolbar_bg);
                            ImageView icon = v.findViewById(R.id.nav_icon);
                            icon.setImageResource(navIcons[index]);
                        }
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                }
        );
    }

    private View makeTabView(int index, boolean isSelected) {

        LinearLayout tab = (LinearLayout) LayoutInflater.from(this.getContext()).inflate(R.layout.view_tab, null);
        TextView tab_label = tab.findViewById(R.id.nav_label);
        ImageView tab_icon = tab.findViewById(R.id.nav_icon);

        // set Linear Layout background
        tab.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        tab_icon.setImageResource(navIcons[index]);
        tab_label.setText(navLabels[index]);
        tab_label.setTextColor(getResources().getColor(R.color.white));
        if(index == 0){
            tab.setBackgroundResource(R.drawable.home_btn_bg);
            tab_icon.setImageResource(navIconsSel[index]);
        }

        return tab;
    }
}
