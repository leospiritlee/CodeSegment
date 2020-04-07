package com.leospiritlee.chain;

import java.util.Arrays;

/**
 * @Project: CodeSegment
 * @ClassName PostOffice
 * @description: 邮局模式责任链
 * @author: leospiritlee
 * @create: 2020-04-07 20:56
 **/
public class PostOffice {

    /**
     *  邮件处理handler
     */
    enum MailHandler{

        GENERAL_DELIVERY{
            @Override
            boolean handler(Mail mail) {
                switch (mail.generalDelivery){
                    case YES:
                        System.out.println("Using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },

        MACHINE_SCAN {
            @Override
            boolean handler(Mail mail) {
                switch (mail.scannability){
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (mail.address){
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " automatically");
                                return true;
                        }
                }
            }
        },

        VISUAL_INSPECTION{
            @Override
            boolean handler(Mail mail) {
               switch (mail.readability){
                   case ILLEGIBLE:
                       return false;
                   default:
                       switch (mail.address){
                           case INCORRECT:
                               return false;
                           default:
                               System.out.println("Delivering " + mail + " normally");
                               return true;
                       }
               }
            }
        },

        RETURN_TO_SENDER{
            @Override
            boolean handler(Mail mail) {
                switch (mail.returnAddress){
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + mail + " to sender");
                        return true;
                }
            }
        },
        ;

        abstract boolean handler(Mail mail);
    }


    public static void handle(Mail mail){
        for (MailHandler mailHandler : MailHandler.values()) {
            if (mailHandler.handler(mail)) {
               return;
            }
        }

        System.out.println(mail + " is a dead letter");
    }


    public static void main(String[] args) {
        Mail.generator(10).forEach(mail -> {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*******************");
        });
    }
}
