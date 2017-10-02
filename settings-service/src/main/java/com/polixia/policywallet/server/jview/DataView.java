package com.polixia.policywallet.server.jview;

public class DataView {
        public interface Specific{

        }
        public interface HSpecific extends Specific{

        }
        public interface Basic extends Specific{
        }

        public interface DataSummary extends ServiceSummary {

        }

        public interface ServiceSummary extends Basic{

        }

        public interface HDataSummary extends Basic,HSpecific {

        }
    }


