package com.codephantom.shell;

import android.app.Activity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    private TextView terminalOutput;
    private EditText terminalInput;
    private ScrollView scrollView;
    private final String PROMPT = "CodePhantom> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout principal
        scrollView = new ScrollView(this);

        // TextView para la salida de la consola
        terminalOutput = new TextView(this);
        terminalOutput.setText(PROMPT);
        terminalOutput.setTextSize(16);

        // EditText para escribir comandos
        terminalInput = new EditText(this);
        terminalInput.setSingleLine(true);
        terminalInput.setImeOptions(EditorInfo.IME_ACTION_DONE);

        // Evento al presionar Enter
        terminalInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                String command = terminalInput.getText().toString().trim();
                terminalInput.setText("");
                if (!command.isEmpty()) {
                    terminalOutput.append("\n" + PROMPT + command + "\n");
                    executeCommand(command);
                }
                return true;
            }
            return false;
        });

        // Agregamos el TextView y EditText al ScrollView
        scrollView.addView(terminalOutput);
        setContentView(scrollView, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        // Aseguramos que el teclado no tape la salida
        scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));
    }

    // Ejecuta un comando con root en background
    private void executeCommand(final String command) {
        new AsyncTask<Void, String, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Process process = Runtime.getRuntime().exec(new String[]{"su", "-c", command});
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        publishProgress(line);
                    }
                    reader.close();
                    process.waitFor();
                } catch (Exception e) {
                    publishProgress("Error: " + e.getMessage());
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                for (String line : values) {
                    terminalOutput.append(line + "\n");
                }
                // Siempre mantenemos el scroll al final
                scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));
            }
        }.execute();
    }
  }
