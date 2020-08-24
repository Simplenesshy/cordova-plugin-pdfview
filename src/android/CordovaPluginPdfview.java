package com.jdata.nhzhjg.pdf;

import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Iterator;


/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaPluginPdfview extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (action.equals("open")) {
            try {
                String fileName = args.getString(0);
                CordovaResourceApi resourceApi = webView.getResourceApi();
                Uri fileUri = resourceApi.remapUri(Uri.parse(fileName));
                fileName = fileUri.getPath();

                final Intent intent = new Intent().setClass(cordova.getActivity(), Class.forName("com.jdata.nhzhjg.pdf.PdfViewActivity"));
                intent.putExtra("pdfPath", fileName);
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                       cordova.startActivityForResult(CordovaPluginPdfview.this, intent, 1);
                    }
                });
                callbackContext.success("success");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
