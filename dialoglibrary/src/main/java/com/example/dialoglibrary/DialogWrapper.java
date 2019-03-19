package com.example.dialoglibrary;

public class DialogWrapper {
    private HDialog.Builder dialog;//统一管理dialog的弹出顺序

    public DialogWrapper(HDialog.Builder dialog){
        this.dialog=dialog;
    }
    public HDialog.Builder getDialog() {
        return dialog;
    }

    public void setDialog(HDialog.Builder dialog) {
        this.dialog = dialog;
    }

}
