package com.android_note.util_code.span_util;

import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;
import com.blankj.utilcode.util.SpanUtils;

/**
 * with              : 设置控件
 * setFlag           : 设置标识
 * setForegroundColor: 设置前景色(字体颜色)
 * setBackgroundColor: 设置背景色
 * setLineHeight     : 设置行高
 * setQuoteColor     : 设置引用线的颜色
 * setLeadingMargin  : 设置缩进
 * setBullet         : 设置列表标记
 * setFontSize       : 设置字体尺寸
 * setFontProportion : 设置字体比例
 * setFontXProportion: 设置字体横向比例
 * setStrikethrough  : 设置删除线
 * setUnderline      : 设置下划线
 * setSuperscript    : 设置上标
 * setSubscript      : 设置下标
 * setBold           : 设置粗体
 * setItalic         : 设置斜体
 * setBoldItalic     : 设置粗斜体
 * setFontFamily     : 设置字体系列
 * setTypeface       : 设置字体
 * setAlign          : 设置对齐
 * setClickSpan      : 设置点击事件
 * setUrl            : 设置超链接
 * setBlur           : 设置模糊
 * setShader         : 设置着色器
 * setShadow         : 设置阴影
 * setSpans          : 设置样式
 * append            : 追加样式字符串
 * appendLine        : 追加一行样式字符串
 * appendImage       : 追加图片
 * appendSpace       : 追加空白
 * create            : 创建样式字符串
 */

public class SpanUtilActivity extends AppCompatActivity {

    private int lineHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span_util);
        initView();
        initHtmlText();
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(@NonNull View widget) {
            Toast.makeText(SpanUtilActivity.this, "点了我", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(getResources().getColor(R.color.color_Blue));
            ds.linkColor = getResources().getColor(R.color.color_White);
            ds.setUnderlineText(false);
        }
    };

    private void initView() {
        TextView tvCommonSpan = findViewById(R.id.tv_common_span);
        tvCommonSpan.setHighlightColor(getResources().getColor(R.color.transparent));
        lineHeight = tvCommonSpan.getLineHeight();
        SpanUtils.with(tvCommonSpan)
                .appendLine("SpanUtil样式").setBackgroundColor(getResources().getColor(R.color.color_Yellow)).setHorizontalAlign(Layout.Alignment.ALIGN_CENTER)
                .appendLine("设置前景色").setForegroundColor(getResources().getColor(R.color.color_Green))
                .appendLine("设置背景色").setBackgroundColor(getResources().getColor(R.color.color_Blue)).setForegroundColor(getResources().getColor(R.color.color_White))
                .appendLine("设置行高").setLineHeight(2*lineHeight,SpanUtils.ALIGN_TOP).setBackgroundColor(getResources().getColor(R.color.color_orange))
                .appendLine("设置行高,字体居中显示").setLineHeight(2*lineHeight,SpanUtils.ALIGN_CENTER).setBackgroundColor(getResources().getColor(R.color.color_Red))
                .appendLine("字体底部对齐显示").setLineHeight(2*lineHeight,SpanUtils.ALIGN_BOTTOM).setBackgroundColor(getResources().getColor(R.color.color_Yellow))
                .append("大字体").setForegroundColor(getResources().getColor(R.color.color_Black)).setFontSize(18,true).append("小字体").setForegroundColor(getResources().getColor(R.color.color_Blue)).setFontSize(14,true)
                .appendLine("中字号").setFontSize(16,true)
                .appendLine("设置引用线的颜色").setQuoteColor(getResources().getColor(R.color.color_Green),5,10)
                .appendLine("设置列表标记").setBullet(getResources().getColor(R.color.color_Green),10,10)
                .appendLine("设置删除线").setStrikethrough()
                .appendLine("设置下划线").setUnderline()
                .append("设置上标").appendLine("上标").setSuperscript()
                .append("设置下标").appendLine("下标").setSubscript()
                .append("点击测试").appendLine("点击事件").setClickSpan(clickableSpan)
                .create();
    }

    private void initHtmlText(){
        TextView tvCommonHtml = findViewById(R.id.tv_common_html);
        /*字体大小无法通过size来实现只能<big> 和 <small>*/
        //String commonText = "<font color=\'#217aff\' ><big>3.07</big></font><font color=\'#ff0606\' ><small>万元</small></font>";
        //String commonText = "<font color='#217aff'>" +"<big>"+ 3.07 + "</big>" + "</font>"+"<font color='#ff0606'>" +"<small>"+ "万元" + "</small>" + "</font>";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<font color='#217aff'>").append("<big>").append(3.07)
                    .append("</big>").append("</font>").append("<font color='#ff0606'>").append("<small>").append("万元").append("</small>").append("</font>");
        tvCommonHtml.setText(Html.fromHtml(stringBuffer.toString()));
    }

}
