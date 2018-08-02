package com.example.nw0623.apijsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView txtvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 画面項目のコンポーネントをオブジェクトにする
        btn = (Button) findViewById(R.id.btn);
        txtvw = (TextView) findViewById(R.id.tv);

        // ボタンが押されたときの処理
        btn.setOnClickListener(new View.OnClickListener() {
            WebTask task;

            public void onClick(View v) {
                try {
                    // APIのuriを設定
                    URL uri = new URL("http://192.168.5.142:8080/resttest/rest_get");
                    task = new WebTask(txtvw);
                    // AsyncTaskを起動
                    task.execute(uri);
                } catch (Exception e) {
                    //エラー発生時
                    Toast.makeText(MainActivity.this, "取得エラー", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
