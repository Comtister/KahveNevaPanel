package org.oguzhanozturk.kahvenevapanel.interfaces;

import org.oguzhanozturk.kahvenevapanel.models.Teller;

public interface FirestoreManagerInterface {

    void saveAccountFirestore(Teller teller,AuthProcessListener authProcessListener);

}
