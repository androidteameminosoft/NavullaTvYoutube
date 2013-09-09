package com.eminosoft.navullaTv;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends ActionBarActivity {

	FragmentPageTitle mDemoCollectionPagerAdapter;
	ViewPager mViewPager;
	public static RequestQueue quee;
	public static ImageLoader imageLoader;
	public static int[] colors;
	PagerTabStrip strap;
	int position;
	ActionBar actionBar;
	LayoutInflater inflater;
	View back_acc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collection);
		inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		back_acc = (View) inflater.inflate(R.layout.customtitle, null);
		back_acc.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.FILL_PARENT));

		strap = (PagerTabStrip) findViewById(R.id.pager_title_strip);
		colors = new int[] { this.getResources().getColor(R.color.color1),
				this.getResources().getColor(R.color.color2),
				this.getResources().getColor(R.color.color3),
				this.getResources().getColor(R.color.color4),
				this.getResources().getColor(R.color.color5),
				this.getResources().getColor(R.color.color6),
				this.getResources().getColor(R.color.color7),
				this.getResources().getColor(R.color.color8),
				this.getResources().getColor(R.color.color6) };

		quee = Volley.newRequestQueue(this);

		imageLoader = new ImageLoader(quee, new BitmapLruCache(
				BitmapLruCache.getDefaultLruCacheSize()));
		strap.setBackgroundColor(colors[0]);
		actionBar = getSupportActionBar();
		actionBar.setCustomView(back_acc);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		mDemoCollectionPagerAdapter = new FragmentPageTitle(
				getSupportFragmentManager(), this);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mDemoCollectionPagerAdapter);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				position = arg0;
				strap.setBackgroundColor(colors[arg0]);
				GradientDrawable gd = new GradientDrawable(
						Orientation.BOTTOM_TOP, new int[] { colors[arg0],
								colors[arg0] });
				gd.setGradientCenter(10, 10);
				gd.setGradientRadius(10);
				gd.setDither(true);
				// actionBar.setBackgroundDrawable(gd);
				back_acc.setBackgroundDrawable(gd);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// getActionBarHelper().changeBackgroundColor(colors[arg0]);

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// getActionBarHelper().changeBackgroundColor(colors[arg0]);
				if (arg0 == ViewPager.SCROLL_STATE_DRAGGING) {
					System.out.println("Left position" + mViewPager.getLeft()
							+ "right position" + mViewPager.getRight());

					if (mViewPager.getCurrentItem() == 0) {

					}

					System.out.println("current position"
							+ mViewPager.getCurrentItem());
					if (mViewPager.getCurrentItem() == mDemoCollectionPagerAdapter
							.getCount()) {

						GradientDrawable gd = new GradientDrawable(
								Orientation.BOTTOM_TOP,
								new int[] {
										colors[mViewPager.getCurrentItem() - 1],
										colors[mViewPager.getCurrentItem()] });
						gd.setGradientCenter(10, 10);
						gd.setGradientRadius(10);
						strap.setBackgroundDrawable(gd);
						back_acc.setBackgroundDrawable(gd);
					} else {
						GradientDrawable gd = new GradientDrawable(
								Orientation.BOTTOM_TOP,
								new int[] {
										colors[mViewPager.getCurrentItem() + 1],
										colors[mViewPager.getCurrentItem()] });
						gd.setGradientCenter(10, 10);
						gd.setGradientRadius(10);
						strap.setBackgroundDrawable(gd);
						back_acc.setBackgroundDrawable(gd);
					}
					// strap.setBackgroundDrawable(getResources().getDrawable(
					// R.drawable.pull_to_refresh_header_background));

				} else if (arg0 == ViewPager.SCROLL_STATE_SETTLING) {
					strap.setBackgroundColor(colors[mViewPager.getCurrentItem()]);
					back_acc.setBackgroundColor(colors[mViewPager
							.getCurrentItem()]);
				}

			}
		});

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		System.out.println(newConfig.orientation);
	}

}
