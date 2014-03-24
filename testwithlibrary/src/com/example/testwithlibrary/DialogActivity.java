package com.example.testwithlibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.glass.widget.MessageDialog;

public class DialogActivity extends Activity {


	protected static final String TAG = "DialogActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_dialog);
		
		showItemAddingDialog(this);
	}
	
	private void showItemAddingDialog(final Context ctx) {
		MessageDialog localDialog = new MessageDialog.Builder(ctx)
				.setTemporaryIcon(R.drawable.ic_sync_50)
				.setTemporaryMessage(R.string.dlg_temp_message)
				.setTemporarySecondaryMessage(R.string.dlg_temp_secondary_message)
				.setIcon(R.drawable.ic_done_50)
				.setMessage(R.string.dlg_message)
				.setSecondaryMessage(R.string.dlg_secondary_message)
				.setDismissable(true)
				.setAutoHide(true)
				.setListener(new MessageDialog.SimpleListener() {
					public boolean onConfirmed() {
						Log.d(TAG, "onConfirm");
						Toast.makeText(ctx, "onConfirmed", Toast.LENGTH_LONG).show();
						return true;
					}

					public void onDismissed() {
						Log.d(TAG, "onDismissed");
						Toast.makeText(ctx, "onDismissed", Toast.LENGTH_LONG).show();
					}

					public void onDone() {
						Log.d(TAG, "onDone");
						Toast.makeText(ctx, "onDone", Toast.LENGTH_LONG).show();
					}
				}).build();
		localDialog.show();
	}
}
