package com.example.assignment4;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class EditDialog extends Dialog {
    TextView tvTitle;
    RadioGroup radioGroup;
    RadioButton rbUpperCase,rbLowerCAse,rbInItCAP;
    CheckBox cbReverse;
    Button btnDOne;
    private int maxLoginAttempts = 3;
    private int attemptsCOunt = 0;


    public interface OnEditListener {
        void onSuccess();

        void onFailure();

        void onMaxAttempts();
    }

    private OnEditListener onLoginListener = null;

    public void setOnLoginListener(OnEditListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }


    public void setMaxLoginAttempts(int maxLoginAttempts) {
        if (maxLoginAttempts > 0) {
            this.maxLoginAttempts = maxLoginAttempts;
        }
    }

    private Context context;

    EditDialog(Context context, String s) {
        super(context);
        this.context = context;
        setContentView(R.layout.edit_dialog);
        initUI();
        btnDOne.setOnClickListener(new btnLoginClickListener());



    }

    private void initUI() {
        tvTitle=findViewById(R.id.tvTitlleEditDialog);
        radioGroup=findViewById(R.id.rgRAdioGr);
        rbUpperCase=findViewById(R.id.rbUpperCAse);
        rbLowerCAse=findViewById(R.id.rbLowerCaes);
        rbInItCAP=findViewById(R.id.rbInitCap);
        btnDOne=findViewById(R.id.btnDone);
        cbReverse=findViewById(R.id.cbReverse);

    }

    private class btnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if (onLoginListener == null) {
                return;
            }
            if (onLoginListener==null) {
                onLoginListener.onSuccess();
                dismiss();

            } else {
                attemptsCOunt++;
                if (attemptsCOunt > maxLoginAttempts) {
                    onLoginListener.onMaxAttempts();
                    dismiss();
                    return;
                }
                onLoginListener.onFailure();


            }
        }

        private void makeToast(String text) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }


    }
}