package com.android.a19145369getpagesource;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

public class SourceCodeLoader extends AsyncTaskLoader<String> {
    private String mQueryString;
    private String mTransferProtocol;
    Context mContext;

    public SourceCodeLoader(@NonNull Context context, String queryString, String transferProtocol) {
        super(context);
        mContext = context;
        mQueryString = queryString;
        mTransferProtocol = transferProtocol;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getSourceCode(mContext, mQueryString, mTransferProtocol);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}