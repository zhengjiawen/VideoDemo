package example.luojing.vitamiodemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class RegisterFragment extends Fragment implements View.OnClickListener{
    private EditText mAccount;
    private EditText mPassword;
    private EditText mPasswordSure;
    private Button mRegister;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.register, container,false);
        mAccount=(EditText) v.findViewById(R.id.account1);
        mPassword=(EditText) v.findViewById(R.id.passward1);
        mPasswordSure=(EditText) v.findViewById(R.id.passwardSure);
        mRegister=(Button) v.findViewById(R.id.register);
        mRegister.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.register:
                verify();
                break;
            default:    break;
        }
    }

    public void verify(){                                            //验证账号和密码
        String account=mAccount.getText().toString();
        String passward=mPassword.getText().toString();
        String passwardSure=mPasswordSure.getText().toString();
        SharedPreferences pref = getContext().getSharedPreferences("data",0);

        if(!pref.getString(account,"").isEmpty()){
            Toast.makeText(getActivity(),"该用户已存在",Toast.LENGTH_SHORT).show();
        }
        else {
            if (passward.equals(passwardSure)) {
                SharedPreferences.Editor editor = getContext().getSharedPreferences("data",0).edit();
                editor.putString(account,passward);
                editor.apply();
                Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
                mPassword.setText("");
                mPasswordSure.setText("");
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getActivity(), "请重新确认密码", Toast.LENGTH_SHORT).show();
                mPassword.setText("");
                mPasswordSure.setText("");
            }
        }
    }



}
