package com.example.testwithlibrary;

import android.app.Activity;
import android.os.Bundle;

import com.google.glass.widget.SliderView;

public class MainActivity extends Activity {

	private SliderView mProgress;
	private SliderView mIndeterm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mProgress = (SliderView) findViewById(R.id.progress_slider);
		mIndeterm = (SliderView) findViewById(R.id.indeterm_slider);

		mIndeterm.startIndeterminate();
		mProgress.startProgress(10 * 1000);
	}

}
