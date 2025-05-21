package com.daebecodin.mdt.data;


public abstract class DataLoader {
    /**
     * this will be used to load our starter data
     */
    public abstract void loadMarkDownSpecificData();

    /**
     * loads application wide data
     */
    public void loadData() {
        loadCommonMarkDownTownData();
        loadMarkDownSpecificData();
    }

    /**
     * loads data common to mark down town
     */
    public void loadCommonMarkDownTownData() {}


}