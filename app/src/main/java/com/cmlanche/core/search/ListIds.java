package com.cmlanche.core.search;

import android.graphics.Rect;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;

import com.cmlanche.application.MyApplication;
import com.cmlanche.core.search.node.Dumper;
import com.cmlanche.core.search.node.NodeInfo;
import com.cmlanche.core.search.node.TreeInfo;
import com.cmlanche.core.utils.Utils;

public class ListIds {
    
    private static final String TAG  = ListIds.class.getSimpleName();

    public static void list() {
        listByRect(null);
    }

    public static void listByRect(Rect region) {
        AccessibilityNodeInfo[] roots = MyApplication.getAppInstance().getAccessbilityService().getRoots();
        if (roots == null) {
            Log.i(TAG, "roots is null.");
        }

        Log.i(TAG, "roots size: " + roots.length);
        if (region != null) {
            Log.d(TAG, "list: region: " + region);
        }
        for (int i = 0; i < roots.length; i++) {
            AccessibilityNodeInfo root = roots[i];
            if (root != null) {
                Log.i(TAG, String.format("%d. root package: %s", i + 1, Utils.getRootPackageName(root)));
            } else {
                Log.e(TAG, "error: root is null, index: " + i);
            }
        }

        TreeInfo treeInfo = new Dumper(roots).dump();

        if (treeInfo != null && treeInfo.getRects() != null) {
            for (NodeInfo rect : treeInfo.getRects()) {
                Rect rect1 = rect.getRect();
                if(region!=null && !region.contains(rect1)){
                    continue;
                }
                Log.d(TAG, "list: id: " + rect.getId());
                Log.d(TAG, "list: getVisiableRect: " + rect.getVisiableRect());
                Log.d(TAG, "list: getRect: " + rect.getRect());
                Log.d(TAG, "list: getText: " + rect.getText());
                Log.d(TAG, "list: getClassName: " + rect.getClassName());
                Log.d(TAG, "list: xpath: " + rect.getXpath());
                Log.d(TAG, "---------------");
            }
        }
    }
}
