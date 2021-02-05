package com.swhackathon.polystar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class JoinActivity extends AppCompatActivity {

    EditText name, id;
    ImageButton loginBtn;
    String loginName, loginId;
    ImageView imageView5;
    ImageButton imageButton15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        // 갤러리 구현
        imageView5 = (ImageView) findViewById(R.id.imageView5);

        imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });


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
    @Override   //갤러리 들어가는 코드
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    imageView5.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}