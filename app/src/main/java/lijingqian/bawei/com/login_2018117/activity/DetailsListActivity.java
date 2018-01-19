package lijingqian.bawei.com.login_2018117.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lijingqian.bawei.com.login_2018117.R;
import lijingqian.bawei.com.login_2018117.adapter.DetailListAdapter;
import lijingqian.bawei.com.login_2018117.bean.DetailsListBean;
import lijingqian.bawei.com.login_2018117.presenter.DetailListPresenter;
import lijingqian.bawei.com.login_2018117.view.DetailListView;

public class DetailsListActivity extends AppCompatActivity implements DetailListView {
    private static final String TAG = "Exception";
    @BindView(R.id.detail_recycler)
    RecyclerView mDetailRecycler;
    private List<DetailsListBean.DataBean> list = new ArrayList<>();
    private DetailListPresenter presenter;
    private DetailListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_list);
        ButterKnife.bind(this);
        presenter = new DetailListPresenter(this);
        presenter.getDetailsList();
        adapter = new DetailListAdapter(this,list);
        mDetailRecycler.setAdapter(adapter);
        mDetailRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void success(DetailsListBean bean) {
        list.addAll(bean.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void failure(int code) {
        Log.e(TAG, "failure: " + code);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }
}
