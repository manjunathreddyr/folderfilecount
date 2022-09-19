package com.javatech.scheduler;

import com.javatech.model.FileDetails;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author MANJUNATH REDDY R on 16-09-2022
 * @project java-tech
 */
public class FolderCountRunnable implements Callable<FileDetails> {

    private String path;

    public FolderCountRunnable(String path){
       this.path = path;
    }

    @Override
    public FileDetails call() throws Exception {

        Collection<File> fileCollection = FileUtils.listFiles(new File(path),new String[]{"bin","zip"},true);
        seggregateFileByDifferentTimes(fileCollection);
        FileDetails fileDetails = seggregateFileByDifferentTimes(fileCollection);
        return fileDetails;
    }

    private FileDetails seggregateFileByDifferentTimes(Collection<File> fileCollection) {
        FileDetails fileDetails = new FileDetails();
        fileDetails.setPendingFileCount(fileCollection.size());
        fileCollection
                .stream()
                .map(file -> new Date().getTime() - file.lastModified())
                .forEach(diff ->{
                    if (diff <= 30*60*1000){
                        fileDetails.setPendingFileCountLessThanThirtyMin(fileDetails.getPendingFileCountLessThanThirtyMin()+1);

                    }else if (diff > 30*60*1000 && diff <= 60*60*1000){
                      fileDetails.setPendingFileCountLessThanSixtyMin(fileDetails.getPendingFileCountLessThanSixtyMin()+1);
                    }else if(diff > 60*60*1000){
                      fileDetails.setPendingFileCountGreaterThanSixtyMin(fileDetails.getPendingFileCountGreaterThanSixtyMin()+1);
                    }
                });
        return fileDetails;

    }
}
