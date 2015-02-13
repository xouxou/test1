package course.project.moma;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView mTextView1 = null;
	private TextView mTextView2 = null;
	private TextView mTextView3 = null;
	private TextView mTextView4 = null;
	private TextView mTextView5 = null;
	private SeekBar mSeekBar = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTextView1 = (TextView) findViewById(R.id.textview1);
		mTextView2 = (TextView) findViewById(R.id.textview2);
		mTextView3 = (TextView) findViewById(R.id.textview3);
		mTextView4 = (TextView) findViewById(R.id.textview4);
		mTextView5 = (TextView) findViewById(R.id.textview5);
		mSeekBar = (SeekBar) findViewById(R.id.seekBar1);
		
		int color = getResources().getColor(R.color.blue);
		mTextView4.setBackgroundColor(color);
		
		color = getResources().getColor(R.color.purple);
		mTextView1.setBackgroundColor(color);
		
		color = getResources().getColor(R.color.darkblue);
		mTextView3.setBackgroundColor(color);
		
		color = getResources().getColor(R.color.darkorange);
		mTextView5.setBackgroundColor(color);
		
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				// TODO Auto-generated method stub
				Log.i("progress","aaa" + progress);
				int color = color(getResources().getColor(R.color.purple), getResources().getColor(R.color.red), progress);
				mTextView4.setBackgroundColor(color);
				
				color = color(getResources().getColor(R.color.red), getResources().getColor(R.color.green), progress);
				mTextView1.setBackgroundColor(color);
				
				color = color(getResources().getColor(R.color.darkblue), getResources().getColor(R.color.darkpurple), progress);
				mTextView3.setBackgroundColor(color);
				
				color = color(getResources().getColor(R.color.darkorange), getResources().getColor(R.color.darkblue), progress);
				mTextView5.setBackgroundColor(color);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public int color(int color1, int color2, int progress) {
		int red, green, blue; // rgb components
		int deltaR, deltaG, deltaB; // change in rgb components

		deltaR = Color.red(color2) - Color.red(color1);
		deltaG = Color.green(color2) - Color.green(color1);
		deltaB = Color.blue(color2) - Color.blue(color1);

		red = Color.red(color1) + (deltaR * progress / 100);
		green = Color.green(color1) + (deltaG * progress / 100);
		blue = Color.blue(color1) + (deltaB * progress / 100);

		return Color.rgb(red, green, blue);
	}
}
