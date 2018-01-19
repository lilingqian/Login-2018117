package lijingqian.bawei.com.login_2018117.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lijingqian.bawei.com.login_2018117.R;
import lijingqian.bawei.com.login_2018117.adapter.CartAdapter;
import lijingqian.bawei.com.login_2018117.bean.CartBean;
import lijingqian.bawei.com.login_2018117.presenter.CartPresenter;
import lijingqian.bawei.com.login_2018117.view.CartView;

public class CartActivity extends AppCompatActivity implements CartView {
    List<CartBean.DataBean.ListBean> list = new ArrayList<>();
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.selectAll)
    CheckBox mSelectAll;
    @BindView(R.id.totalPrice)
    TextView mTotalPrice;
    @BindView(R.id.totalCount)
    TextView mTotalCount;
    @BindView(R.id.payment)
    TextView mPayment;
    private CartPresenter presenter;
    private CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        presenter = new CartPresenter(this);
        presenter.getCart("100");
        adapter = new CartAdapter(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setListener(new CartAdapter.UpdateListener() {
            @Override
            public void setTotal(String total, String num, boolean bool) {
                mTotalCount.setText("件数："+num);
                mTotalPrice.setText("总价："+total);
                mSelectAll.setChecked(bool);
            }
        });
    }

    @Override
    public void success(CartBean bean) {
        adapter.add(bean);
    }

    @Override
    public void failure(int code) {

    }

    @OnClick({R.id.selectAll, R.id.payment})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.selectAll:
                selectAll();
                break;
            case R.id.payment:
                startActivity(new Intent(this,OrderActivity.class));
                break;
        }
    }

    private void selectAll() {
        adapter.selectAll(mSelectAll.isChecked());
    }
}
