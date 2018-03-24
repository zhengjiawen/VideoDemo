package example.luojing.vitamiodemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import java.util.ArrayList;

public class LoginActivity extends BaseActivity{

    private ViewPager mViewPager;
    private ArrayList<Fragment> fragments;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.login:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.register:
                    mViewPager.setCurrentItem(1);
                    return true;
            }
            return false;
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        fragments = new ArrayList<Fragment>();
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(adapter);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    protected void onStart(){
        super.onStart();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mViewPager.setCurrentItem(0);
    }
}
