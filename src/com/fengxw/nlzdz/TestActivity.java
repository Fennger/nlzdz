package com.fengxw.nlzdz;
 

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;

public class TestActivity extends FragmentActivity {
	ViewPager viewPager;
	PagerSlidingTabStrip tabs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		tabs.setViewPager(viewPager);
	}

	class myPagerAdapter extends FragmentPagerAdapter {
		String[] title = { "项目一", "项目二", "项目三" };
		Fragment1 fragment1;
		Fragment2 fragment2;
		Fragment3 fragment3;

		public myPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				fragment1 = new Fragment1();
				return fragment1;
			case 1:
				fragment2 = new Fragment2();
				return fragment2;
			case 2:
				fragment3 = new Fragment3();
				return fragment3;

			default:
				return null;
			}
		}

		@Override
		public int getCount() {

			return title.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return title[position];
		}
		
		

	}

}
