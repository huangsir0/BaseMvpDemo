package com.example.dialoglibrary;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import java.lang.ref.WeakReference;

public class HDialogController {

    private int layoutRes;

    private int dialogWidth;

    private int dialogHeight;

    private float dimAmount =Const.DimAmount;

    private int gravity= Gravity.CENTER;

    private boolean isCancelableOutside= false;

    private boolean cancelable;

    private int animRes;

    private View dialogView;

    private String titleStr;//标题

    private String contentStr;//内容

    private String positiveStr;//右边按钮文字

    private String negativeStr;//左边按钮文字

    private boolean showBtnLeft, showBtnRight;

    private Button btn_ok, btn_cancel;

    private IDialog.OnClickListener mPositiveButtonListener;
    private IDialog.OnClickListener mNegativeButtonListener;
    private WeakReference<IDialog> mDialog;

    HDialogController(IDialog dialog) {
        mDialog = new WeakReference<>(dialog);
    }

    int getAnimRes() {
        return animRes;
    }

    int getLayoutRes() {
        return layoutRes;
    }

    void setLayoutRes(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    int getDialogWidth() {
        return dialogWidth;
    }

    int getDialogHeight() {
        return dialogHeight;
    }

    float getDimAmount() {
        return dimAmount;
    }

    public int getGravity() {
        return gravity;
    }

    boolean isCancelableOutside() {
        return isCancelableOutside;
    }

    boolean isCancelable() {
        return cancelable;
    }

    public void setDialogView(View dialogView) {
        this.dialogView = dialogView;
    }

    View getDialogView() {
        return dialogView;
    }
}
