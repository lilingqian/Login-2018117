package lijingqian.bawei.com.login_2018117.presenter;


import lijingqian.bawei.com.login_2018117.bean.CreatOrderBean;
import lijingqian.bawei.com.login_2018117.model.CreateOrderCallback;
import lijingqian.bawei.com.login_2018117.model.CreateOrderModel;
import lijingqian.bawei.com.login_2018117.view.CreateOrderView;

/**
 * date:2018/1/17 14:08
 * introduction:
 */

public class CreateOrderPresenter {
    private CreateOrderView view;
    private CreateOrderModel model;

    public CreateOrderPresenter(CreateOrderView view) {
        this.view = view;
        model = new CreateOrderModel();
    }

    public void createOrder(final String price){
        model.createOrder(price, new CreateOrderCallback() {
            @Override
            public void success(CreatOrderBean bean) {
                if (price!=null){
                    view.success(bean);
                }else{
                    view.failure(bean);
                }

            }

            @Override
            public void failure(int code) {

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
