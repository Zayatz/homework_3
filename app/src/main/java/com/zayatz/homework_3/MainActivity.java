package com.zayatz.homework_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit1number;
    EditText edit2number;
    TextView result;

    Button btnPlus;
    Button btnMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1number = (EditText) findViewById(R.id.editFirst);
        edit2number = (EditText) findViewById(R.id.editSecond);
        result = (TextView) findViewById(R.id.resView);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.btnPlus:
                if (isEmpty(edit1number) || isEmpty(edit2number)) {
                    result.setText(getString(R.string.wrong_num_input));
                    break;
                }
                else {
                    result.setText(Sum(edit1number, edit2number));
                    break;
                }

            case R.id.btnMinus:
                if (isEmpty(edit1number) || isEmpty(edit2number)) {
                    result.setText(getString(R.string.wrong_num_input));
                    break;
                }
                else {
                    result.setText(Dif(edit1number, edit2number));
                    break;
                }
        }
    }

    public static String Sum (EditText edit1, EditText edit2) {

            int result;
            int x = new Integer(edit1.getText().toString()).intValue();
            int y = new Integer(edit2.getText().toString()).intValue();

            result = x + y;

            String strResult = String.valueOf(result);

            return strResult;
    }

    public static String Dif (EditText edit1, EditText edit2) {

        int result;
        int x = new Integer(edit1.getText().toString()).intValue();
        int y = new Integer(edit2.getText().toString()).intValue();

        result = x - y;

        String strResult = String.valueOf(result);

        return strResult;
    }


    private static boolean isEmpty(EditText edit) {
        return edit.getText().toString().trim().length() == 0;
    }

}
