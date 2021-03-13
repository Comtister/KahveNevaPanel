package org.oguzhanozturk.kahvenevapanel.interfaces;

import org.oguzhanozturk.kahvenevapanel.constants.NetworkError;

public interface AuthProcessListener {

    void onSucces();
    void onFailure(NetworkError error);

}
