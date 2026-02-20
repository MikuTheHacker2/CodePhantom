package com.codephantom.shell;

import android.app.Activity;
import android.os.Bundle;
import android.view.TerminalView;

public class MainActivity extends Activity {
  TerminalView terminalview;
  @Override
  protected void onCreate(savedInstanceState);
  terminalView = new TerminalView(this);
terminalView.attachSession(new com.termux.terminal.TerminalSession("/system/bin/sh"));

setContentView(terminalView, new ViewGroup.LayoutParams(
  ViewGroup.LayoutParams.MATCH_PARENT,
  ViewGroup.LayoutParams.MATCH_PARENT
  ));
}
}
