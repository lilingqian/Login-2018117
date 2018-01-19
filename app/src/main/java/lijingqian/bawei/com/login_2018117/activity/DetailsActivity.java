package lijingqian.bawei.com.login_2018117.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lijingqian.bawei.com.login_2018117.R;
import lijingqian.bawei.com.login_2018117.bean.AddCartBean;
import lijingqian.bawei.com.login_2018117.bean.DetailsBean;
import lijingqian.bawei.com.login_2018117.presenter.AddCartPresenter;
import lijingqian.bawei.com.login_2018117.presenter.DetailsPresenter;
import lijingqian.bawei.com.login_2018117.view.AddCartView;
import lijingqian.bawei.com.login_2018117.view.DetailsView;

public class DetailsActivity extends AppCompatActivity implements DetailsView,AddCartView {

    @BindView(R.id.det_iv)
    ImageView mDetIv;
    @BindView(R.id.det_name)
    TextView mDetName;
    @BindView(R.id.det_content)
    TextView mDetContent;
    @BindView(R.id.det_price)
    TextView mDetPrice;
    @BindView(R.id.cart)
    TextView mCart;
    @BindView(R.id.addCart)
    TextView mAddCart;
    private DetailsPresenter presenter;
    private AddCartPresenter presenter1;
    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        presenter = new DetailsPresenter(this);
        presenter.getDetails(pid + "");
        presenter1 = new AddCartPresenter(this);

    }

    @Override
    public void success(DetailsBean bean) {
        mDetContent.setText(bean.getData().getSubhead());
        mDetPrice.setText("优惠价：¥"+bean.getData().getPrice());
        String[] split = bean.getData().getImages().split("\\|");
        Glide.with(this).load(split[0]).into(mDetIv);
    }

    @Override
    public void success(AddCartBean bean) {
        Toast.makeText(this,bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(int code) {
        Log.e("Exception", "failure: "+code );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
        presenter1.dettach();
    }

    @OnClick({R.id.cart, R.id.addCart})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.cart:
                startActivity(new Intent(this,CartActivity.class));
                break;
            case R.id.addCart:
                presenter1.addIntoCart(pid,"100");
                break;
        }
    }
}
