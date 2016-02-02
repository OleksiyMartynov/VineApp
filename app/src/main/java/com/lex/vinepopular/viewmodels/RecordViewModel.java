package com.lex.vinepopular.viewmodels;

import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;

import com.lex.vinepopular.models.PopularVidsModel;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public class RecordViewModel {
    public ObservableField<PopularVidsModel.Record> recordModel = new ObservableField<>();

    public RecordViewModel(PopularVidsModel.Record r) {
        recordModel.set(r);
    }

    public void onClick(View view) {
        Toast.makeText(view.getContext(), recordModel.get().username, Toast.LENGTH_SHORT).show();
    }
}
