package lijingqian.bawei.com.login_2018117.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import lijingqian.bawei.com.login_2018117.R;
import lijingqian.bawei.com.login_2018117.bean.CartBean;
import lijingqian.bawei.com.login_2018117.bean.DeleteBean;
import lijingqian.bawei.com.login_2018117.presenter.DeleteCartPresenter;
import lijingqian.bawei.com.login_2018117.view.AddAndDel;
import lijingqian.bawei.com.login_2018117.view.DeleteCartView;

/**
 * date:2018/1/16 14:32
 * introduction:
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>implements DeleteCartView {

    private Context context;
    private DeleteCartPresenter presenter=new DeleteCartPresenter(this);

    private List<CartBean.DataBean.ListBean> list;
    private Map<String,String> map=new HashMap<>();
    public CartAdapter(Context context) {
        this.context = context;
    }

    public void add(CartBean bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.clear();
        for (CartBean.DataBean dataBean : bean.getData()) {
            map.put(dataBean.getSellerid(), dataBean.getSellerName());
            for (int i = 0; i < dataBean.getList().size(); i++) {
               this.list.add(dataBean.getList().get(i));
            }
        }
        setFirst(this.list);
        notifyDataSetChanged();
    }

    private void setFirst(List<CartBean.DataBean.ListBean> list) {
        if (list.size() > 0) {
            list.get(0).setIsFirst(1);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getSellerid() == list.get(i - 1).getSellerid()) {
                    list.get(i).setIsFirst(2);
                } else {
                    list.get(i).setIsFirst(1);
                }
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (list.get(position).getIsFirst() == 1) {
            holder.mCbGroup.setVisibility(View.VISIBLE);
            holder.mGroupName.setVisibility(View.VISIBLE);

            holder.mCbGroup.setChecked(list.get(position).isGroupSelected());
           // holder.mCbGroup.setChecked(true);
            holder.mGroupName.setText(map.get(String.valueOf(list.get(position).getSellerid())));
        } else {
            holder.mCbGroup.setVisibility(View.INVISIBLE);
            holder.mCbGroup.setVisibility(View.INVISIBLE);
        }
        holder.mTvPrice.setText(list.get(position).getPrice() + "");
        holder.mTvTitle.setText(list.get(position).getTitle());
        holder.mCbChild.setChecked(list.get(position).isChildSelected());
       // holder.mCbChild.setChecked(true);
        String[] split = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(holder.mIvImg);
        holder.mAddAndDel.setEditText(list.get(position).getNum()+"");
        holder.mAddAndDel.setListener(new AddAndDel.UpdateListener() {
            @Override
            public void click(int count) {
                list.get(position).setNum(count);
                notifyDataSetChanged();
                sum(list);
            }
        });
        /**
         * 商家控制商品
         */
        holder.mCbGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setGroupSelected(holder.mCbGroup.isChecked());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(position).getSellerid() == list.get(i).getSellerid()) {
                        list.get(i).setChildSelected(holder.mCbGroup.isChecked());
                    }
                }
                sum(list);
                notifyDataSetChanged();
            }

        });
        /**
         * 商品控制商家
         */
        holder.mCbChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setChildSelected(holder.mCbChild.isChecked());
                for (int i = 0; i <list.size() ; i++) {
                    for (int j = 0; j <list.size() ; j++) {
                        if(list.get(i).getSellerid()==list.get(j).getSellerid()&&!list.get(j).isChildSelected()){
                            list.get(i).setGroupSelected(false);
                            break;
                        }else{
                            list.get(i).setGroupSelected(true);
                        }
                    }
                }
                sum(list);
                notifyDataSetChanged();
            }
        });

        /**
         * 删除
         */
        holder.mIvDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.deleteCart(list.get(position).getPid()+"");
                list.remove(position);
                setFirst(list);
                sum(list);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    @Override
    public void success(DeleteBean bean) {
        Toast.makeText(context,bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(int code) {

    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cb_group)
        CheckBox mCbGroup;
        @BindView(R.id.group_name)
        TextView mGroupName;
        @BindView(R.id.cb_child)
        CheckBox mCbChild;
        @BindView(R.id.iv_img)
        ImageView mIvImg;
        @BindView(R.id.tv_price)
        TextView mTvPrice;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.addAndDel)
        AddAndDel mAddAndDel;
        @BindView(R.id.iv_del)
        ImageView mIvDel;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 全选与全不选
     */

    public void selectAll(boolean bool){
        for (int i = 0; i <list.size() ; i++) {
            list.get(i).setGroupSelected(bool);
            list.get(i).setChildSelected(bool);
        }
        sum(list);
        notifyDataSetChanged();
    }
    /**
     * 计算总价
     */
    private void sum(List<CartBean.DataBean.ListBean> list){
        int count=0;
        float price = 0.0f;
        boolean allcheck=true;
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).isChildSelected()){
                count+=list.get(i).getNum();
                price+=list.get(i).getPrice()*list.get(i).getNum();
            }else{
                allcheck=false;
            }
        }
        listener.setTotal(price+"",count+"",allcheck);
    }
    private UpdateListener listener;
    public void setListener(UpdateListener listener){
        this.listener=listener;
    }
    public interface UpdateListener{
        void setTotal(String total, String num, boolean bool);
    }
}
