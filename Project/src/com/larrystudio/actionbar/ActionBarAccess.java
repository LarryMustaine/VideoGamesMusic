package com.larrystudio.actionbar;

import com.larrystudio.videogamesmusic.R;

import android.app.ActionBar;
import android.app.Activity;


public final class ActionBarAccess {
	
	private static ActionBar actionBar;
	
	public static ActionBar instantiateActionBar(Activity activity) {
		
		if(actionBar == null) {
			try{
				getActionBarInstance(activity);		
				setTitles(activity);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return actionBar;
	}

	private static void getActionBarInstance(Activity activity) {
		actionBar = activity.getActionBar();
	}
	
	private static void setTitles(Activity activity) {
		actionBar.setTitle(activity.getString(R.string.action_bar_title));
		actionBar.setSubtitle(activity.getString(R.string.action_bar_subtitle));
		actionBar.show();
	}

	public static ActionBar getActionBarInstance() {
		return actionBar;
	}
}