    package com.swhackathon.polystar;

    import androidx.appcompat.app.ActionBar;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageButton;

    public class JoinActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_join);
            //타이틀바 삭제 시작
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
            //타이틀바 삭제 종료
            ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton2);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }