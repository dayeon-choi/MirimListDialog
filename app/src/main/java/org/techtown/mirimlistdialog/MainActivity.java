package org.techtown.mirimlistdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnBasicList,btnRadioList;
    String[] basicListArr={"봄","여름","가을","겨울"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBasicList=findViewById(R.id.btn_basic_list);
        btnBasicList.setOnClickListener(btnListener);
        btnRadioList=findViewById(R.id.btn_radio_list);
        btnRadioList.setOnClickListener(btnListener);

    }

    View.OnClickListener btnListener=new View.OnClickListener(){
        AlertDialog.Builder dlg=null;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_basic_list:
                    dlg=new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("좋아하는 계절을 선택하세요.");
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setItems(basicListArr,basicListener);
                    dlg.setPositiveButton("닫기",null);
                    dlg.show();
                    break;
                case R.id.btn_radio_list:
                    dlg=new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("좋아하는 계절을 선택하세요.");
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setSingleChoiceItems(basicListArr,0,radioListener);
                    dlg.setPositiveButton("닫기",null);
                    dlg.show();
                    break;
            }


        }
    };

    DialogInterface.OnClickListener basicListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            btnBasicList.setText(basicListArr[i]);
        }
    };

    DialogInterface.OnClickListener radioListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            btnRadioList.setText(basicListArr[i]);
        }
    };
}