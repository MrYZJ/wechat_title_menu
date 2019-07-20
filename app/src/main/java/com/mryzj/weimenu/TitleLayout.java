package com.mryzj.weimenu;

import android.app.ActionBar;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


public class TitleLayout extends LinearLayout {

    private Button menuBtn;
    PopupWindow popupWindow;

    public TitleLayout(Context context){
        super(context);
    }
    public TitleLayout(final Context context, AttributeSet attributeSet){
        super(context, attributeSet);

        LayoutInflater.from(context).inflate(R.layout.title, this);
        menuBtn = findViewById(R.id.btn_menu);

        menuBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                // 获取自定义的菜单布局文件
                View popupWindow_view = LayoutInflater.from(context).inflate(R.layout.menu, null,false);
                // 创建PopupWindow实例,设置菜单宽度和高度为包裹其自身内容
                popupWindow = new PopupWindow(popupWindow_view, ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.WRAP_CONTENT, true);
                //设置菜单显示在按钮的下面
                popupWindow.showAsDropDown(findViewById(R.id.btn_menu),0,0);
                // 点击其他地方消失
                popupWindow_view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        //如果菜单存在并且为显示状态，就关闭菜单并初始化菜单
                        if (popupWindow != null && popupWindow.isShowing()) {
                            popupWindow.dismiss();
                            popupWindow = null;
                        }
                        return false;
                    }
                });
            }
        });
    }
}
