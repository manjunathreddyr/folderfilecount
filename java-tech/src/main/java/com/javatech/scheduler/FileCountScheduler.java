package com.javatech.scheduler;

import com.javatech.model.FileDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author MANJUNATH REDDY R on 16-09-2022
 * @project java-tech
 */

@Component
public class FileCountScheduler {

    @Value("${javatech.folders.path}")
    private String folderPath;

    @Value("${javatech.folders.thread.no}")
    private int threadCount;

    @Scheduled(fixedRate = 60_000)
    public void fileCount(){
       List<String> folderPathList = Arrays.asList(folderPath.split(","));

       ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        Map<String, Future<FileDetails>> hashMap = new ConcurrentHashMap<>();
       folderPathList.stream().forEach(path -> {
         Future<FileDetails> detailsFuture =  executorService.submit(new FolderCountRunnable(path));
           hashMap.put(path,detailsFuture);
       });

        hashMap.entrySet().stream().forEach(entry ->{
            try {
                FileDetails details = entry.getValue().get();
                System.out.println(entry.getKey()+" : "+
                        "PendingFileCount: "+details.getPendingFileCount()+
                        " PendingFileCountLessThanThirtyMin: "+details.getPendingFileCountLessThanThirtyMin()+
                        " PendingFileCountLessThanSixtyMin: "+details.getPendingFileCountLessThanSixtyMin()+
                        " PendingFileCountGreaterThanSixtyMin: "+details.getPendingFileCountGreaterThanSixtyMin());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();


    }
}
