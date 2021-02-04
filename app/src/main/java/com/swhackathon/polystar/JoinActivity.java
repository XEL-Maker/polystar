package com.swhackathon.polystar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {

    EditText name, id;
    ImageButton loginBtn;
    String loginName, loginId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        name = (EditText) findViewById(R.id.inputName);
        id = (EditText) findViewById(R.id.inputId);
        loginBtn = (ImageButton) findViewById(R.id.loginBtn);

        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);

        loginName = auto.getString("inputName", null);
        loginId = auto.getString("inputId", null);

        // 이전 로그인 아이디가 남아있을 경우 (loginId != null)
        if (loginName != null && loginId != null) {
            //                                                           자동로그인
            Intent intent = new Intent(JoinActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        // 이전 로그인 아이디가 남아있지 않은 경우 (loginId == null)
        else if (loginName == null || loginId == null) {
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor autoLogin = auto.edit();
                    autoLogin.putString("inputId", id.getText().toString());
                    autoLogin.putString("inputName", name.getText().toString());
                    autoLogin.commit();
                    //                                                           가이드라인 이동용
                    Intent intent = new Intent(JoinActivity.this, StarQuestionActivity2.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}