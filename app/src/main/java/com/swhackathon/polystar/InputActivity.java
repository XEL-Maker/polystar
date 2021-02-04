package com.swhackathon.polystar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
public class InputActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        //타이틀바 삭제 시작
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //타이틀바 삭제 종료
    }
}