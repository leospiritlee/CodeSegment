package com.leospiritlee.test.design;

import com.leospiritlee.design.Singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Project: CodeSegment
 * @ClassName SingletonTest
 * @description: 单例测试
 * @author: leospiritlee
 * @create: 2020-03-31 20:15
 **/
public class SingletonTest {

    public static void main(String[] args) {
        try {
            Singleton singleton1 = Singleton.getInstance();
            FileOutputStream fos = new FileOutputStream("singleton.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(Singleton.getInstance());

            FileInputStream fis = new FileInputStream("singleton.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fis);

            /**
             * 违反了单例设计模式
             */
            Singleton singleton2 = (Singleton) inputStream.readObject();

            outputStream.close();
            inputStream.close();

            System.out.println("singleton1:" + singleton1);
            System.out.println("singleton2:" + singleton2);

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
