package com.example.hcl.basemvp.mvp.widgets.activitys;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dialoglibrary.DialogWrapper;
import com.example.dialoglibrary.HDialog;
import com.example.dialoglibrary.IDialog;
import com.example.dialoglibrary.utils.HDialogsManager;
import com.example.hcl.basemvp.BaseApp;
import com.example.hcl.basemvp.R;
import com.example.hcl.basemvp.daggers.components.DaggerMainComponent;
import com.example.hcl.basemvp.daggers.moudles.MainMoudle;
import com.example.hcl.basemvp.mvp.constract.MainContract;
import com.example.hcl.basemvp.daggers.components.AppComponent;
import com.example.hcl.basemvp.mvp.presenters.MainPresenter;
import com.example.hcl.basemvp.mvp.widgets.activitys.base.BaseAppActivity;
import com.example.hcl.basemvp.mvp.widgets.views.dialog.DialogView;

import javax.inject.Inject;


public class MainActivity extends BaseAppActivity<MainPresenter> implements MainContract.IMainView {

    @Inject
    BaseApp baseApp;

    @Override
    protected void setupActivityCommponent(AppComponent appComponent) {
        DaggerMainComponent.builder().appComponent(appComponent)
                .mainMoudle(new MainMoudle(this))
                .build().inject(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    public void showDefaultDialog(View view) {
        DialogView.createDefaultDialog(this, "我是标题", "你好,我们将在30分钟处理，稍后通知您订单结果！",
                "", new IDialog.OnClickListener() {
                    @Override
                    public void onClick(IDialog dialog)      {
                        dialog.dismiss();
                    }
                });
    }

    public void showDefaultDialogTwo(View view) {
        DialogView.createDefaultDialog(this, "分享", "分享此接单码，您和乘客都将获得现金红包！",
                "立即分享", new IDialog.OnClickListener() {
                    @Override
                    public void onClick(IDialog dialog) {
                        Toast.makeText(baseApp, "立即分享", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                },
                "有钱不要", new IDialog.OnClickListener() {
                    @Override
                    public void onClick(IDialog dialog) {
                        Toast.makeText(baseApp, "有钱不要", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    public void showBaseUseDialog(View view) {
        new HDialog.Builder(this)
                .setDialogView(R.layout.layout_dialog)
                .setAnimStyle(R.style.translate_style)
                .setScreenWidthP(0.9f)
                .setGravity(Gravity.CENTER)
                .setWindowBackgroundP(0.2f)
                .setCancelable(true)
                .setCancelable(true)
                .setCancelableOutSide(true)
                .setOnDismissListener(new IDialog.OnDismissListener() {
                    @Override
                    public void onDismiss(IDialog dialog) {
                        Toast.makeText(baseApp, "dismiss回调", Toast.LENGTH_SHORT).show();
                       // dialog.dismiss();
                    }
                })
                .setBuildChildListener(new IDialog.OnBuildListener() {
                    @Override
                    public void onBuildChildView(IDialog dialog, View view, int layoutRes) {
                        final EditText editText = view.findViewById(R.id.et_content);
                        editText.setText("Hello World");
                        Button btn_ok = view.findViewById(R.id.btn_ok);
                        btn_ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String editTextStr = null;
                                if (!TextUtils.isEmpty(editText.getText())) {
                                    editTextStr = editText.getText().toString();
                                }
                                dialog.dismiss();
                                Toast.makeText(baseApp, editTextStr, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .show();

    }

    public void showLoadingDialog(View view) {
        DialogView.createLoadingDialog(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DialogView.closeLoadingDialog(MainActivity.this);
            }
        }, 5000);
    }

    public void showAdDialog(View view) {
        new HDialog.Builder(this)
                .setDialogView(R.layout.layout_ad_dialog)
                .setWindowBackgroundP(0.5f)
                .setBuildChildListener(new IDialog.OnBuildListener() {
                    @Override
                    public void onBuildChildView(final IDialog dialog, View view, int layoutRes) {
                        ImageView iv_close = view.findViewById(R.id.iv_close);
                        iv_close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        ImageView iv_ad = view.findViewById(R.id.iv_ad);
                        iv_ad.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(baseApp, "点击广告", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                    }
                }).show();
    }

    public void showBottomDialog(View view) {
        new HDialog.Builder(this)
                .setDialogView(R.layout.layout_bottom_up)
                .setWindowBackgroundP(0.5f)
                .setAnimStyle(R.style.AnimUp)
                .setCancelableOutSide(true)
                .setCancelableOutSide(true)
                .setBuildChildListener(new IDialog.OnBuildListener() {
                    @Override
                    public void onBuildChildView(final IDialog dialog, View view, int layoutRes) {
                        Button btn_take_photo = view.findViewById(R.id.btn_take_photo);
                        btn_take_photo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(baseApp, "拍照", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });

                        Button btn_select_photo = view.findViewById(R.id.btn_select_photo);
                        btn_select_photo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(baseApp, "相册选取", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });

                        Button btn_cancel_dialog = view.findViewById(R.id.btn_cancel_dialog);
                        btn_cancel_dialog.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(baseApp, "取消", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setScreenWidthP(1.0f)
                .setGravity(Gravity.BOTTOM).show();
    }

    public void showDialogShare(View view) {


    }

    public void showGlobalDialog(View view) {
        //Build第一个Dialog
        HDialog.Builder builder1 = new HDialog.Builder(this)
                .setDialogView(R.layout.layout_ad_dialog)
                .setWindowBackgroundP(0.5f)
                .setBuildChildListener(new IDialog.OnBuildListener() {
                    @Override
                    public void onBuildChildView(final IDialog dialog, View view, int layoutRes) {
                        ImageView iv_close = view.findViewById(R.id.iv_close);
                        iv_close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        ImageView iv_ad = view.findViewById(R.id.iv_ad);
                        iv_ad.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(baseApp, "点击广告", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                    }
                });
        //Build第二个Dialog
        HDialog.Builder builder2 = new HDialog.Builder(this)
                .setDialogView(R.layout.layout_bottom_up)
                .setWindowBackgroundP(0.5f)
                .setAnimStyle(R.style.AnimUp)
                .setBuildChildListener(new IDialog.OnBuildListener() {
                    @Override
                    public void onBuildChildView(final IDialog dialog, View view, int layoutRes) {
                        Button btn_take_photo = view.findViewById(R.id.btn_take_photo);
                        btn_take_photo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(baseApp, "拍照", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });

                        Button btn_select_photo = view.findViewById(R.id.btn_select_photo);
                        btn_select_photo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(baseApp, "相册选取", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });

                        Button btn_cancel_dialog = view.findViewById(R.id.btn_cancel_dialog);
                        btn_cancel_dialog.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(baseApp, "取消", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setScreenWidthP(1.0f)
                .setGravity(Gravity.BOTTOM);
        //添加第一个Dialog
        HDialogsManager.getInstance().requestShow(new DialogWrapper(builder1));
        //添加第二个Dialog
        HDialogsManager.getInstance().requestShow(new DialogWrapper(builder2));


    }
}
