package com.example.aldo.robotiumtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.webkit.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webview = (WebView) view.findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String summary = "<html><head></head><body>" +
                "<input type=\"text\" id=\"aldo\"/>" +
                "<input type=\"button\" id=\"click\" value=\"testing\"/>" +
                "</body></html>";
        webview.loadData(summary, "text/html", null);
    }
}
