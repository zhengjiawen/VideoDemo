package example.luojing.vitamiodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button login;
    private EditText accountEdit;
    private EditText passwardEdit;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        accountEdit=(EditText)findViewById(R.id.account);
        passwardEdit=(EditText)findViewById(R.id.passward);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.login:
                verify();
                break;
            default:    break;
        }
    }

    public void verify(){                                            //验证账号和密码
        String account=accountEdit.getText().toString();
        String passward=passwardEdit.getText().toString();
        if(account.equals("admin")&&passward.equals("admin")){                //输入账户密码
//            Toast.makeText(this,"正确",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else
        {
            Toast.makeText(this,"账号或者密码错误",Toast.LENGTH_SHORT).show();
        }
    }

}
