package wst.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	private WebView contentWebView = null;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		contentWebView = (WebView) findViewById(R.id.webview);
		// ����javascript
		contentWebView.getSettings().setJavaScriptEnabled(true);
		// ������˸���ͼƬ����վ
		contentWebView.loadUrl("http://www.image.baidu.com/");
		// ���js�����ӿ��࣬������� imagelistner
		contentWebView.addJavascriptInterface(new JavascriptInterface(this), "imagelistner");
		contentWebView.setWebViewClient(new MyWebViewClient());

	}

	// ע��js��������
	private void addImageClickListner() {
		// ���js�����Ĺ��ܾ��ǣ��������е�img���㣬�����onclick�������ڻ���ִ�е�ʱ����ñ��ؽӿڴ���url��ȥ
		contentWebView.loadUrl("javascript:(function(){" +
		"var objs = document.getElementsByTagName(\"img\"); " + 
				"for(var i=0;i<objs.length;i++)  " + 
		"{"
				+ "    objs[i].onclick=function()  " + 
		"    {  " 
				+ "        window.imagelistner.openImage(this.src);  " + 
		"    }  " + 
		"}" + 
		"})()");
	}

	// jsͨ�Žӿ�
	public class JavascriptInterface {

		private Context context;

		public JavascriptInterface(Context context) {
			this.context = context;
		}

		public void openImage(String img) {
			System.out.println(img);
			//
			Intent intent = new Intent();
			intent.putExtra("image", img);
			intent.setClass(context, ShowWebImageActivity.class);
			context.startActivity(intent);
			System.out.println(img);
		}
	}

	// ����
	private class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			return super.shouldOverrideUrlLoading(view, url);
		}

		@Override
		public void onPageFinished(WebView view, String url) {

			view.getSettings().setJavaScriptEnabled(true);

			super.onPageFinished(view, url);
			// html�������֮����Ӽ���ͼƬ�ĵ��js����
			addImageClickListner();

		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			view.getSettings().setJavaScriptEnabled(true);

			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

			super.onReceivedError(view, errorCode, description, failingUrl);

		}
	}

}