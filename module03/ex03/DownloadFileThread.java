package module03.ex03;

import java.nio.channels.*;
import java.io.*;
import java.net.*;

public class DownloadFileThread implements Runnable {
    private String url;
    int count;

    public DownloadFileThread(String url, int count) {
        this.url = url;
        this.count = count;
    }

    public void downloadFiles() throws Exception {
        boolean dir = new File("./downloads").mkdirs();
        URI uri = new URI(this.url);
        URL fileWebsite = uri.toURL();
        ReadableByteChannel readableByteChannel = Channels.newChannel(fileWebsite.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream("./downloads/url" + count);
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        fileOutputStream.close();
    }

    @Override
    public void run() {
        System.out.println(
                "Thread-" + Thread.currentThread().getName().substring(Thread.currentThread().getName().length() - 1)
                        + " start download file number " + count);
        try {
            downloadFiles();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(
                "Thread-" + Thread.currentThread().getName().substring(Thread.currentThread().getName().length() - 1)
                        + " finish download file number " + count);
    }

}
