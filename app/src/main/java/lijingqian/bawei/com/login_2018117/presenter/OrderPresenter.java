package lijingqian.bawei.com.login_2018117.presenter;


import lijingqian.bawei.com.login_2018117.bean.OrderBean;
import lijingqian.bawei.com.login_2018117.model.OrderModel;
import lijingqian.bawei.com.login_2018117.model.OrderModelCallback;
import lijingqian.bawei.com.login_2018117.view.OrderView;

/**
 * date:2018/1/16 19:29
 * introduction:
 */

public class OrderPresenter {
    private OrderView view;
    private OrderModel model;

    public OrderPresenter(OrderView view) {
        this.view = view;
        model=new OrderModel();
    }


    public void getOrder(String status){
        model.getOrderData(status, new OrderModelCallback() {
            @Override
            public void success(OrderBean bean) {
                view.success(bean);
            }

            @Override
            public void failure(int code) {
               view.failure(code);
            }
        });
    }
    /**
     * 解除绑定
     */
    public void dettach(){
        this.view=null;
    }
}
