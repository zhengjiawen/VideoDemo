package example.luojing.vitamiodemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment implements View.OnClickListener{
    private Button login;
    private EditText accountEdit;
    private EditText passwardEdit;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login, container,false);
        login=(Button)v.findViewById(R.id.login);
        login.setOnClickListener(this);
        accountEdit=(EditText)v.findViewById(R.id.account);
        passwardEdit=(EditText)v.findViewById(R.id.passward);
        return v;
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
        SharedPreferences pref = getContext().getSharedPreferences("data",0);
        if(passward.equals(pref.getString(account,""))){                //输入账户密码
//            Toast.makeText(this,"正确",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }else
        {
            Toast.makeText(getActivity(),"账号或者密码错误",Toast.LENGTH_SHORT).show();
        }
    }

}
