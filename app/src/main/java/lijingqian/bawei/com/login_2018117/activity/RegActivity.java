package lijingqian.bawei.com.login_2018117.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lijingqian.bawei.com.login_2018117.R;
import lijingqian.bawei.com.login_2018117.bean.RegBean;
import lijingqian.bawei.com.login_2018117.presenter.RegPresenter;
import lijingqian.bawei.com.login_2018117.view.RegView;

public class RegActivity extends AppCompatActivity implements RegView {


    @BindView(R.id.reg_mobile)
    EditText mRegMobile;
    @BindView(R.id.reg_pwd)
    EditText mRegPwd;
    @BindView(R.id.tv_reg_reg)
    Button mTvRegReg;
    private RegPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);

        presenter = new RegPresenter(this);
    }


    @Override
    public String getMobile() {
        return mRegMobile.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mRegPwd.getText().toString().trim();
    }

    @Override
    public void success(RegBean bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        finish();
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

    @OnClick(R.id.tv_reg_reg)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_reg_reg:
                presenter.registe();
                break;
        }
    }
}
