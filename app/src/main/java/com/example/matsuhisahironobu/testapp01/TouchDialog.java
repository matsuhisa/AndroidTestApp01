package com.example.matsuhisahironobu.testapp01;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class TouchDialog extends DialogFragment {

    /**
     * ダイアログを生成する
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        // AlertDialogのビルダーを利用
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.wording_clickcircle);
        builder.setPositiveButton(android.R.string.ok, null);
        return builder.create();
    }
}
