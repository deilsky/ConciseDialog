# ConciseDialogSimple
A clean Dialog
# How to
## To get a Git project into your build:
### Step 1. Add the JitPack repository to your build file
#### Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
### Step 2. Add the dependency
```
dependencies {
        compile 'com.github.deilsky:ConciseDialog:v1.1'
}
```
### Step 3. Used
#### Step 3.1 activity_main.xml
```
<TextView
    android:id="@+id/tv_default"
    android:gravity="center"
    android:text="默认 宽度80% 高度30% 居中"
    android:layout_width="match_parent"
    android:layout_height="50dp" />

<TextView
    android:id="@+id/tv_top"
    android:gravity="center"
    android:text="顶部 宽度80% 高度30%"
    android:layout_width="match_parent"
    android:layout_height="50dp" />

<TextView
    android:id="@+id/tv_bottom"
    android:gravity="center"
    android:text="底部 宽度80% 高度30%"
    android:layout_width="match_parent"
    android:layout_height="50dp" />

<TextView
    android:id="@+id/tv_default_match"
    android:gravity="center"
    android:text="默认宽度全屏 高度30% 居中"
    android:layout_width="match_parent"
    android:layout_height="50dp" />

<TextView
    android:id="@+id/tv_top_match"
    android:gravity="center"
    android:text="顶部宽度全屏 高度30%"
    android:layout_width="match_parent"
    android:layout_height="50dp" />

<TextView
    android:id="@+id/tv_bottom_match"
    android:gravity="center"
    android:text="底部宽度全屏 高度30%"
    android:layout_width="match_parent"
    android:layout_height="50dp" />

<TextView
    android:id="@+id/tv_simple"
    android:gravity="center"
    android:text="组合 宽度全屏 高度80dp 居中"
    android:layout_width="match_parent"
    android:layout_height="50dp" />

<TextView
    android:id="@+id/tv_simple2"
    android:gravity="center"
    android:text="组合 宽度150dp 高度 160dp 底部"
    android:layout_width="match_parent"
    android:layout_height="50dp" />
```
#### Step 3.2 nav_dialog.xml
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/chujing_item_root"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/white"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tv_d_title"
        android:layout_alignParentTop="true"
        android:layout_width="match_parent"
        android:layout_height="44dp"
        android:gravity="center"
        android:textStyle="bold" />

    <LinearLayout
        android:layout_alignParentBottom="true"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="44dp"
        android:weightSum="2">

        <TextView
            android:id="@+id/nav_yes"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="match_parent"
            android:gravity="center"
            android:maxLines="1"
            android:layout_marginLeft="15dp"
            android:layout_marginRight="15dp"/>
        <TextView
            android:id="@+id/nav_no"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="match_parent"
            android:gravity="center"
            android:maxLines="1"
            android:layout_marginLeft="15dp"
            android:layout_marginRight="15dp"/>
    </LinearLayout>
</RelativeLayout>
```
#### Step 3.3 代码实现
```
findViewById(R.id.tv_default).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
            @Override
            public void onComplete(View view) {
                initDialogView(view);
            }

            @Override
            public void onError(String e) {

            }
        }).show(MainActivity.this.getFragmentManager(), "test1");
    }
});
findViewById(R.id.tv_top).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
            @Override
            public void onComplete(View view) {
                initDialogView(view);
            }

            @Override
            public void onError(String e) {

            }
        }).gravity(ConciseDialog.DialogGravity.TOP).show(MainActivity.this.getFragmentManager(), "test1");
    }
});
findViewById(R.id.tv_bottom).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
            @Override
            public void onComplete(View view) {
                initDialogView(view);
            }

            @Override
            public void onError(String e) {

            }
        }).gravity(ConciseDialog.DialogGravity.BOTTOM).show(MainActivity.this.getFragmentManager(), "test1");
    }
});
findViewById(R.id.tv_default_match).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
            @Override
            public void onComplete(View view) {
                initDialogView(view);
            }

            @Override
            public void onError(String e) {

            }
        }).matchWidth(true).show(MainActivity.this.getFragmentManager(), "test1");
    }
});
findViewById(R.id.tv_top_match).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
            @Override
            public void onComplete(View view) {
                initDialogView(view);
            }

            @Override
            public void onError(String e) {

            }
        }).matchWidth(true).gravity(ConciseDialog.DialogGravity.TOP).show(MainActivity.this.getFragmentManager(), "test1");
    }
});
findViewById(R.id.tv_bottom_match).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
            @Override
            public void onComplete(View view) {
                initDialogView(view);
            }

            @Override
            public void onError(String e) {

            }
        }).matchWidth(true).gravity(ConciseDialog.DialogGravity.BOTTOM).show(MainActivity.this.getFragmentManager(), "test1");
    }
});
findViewById(R.id.tv_simple).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
            @Override
            public void onComplete(View view) {
                initDialogView(view);
            }

            @Override
            public void onError(String e) {

            }
        })
                .matchWidth(true)
                .gravity(ConciseDialog.DialogGravity.MIDDLE)
                .absolute(true)
                .height(80)//高度 百分比
                .show(MainActivity.this.getFragmentManager(), "test1");
    }
});
findViewById(R.id.tv_simple2).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ConciseDialog.newInstance(R.layout.nav_dialog, new ConciseDialog.ReadyListener() {
            @Override
            public void onComplete(View view) {
                initDialogView(view);
            }

            @Override
            public void onError(String e) {

            }
        })
                .gravity(ConciseDialog.DialogGravity.BOTTOM)
                .absolute(true)
                .matchWidth(false)
                .height(160)//高度 百分比
                .width(150)
                .show(MainActivity.this.getFragmentManager(), "test1");
    }
});
private void initDialogView(final View v) {
    title = v.findViewById(R.id.tv_d_title);
    title.setText("测试标题");
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
```
[![](https://jitpack.io/v/deilsky/ConciseDialog.svg)](https://jitpack.io/#deilsky/ConciseDialog)
## 简单封装，适用大多数场合。
## 如有问题，望指正，共勉。
