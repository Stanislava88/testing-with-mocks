//package sms;
//
///**
// * @author Krasimir Raikov(raikov.krasimir@gmail.com)
// */
//public class SampleTest {
//
//    class SMSMessage {
//
//
//    }
//
//    interface Recipient {
//        String name();
//    }
//
//    class SmsRecipient implements Recipient {
//
//        private String personName;
//
//        public SmsRecipient(String personName) {
//
//            this.personName = personName;
//        }
//
//        @Override
//        public String name() {
//            return personName;
//        }
//    }
//
//    interface SmsGateway {
//        void send(SMSMessage message);
//    }
//
//    interface SmsGateway2 {
//        void send(String number, String title, String message);
//    }
//
//    class SmsMessage {
//        public final String number;
//        public final String title;
//        public final String message;
//
//        public SmsMessage(String number, String title, String message) {
//            this.number = number;
//            this.title = title;
//            this.message = message;
//        }
//
//        void send(SmsGateway2 gateway2) {
//
//            gateway2.send(number, title, message);
//        }
//    }
//
//
//}
//