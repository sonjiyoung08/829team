package com.example.listscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;  // 파이어 베이스 인증
    private DatabaseReference mDatabaseRef; // 실시간 데이터베이스
    private EditText mEtId, mEtPasswd;
    private Button mBtnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();

        mEtId = findViewById(R.id.et_id);
        mEtPasswd = findViewById(R.id.et_passwd);
        mBtnSignup = findViewById(R.id.btn_signup);

        mBtnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // 회원가입 처리 시작
                String strId = mEtId.getText().toString();
                String strPasswd = mEtPasswd.getText().toString();

                // Firebase Auth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strId, strPasswd).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setPhoneId(firebaseUser.getPhoneNumber());
                            account.setPassword(strPasswd);

                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(SignupActivity.this, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(SignupActivity.this, "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}