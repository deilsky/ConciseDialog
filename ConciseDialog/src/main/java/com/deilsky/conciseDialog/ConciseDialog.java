package com.deilsky.conciseDialog;

import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by 帷幕 on 2017/12/6.
 */

public class ConciseDialog extends DialogFragment {
    public enum DialogGravity {
        TOP, MIDDLE, BOTTOM
    }

    public interface ReadyListener {
        void onComplete(View view);

        void onError(String e);
    }

    private int layoutId;
    private ReadyListener readyListener;
    private DialogGravity gravity;
    private boolean matchWidth = false;
    private double height = 0.3;
    private double width = 0.8;
    private int absoluteWidth = 200;
    private int absoluteHeight = 200;
    private boolean absolute = false;
    private boolean cancelable = false;

    /**
     * @param id            布局文件ID
     * @param readyListener 布局初始化完成回调
     * @return ConciseDialog
     */
    public static ConciseDialog newInstance(@LayoutRes int id, ReadyListener readyListener) {
        ConciseDialog dialog = new ConciseDialog();
        dialog.createView(id, readyListener);
        dialog.gravity = DialogGravity.MIDDLE;
        return dialog;
    }

    public ConciseDialog createView(@LayoutRes int layoutId, ReadyListener readyListener) {
        this.layoutId = layoutId;
        this.readyListener = readyListener;
        return this;
    }

    /**
     * @param absolute 是否使用绝对尺寸，如使用绝对尺寸，宽/高 将使用dp作为单位
     * @return ConciseDialog
     */
    public ConciseDialog absolute(boolean absolute) {
        this.absolute = absolute;
        return this;
    }

    /**
     * @param gravity Dialog位置 TOP, MIDDLE, BOTTOM 对应 上，中，下 默认 MIDDLE
     * @return ConciseDialog
     */
    public ConciseDialog gravity(DialogGravity gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * @param is 宽度最大化 默认 系统Dialog 宽度
     * @return ConciseDialog
     */
    public ConciseDialog matchWidth(boolean is) {
        this.matchWidth = is;
        return this;
    }

    /**
     * @param height Dialog 高度 默认 0.5 屏幕高度50%
     * @return ConciseDialog
     */
    public ConciseDialog height(double height) {
        this.height = height;
        return this;
    }

    /**
     * @param height Dialog 高度 默认 200dp
     * @return ConciseDialog
     */
    public ConciseDialog height(int height) {
        this.absoluteHeight = height;
        return this;
    }

    /**
     * @param width Dialog 宽度 默认 0.8 屏幕宽度80%
     * @return ConciseDialog
     */
    public ConciseDialog width(double width) {
        this.width = width;
        return this;
    }

    /**
     * @param width Dialog 宽度 默认 0.8 屏幕宽度80%
     * @return ConciseDialog
     */
    public ConciseDialog width(int width) {
        this.absoluteWidth = width;
        return this;
    }

    /**
     * 替换 setCancelable 方法，实现同样功能
     * @param cancelable true/false
     * @return ConciseDialog
     */
    public ConciseDialog cancelable(boolean cancelable){
        this.cancelable = cancelable;
        return this;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId, null);
        readyListener.onComplete(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setCancelable(this.cancelable);
        Window dialogWindow = getDialog().getWindow();
        WindowManager.LayoutParams layoutParams = dialogWindow.getAttributes();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        dialogWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (absolute) {
            if (matchWidth) {
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            } else {
                layoutParams.width = measure(absoluteWidth);
            }
            layoutParams.height = measure(absoluteHeight);
        } else {
            if (matchWidth) {
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            } else {
                layoutParams.width = (int) (dm.widthPixels * width);
            }
            layoutParams.height = (int) (dm.heightPixels * height);
        }

        switch (gravity) {
            case TOP:
                dialogWindow.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                break;
            case MIDDLE:
                dialogWindow.setGravity(Gravity.CENTER);
                break;
            case BOTTOM:
                dialogWindow.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                break;
        }
        dialogWindow.setAttributes(layoutParams);
    }

    private int measure(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
