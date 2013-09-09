package com.eminosoft.navullaTv;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPageTitle extends FragmentPagerAdapter {

	String urlBrahmandma = "https://gdata.youtube.com/feeds/api/playlists/PL5241442F99341A78?v=2&max-results=50&start-index=1&alt=jsonc";
	String urlKrishnabhagvan = "https://gdata.youtube.com/feeds/api/playlists/PL54A0CA8EF768DF5F?v=2&max-results=50&start-index=1&alt=jsonc";
	String urlAllarinaresh = "https://gdata.youtube.com/feeds/api/playlists/PLD2FB7A1B5272971C?v=2&max-results=50&start-index=1&alt=jsonc";
	String urlMsNarayana = "https://gdata.youtube.com/feeds/api/playlists/PL9B409F7A16A13925?v=2&max-results=50&start-index=1&alt=jsonc";
	String urlRajendhraPrasad = "https://gdata.youtube.com/feeds/api/playlists/PLA44A8165C78AF58E?v=2&max-results=50&start-index=1&alt=jsonc";
	String urlRaviTeja = "https://gdata.youtube.com/feeds/api/playlists/PLC6A492C35EA19C81?v=2&max-results=50&start-index=1&alt=jsonc";
	String urlSunil = "https://gdata.youtube.com/feeds/api/playlists/PLD33821E77C975FFD?v=2&max-results=50&start-index=1&alt=jsonc";
	String urlRecentUploads = "http://gdata.youtube.com/feeds/api/users/NavvulaTV/uploads?v=2&alt=jsonc&max-results=50&start-index=1";
	String poupularuploads = "http://gdata.youtube.com/feeds/api/users/NavvulaTV/uploads?v=2&alt=jsonc&max-results=50&orderby=viewCount";

	Context mContext;

	String[] urls = { urlRecentUploads, urlBrahmandma, urlKrishnabhagvan,
			urlAllarinaresh, poupularuploads, urlMsNarayana,
			urlRajendhraPrasad, urlSunil };
	String titles[];
	int totalCount;
	Fragment frags[];

	public FragmentPageTitle(FragmentManager fm, Context mContext) {
		super(fm);
		this.mContext = mContext;

		titles = mContext.getResources().getStringArray(R.array.titles);
		totalCount = titles.length;
		frags = new Fragment[totalCount];
		for (int i = 0; i < totalCount; i++) {
			Fragment fragment = new FragmentList();
			Bundle bundle = new Bundle();
			bundle.putString("url", urls[i]);
			bundle.putInt("color", MainActivity.colors[i]);
			bundle.putString("title", titles[i]);
			fragment.setArguments(bundle);

			frags[i] = fragment;
		}
	}

	@Override
	public Fragment getItem(int arg0) {
		Fragment fragment = frags[arg0];
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return totalCount;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titles[position];
	}

}
