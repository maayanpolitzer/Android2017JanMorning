package com.example.hackeru.asynctaskadvanced;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.activity_main_progress_bar);
        final TextView textView = (TextView) findViewById(R.id.activity_main_text_view);

        final String content = "Wow!!!\nIt's working!!!";

        findViewById(R.id.activity_main_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTask(progressBar, textView).execute(content);
            }
        });

    }

    private class MyTask extends AsyncTask<String, Integer, String> {

        private ProgressBar progressBar;
        private TextView textView;

        public MyTask(ProgressBar progressBar, TextView textView) {
            this.progressBar = progressBar;
            this.textView = textView;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
           for (int i = 0; i < 100; i++){
               publishProgress(i);
               try {
                   Thread.sleep(50);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            return params[0];
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            if (s != null) {
                textView.setText(s);
            }else{
                textView.setText("Error!!!!!");
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.setText(values[0] + "%");
        }
    }
}
