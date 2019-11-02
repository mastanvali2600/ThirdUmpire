package com.example.a3rdumpire;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Pager extends FragmentStatePagerAdapter {
    int tabcount;
    public Pager(FragmentManager fm,int tabcount) {
        super(fm);
        this.tabcount=tabcount;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Tab1 tab1=new Tab1();
                return tab1;
            case 1:
                Tab2 tab2=new Tab2();
                return tab2;
                default:
                    return null;
        }

    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return tabcount;
    }
}
