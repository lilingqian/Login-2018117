package lijingqian.bawei.com.login_2018117.presenter;


import lijingqian.bawei.com.login_2018117.bean.UpdateOrderBean;
import lijingqian.bawei.com.login_2018117.model.UpdateOrderCallback;
import lijingqian.bawei.com.login_2018117.model.UpdateOrderModel;
import lijingqian.bawei.com.login_2018117.view.UpdateOrderView;

/**
 * date:2018/1/17 16:13
 * introduction:
 */

public class UpdateOrderPresenter {

    private UpdateOrderView view;
    private UpdateOrderModel model;

    public UpdateOrderPresenter(UpdateOrderView view) {
        this.view = view;
        model=new UpdateOrderModel();
    }

    public void updateOrder(String status,String orderId){
        model.updateOrder(status, orderId, new UpdateOrderCallback() {
            @Override
            public void success(UpdateOrderBean bean) {
                view.success(bean);
            }

            @Override
            public void failure(int code) {
               view.failure(code);
            }
        });
    }


}
