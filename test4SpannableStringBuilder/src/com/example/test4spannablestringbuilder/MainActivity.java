package com.example.test4spannablestringbuilder;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) findViewById(R.id.text_view);

		SpannableString ss = new SpannableString(
				"��ɫ��绰б��ɾ������ɫ�»���ͼƬ:.��ɫ����1234567890abcdefghijklnopqrstuvwxyz");

		// ����ɫ����ı�
		ss.setSpan(new ForegroundColorSpan(Color.RED), 0, 2,
		// setSpanʱ��Ҫָ���� flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(ǰ�󶼲�����).
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// �ó����ӱ���ı�
		ss.setSpan(new URLSpan("tel:10086"), 2, 5,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// ����ʽ����ı���б�壩
		ss.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 5, 7,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// ��ɾ���߱���ı�
		ss.setSpan(new StrikethroughSpan(), 7, 10,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// ���»��߱���ı�
		ss.setSpan(new UnderlineSpan(), 10, 16,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// ����ɫ���
		ss.setSpan(new ForegroundColorSpan(Color.GREEN), 10, 12,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// ��ȡDrawable��Դ
		Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
		d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
		// ����ImageSpan
		ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
		// ��ImageSpan�滻�ı�
		ss.setSpan(span, 18, 19, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

		// ����ɫ��������ı�
		ss.setSpan(new BackgroundColorSpan(Color.BLUE), 19, 23,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		// ������x�����
		ss.setSpan(new ScaleXSpan(3), 23, 29,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		// ���ϱ������
		ss.setSpan(new SuperscriptSpan(), 29, 35,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		// ���±������
		ss.setSpan(new SubscriptSpan(), 35, 38,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		// ����Դ�С�����
		ss.setSpan(new RelativeSizeSpan(3), 38, 40,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		// many other
		// TODO

		// �ı�����
		tv.setText(ss);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
