package com.example.dialoglibrary.utils;

import com.example.dialoglibrary.DialogWrapper;
import com.example.dialoglibrary.HDialog;

import java.util.concurrent.ConcurrentLinkedQueue;

public class HDialogsManager {

    private volatile  boolean showing =false;//是否有dialog在展示

    private ConcurrentLinkedQueue<DialogWrapper> dialogQueue=new ConcurrentLinkedQueue<>();

    private HDialogsManager(){}

    public  static HDialogsManager getInstance(){
        return  DialogHolder.instance;
    }


    private static class DialogHolder{
        private static HDialogsManager instance =new HDialogsManager();
    }


    /**
     *
     * @param dialogWrapper
     * @return
     */
    public  synchronized  boolean requestShow(DialogWrapper dialogWrapper){
        boolean b=dialogQueue.offer(dialogWrapper);
        checkAndDispatch();
        return b;
    }

    /**
     * 结束一次展示 并且检查下一个弹窗
     */
    public synchronized void over() {
        showing = false;
        next();
    }

    private synchronized void checkAndDispatch() {
        if (!showing) {
            next();
        }
    }
    /**
     * 弹出下一个弹窗
     */
    private synchronized void next() {
        DialogWrapper poll = dialogQueue.poll();
        if (poll == null) return;
        HDialog.Builder dialog = poll.getDialog();
        if (dialog != null) {
            showing = true;
            dialog.show();
        }
    }

}
