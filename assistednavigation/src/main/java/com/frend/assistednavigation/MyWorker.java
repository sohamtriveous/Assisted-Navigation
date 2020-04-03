package com.frend.assistednavigation;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    Context context;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        Data data = getInputData();
        String[] strings = data.getStringArray(CustomAssistant.KEY_WORK_INPUT);
        assert strings != null;
        for (String s : strings) {
            if(s!=null)
                download(s);
        }
        return Result.success();
    }

    private void download(String url) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle("Download");

        File file = new File(Environment.getDataDirectory() + "/InternetSaathi");
        if (!file.exists())
            file.mkdirs();

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        String fileName = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
        if (!isFileDownloaded(fileName)) {
            request.setDestinationInExternalPublicDir("/InternetSaathi", fileName);
            DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            downloadManager.enqueue(request);
        }
    }

    private boolean isFileDownloaded(String fileName) {

        if (fileName != null && !TextUtils.isEmpty(fileName)) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/InternetSaathi/" + fileName);
            Log.d("GFG", "isFileDownloaded: " + file.exists());
            return file.exists();
        }
        return false;
    }
}
