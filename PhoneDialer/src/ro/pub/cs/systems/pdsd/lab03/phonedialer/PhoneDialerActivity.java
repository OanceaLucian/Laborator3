package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends Activity {
	String tel ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		
		ImageButton call = (ImageButton) findViewById(R.id.button13);
		ImageButton end_call = (ImageButton) findViewById(R.id.button14);
		ImageButton delete = (ImageButton) findViewById(R.id.button0);
		final EditText show_text = (EditText)findViewById(R.id.editText1);
		for (int i = 1; i <= 12; i++) {
			Button number = (Button) findViewById(i);
			number.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					Button b = (Button)view;
					String text = b.getText().toString();
					tel+=text;
					show_text.setText(tel);
				}

			});
			delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(tel.length()!=0)
					tel= tel.substring(0,tel.length()-1);
					show_text.setText(tel);
				}
			});
			call.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:"+tel));
					startActivity(intent);
					
				}
			});
			end_call.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					
				}
			});

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
