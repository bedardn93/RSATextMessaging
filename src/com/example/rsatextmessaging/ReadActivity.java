package com.example.rsatextmessaging;

import android.R;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ReadActivity extends Activity {

	private TextView tv;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);
         
        tv = (TextView) findViewById(R.id.textView1);
         
        String id = getIntent().getStringExtra("id");
        String[] projection = {"_id", "address", "date", "body"};
        String selection = "_id = ?";
        String[] selectionArgs = {id};
        Cursor c = getContentResolver().query(SmsXp.INBOX_URI, projection,
                                                selection, selectionArgs, null);
        if (c.moveToFirst()) {
            setTitle(c.getString(c.getColumnIndex("address")));
            tv.setText(c.getString(c.getColumnIndex("body")));
        }
    }  
}
