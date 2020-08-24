package com.jdata.nhzhjg.pdf;


import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.jdata.nhzhjg.wgy.R;


import org.apache.cordova.CordovaActivity;

import java.io.File;

public class PdfViewActivity extends CordovaActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        PDFView pdfView = findViewById(R.id.pdfView);

        String filePath = getIntent().getStringExtra("pdfPath");

        if (null != filePath) {
            File file = new File(filePath);
            if (file.exists()) {
                pdfView.fromFile(file) //设置pdf文件地址
                        .defaultPage(0) //设置默认显示第1页
                        //.onPageChange(PdfActivity.this) //设置翻页监听
                        //.onLoad(this) //设置加载监听
                        //.onDraw(this)//绘图监听
                        .enableSwipe(true) //是否允许翻页，默认是允许翻页
                        .load();
            }
        }

    }
}