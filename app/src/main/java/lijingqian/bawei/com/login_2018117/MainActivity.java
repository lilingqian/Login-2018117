package lijingqian.bawei.com.login_2018117;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lijingqian.bawei.com.login_2018117.activity.DetailsListActivity;
import lijingqian.bawei.com.login_2018117.activity.RegActivity;
import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.presenter.LoginPresenter;
import lijingqian.bawei.com.login_2018117.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {


    @BindView(R.id.log_mobile)
    EditText mLogMobile;
    @BindView(R.id.log_pwd)
    EditText mLogPwd;
    @BindView(R.id.log_log)
    Button mLogLog;
    @BindView(R.id.log_reg)
    Button mLogReg;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);

    }
    @Override
    public String getMobile() {
        return mLogMobile.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mLogPwd.getText().toString().trim();
    }

    @Override
    public void success(LoginBean bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, DetailsListActivity.class);
        startActivity(intent);
    }

    @Override
    public void failure(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }


    @OnClick({R.id.log_log, R.id.log_reg})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.log_log:
                presenter.Login();
                break;
            case R.id.log_reg:
                startActivity(new Intent(this, RegActivity.class));
                break;
        }
    }
}
