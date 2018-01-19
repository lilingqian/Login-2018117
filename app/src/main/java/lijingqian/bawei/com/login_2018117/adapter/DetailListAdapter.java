package lijingqian.bawei.com.login_2018117.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lijingqian.bawei.com.login_2018117.R;
import lijingqian.bawei.com.login_2018117.activity.DetailsActivity;
import lijingqian.bawei.com.login_2018117.bean.DetailsListBean;

/**
 * date:2018/1/16 11:24
 * introduction:
 */

public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.MyViewHolder> {
    private Context context;
    private List<DetailsListBean.DataBean> list=new ArrayList<>();
    private View view;

    public DetailListAdapter(Context context, List<DetailsListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.detail_list_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String[] split = list.get(position).getImages().split("\\|");
        holder.mIvLv.setImageURI(Uri.parse(split[0]));
        holder.mTvLvNewPrice.setText("优惠价："+list.get(position).getPrice()+"");
        holder.mTvLvTitle.setText(list.get(position).getSubhead());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailsActivity.class);
                int pid = list.get(position).getPid();
                intent.putExtra("pid",pid+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_lv)
        SimpleDraweeView mIvLv;
        @BindView(R.id.tv_lv_title)
        TextView mTvLvTitle;
        @BindView(R.id.tv_lv_new_price)
        TextView mTvLvNewPrice;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
