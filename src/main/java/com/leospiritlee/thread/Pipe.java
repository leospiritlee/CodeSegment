package com.leospiritlee.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.TimeUnit;

/**
 * @Project: CodeSegment
 * @ClassName Pipe
 * @description: 管道流
 * @author: leospiritlee
 * @create: 2020-06-20 16:52
 **/
public class Pipe {

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();

        writer.connect(reader);

        new Thread(new ReaderThread(reader)).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new WriterThread(writer)).start();
    }

    static class ReaderThread implements Runnable{

        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("This is reader");
            int receive = 0;
            try{
                while ((receive = reader.read()) != -1) {
                    System.out.print((char)receive);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable{

        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("This is writer");
            int receive = 0;

            try{
                writer.write("test");
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try{
                    writer.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
