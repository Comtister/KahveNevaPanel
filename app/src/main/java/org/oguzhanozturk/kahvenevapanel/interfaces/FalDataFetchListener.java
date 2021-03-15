package org.oguzhanozturk.kahvenevapanel.interfaces;

import org.oguzhanozturk.kahvenevapanel.models.FalData;

import java.util.ArrayList;

public interface FalDataFetchListener {

    void onSuccesListener(ArrayList<FalData> data);
    void onFailListener(Exception e);

}
