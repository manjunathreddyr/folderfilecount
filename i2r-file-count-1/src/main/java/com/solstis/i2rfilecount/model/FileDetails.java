package com.solstis.i2rfilecount.model;

/**
 * @author MANJUNATH REDDY R on 19-09-2022
 * @project i2r-file-count
 */
public class FileDetails {
    private int pendingFileCount;
    private int pendingFileCountLessThanThirtyMin;
    private int pendingFileCountLessThanSixtyMin;
    private int pendingFileCountGreaterThanSixtyMin;

    public int getPendingFileCount() {
        return pendingFileCount;
    }

    public void setPendingFileCount(int pendingFileCount) {
        this.pendingFileCount = pendingFileCount;
    }

    public int getPendingFileCountLessThanThirtyMin() {
        return pendingFileCountLessThanThirtyMin;
    }

    public void setPendingFileCountLessThanThirtyMin(int pendingFileCountLessThanThirtyMin) {
        this.pendingFileCountLessThanThirtyMin = pendingFileCountLessThanThirtyMin;
    }

    public int getPendingFileCountLessThanSixtyMin() {
        return pendingFileCountLessThanSixtyMin;
    }

    public void setPendingFileCountLessThanSixtyMin(int pendingFileCountLessThanSixtyMin) {
        this.pendingFileCountLessThanSixtyMin = pendingFileCountLessThanSixtyMin;
    }

    public int getPendingFileCountGreaterThanSixtyMin() {
        return pendingFileCountGreaterThanSixtyMin;
    }

    public void setPendingFileCountGreaterThanSixtyMin(int pendingFileCountGreaterThanSixtyMin) {
        this.pendingFileCountGreaterThanSixtyMin = pendingFileCountGreaterThanSixtyMin;
    }
}
