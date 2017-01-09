package com.ags.safemoney.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ags.safemoney.R;
import com.ags.safemoney.activities.fragment.ListaFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MeuAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
    }

    public static class MeuAdapter extends FragmentPagerAdapter {
        private static int NUM_ITENS = 4;

        public MeuAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITENS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return ListaFragment.newInstance(0, "PAGINA #1");
                case 1:
                    return ListaFragment.newInstance(1, "PAGINA #2");
                case 2:
                    return ListaFragment.newInstance(2, "PAGINA #3");
                case 3:
                    return ListaFragment.newInstance(3, "PAGINA #4");
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "PAGINA " + position;
        }
    }
}
