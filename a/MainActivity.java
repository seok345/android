package com.example.dia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 좋아하는 간식 목록을 배열로 생성
                final String[] snacks = {"딸기", "치킨", "라면"};

                // 대화상자를 생성하고 제목 설정
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("좋아하는 간식을 선택하세요");

                // 배열을 대화상자의 목록으로 추가
                builder.setItems(snacks, (dialog, which) -> {
                    // 선택된 간식을 Toast로 표시
                    String selectedSnack = snacks[which];
                    Toast.makeText(MainActivity.this, "선택된 간식: " + selectedSnack, Toast.LENGTH_SHORT).show();
                });

                // 대화상자 표시
                builder.show();
            }
        });
    }
}
