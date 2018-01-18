package com.deilsky.conciseDialogSimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.deilsky.conciseDialog.ConciseDialog;


public class MainActivity extends AppCompatActivity {
    private TextView title, yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                        .gravity(ConciseDialog.DialogGravity.BOTTOM)
                        .height(0.8)//高度 百分比
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
                        .height(0.8)//高度 百分比
                        .width(0.8)
                        .show(MainActivity.this.getFragmentManager(), "test1");
            }
        });
    }

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
}
