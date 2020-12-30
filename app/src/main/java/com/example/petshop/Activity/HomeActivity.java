package com.example.petshop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import com.example.petshop.Adapter.NavigationAdapter;
import com.example.petshop.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hone);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new NavigationAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);


        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("Trang chủ");
                        tab.setIcon(R.drawable.ic_baseline_home_24);

//                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
//                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
//                        badgeDrawable.setVisible(true);

                        break;
                    }
                    case 1: {
                        tab.setText("Danh mục");
                        tab.setIcon(R.drawable.ic_baseline_category_24);

                        break;
                    }
                    case 2: {
                        tab.setText("Tìm kiếm");
                        tab.setIcon(R.drawable.ic_baseline_search_24);
                        break;
                    }
                    case 3: {
                        tab.setText("Tài khoản");
                        tab.setIcon(R.drawable.ic_baseline_account_circle_24);
                        break;
                    }
                }

            }

        }
        );
//        ColorStateList colors;
//        if (Build.VERSION.SDK_INT >= 23) {
//            colors = getResources().getColorStateList(R.color.tab_icon, getTheme());
//        }
//        else {
//            colors = getResources().getColorStateList(R.color.tab_icon);
//        }
//
//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            Drawable icon = tab.getIcon();
//
//            if (icon != null) {
//                icon = DrawableCompat.wrap(icon);
//                DrawableCompat.setTintList(icon, colors);
//            }
//        }
        tabLayoutMediator.attach();

    }
}