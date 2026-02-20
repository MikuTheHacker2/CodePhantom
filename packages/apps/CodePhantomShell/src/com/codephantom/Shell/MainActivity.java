package com.codephantom.shell;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    TextView tv = new TextView(this);
    tv.setText("CodePhantom Shell - DevSec Terminal Environment");
    tv.setTextSize(20f);

  setContentView(tv);
  }
}
