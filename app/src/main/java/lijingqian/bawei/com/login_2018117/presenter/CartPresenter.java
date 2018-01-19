package lijingqian.bawei.com.login_2018117.presenter;


import lijingqian.bawei.com.login_2018117.bean.CartBean;
import lijingqian.bawei.com.login_2018117.model.CartModel;
import lijingqian.bawei.com.login_2018117.model.CartModelCallback;
import lijingqian.bawei.com.login_2018117.view.CartView;

/**
 * date:2018/1/16 14:23
 * introduction:
 */

public class CartPresenter {

    private CartView view;
    private CartModel model;

    public CartPresenter(CartView view) {
        this.view = view;
        model=new CartModel();
    }

    public void getCart(String uid){
        model.getCartData(uid, new CartModelCallback() {
            @Override
            public void success(CartBean bean) {
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
