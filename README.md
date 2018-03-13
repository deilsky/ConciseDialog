# ConciseDialogSimple
A clean Dialog
# How to user ?
## first
  compile 'com.deilsky:ConciseDialog:1.0.6'
## second
```
  private void initDialogView(final View v, String str) {
        title = v.findViewById(R.id.tv_d_title);
        title.setText(str);
        yes = v.findViewById(R.id.nav_yes);
        yes.setText("是");
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "是", Toast.LENGTH_SHORT).show();
            }
        });
        no = v.findViewById(R.id.nav_no);
        no.setText("否");
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "否", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //R.layout.nav_dialog 此dialog 的layout
    ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
      @Override
      public void onComplete(View view) {
        //初始化成功，收到回调
        initDialogView(view, "默认");
      }
      @Override
      public void onError(String e) {}
    })
      .gravity(ConciseDialog.DialogGravity.BOTTOM)//显示位置 默认居中
      .matchWidth(true)//宽度是否全屏
      .height(0.5)//高度 屏幕高度10
      .show(MainActivity.this.getFragmentManager(), "test1");
```
## 简单封装，适用大多数场合。
## 如有问题，望指正，共勉。
