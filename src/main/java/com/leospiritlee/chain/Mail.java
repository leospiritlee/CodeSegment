package com.leospiritlee.chain;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * @Project: CodeSegment
 * @ClassName Mail
 * @description: 邮件主题
 * @author: leospiritlee
 * @create: 2020-04-07 20:57
 **/
public class Mail {

    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;

    Scannability scannability;

    Readability readability;

    Address address;

    ReturnAddress returnAddress;

    static long count = 0;
    long id = count++;


    /**
     *  生成邮件主题
     * @return
     */
    public static Mail randomMail(){
        Mail mail = new Mail();

        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);

        return mail;
    }


    public static Iterable<Mail> generator(final int count){
        return new Iterable<Mail>() {

            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n --> 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }


    /**
     *  邮件明细
     * @return
     */
    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scanability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }

    @Override
    public String toString() {
        return "Mail{"+id+"}";
    }



}
