package com.botty.fmpitaly.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.botty.fmpitaly.R;

/**
 * Created by BottyIvan on 01/03/15.
 */
public class Another_Sigma_Frag extends Fragment{

    public WebView mWebView;
    public String url = "";

    public Another_Sigma_Frag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_web, container,
                false);

        mWebView = (WebView) view.findViewById(R.id.homeWeb);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(url);

        return view;
    }
}
