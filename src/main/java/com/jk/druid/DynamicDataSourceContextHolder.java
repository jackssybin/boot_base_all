package com.jk.druid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DynamicDataSourceContextHolder {
        private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

        private static Lock lock = new ReentrantLock();

        private static int counter = 0;

        /**
         * Maintain variable for every thread, to avoid effect other thread
         */
        private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceEnum.base::name);


        /**
         * All DynamicDataSource List
         */
        public static List<Object> firstdataSourceKeys = new ArrayList<>();

        /**
         * The constant secondDataSourceKeys.
         */
        public static List<Object> secondDataSourceKeys = new ArrayList<>();

        /**
         * To switch DynamicDataSource
         *
         * @param key the key
         */
        public static void setDataSourceKey(String key) {
            CONTEXT_HOLDER.set(key);
        }

        /**
         * Use master data source.
         */
        public static void useBaseDataSource() {
            CONTEXT_HOLDER.set(DataSourceEnum.base.name());
        }

        /**
         * Use slave data source.
         */
        public static void useInfoDataSource() {
            lock.lock();

            try {
                int datasourceKeyIndex = counter % secondDataSourceKeys.size();
                CONTEXT_HOLDER.set(String.valueOf(secondDataSourceKeys.get(datasourceKeyIndex)));
                counter++;
            } catch (Exception e) {
                logger.error("Switch slave datasource failed, error message is {}", e.getMessage());
                useBaseDataSource();
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * Get current DynamicDataSource
         *
         * @return data source key
         */
        public static String getDataSourceKey() {
            return CONTEXT_HOLDER.get();
        }

        /**
         * To set DynamicDataSource as default
         */
        public static void clearDataSourceKey() {
            CONTEXT_HOLDER.remove();
        }

        /**
         * Check if give DynamicDataSource is in current DynamicDataSource list
         *
         * @param key the key
         * @return boolean boolean
         */
        public static boolean containDataSourceKey(String key) {
            return firstdataSourceKeys.contains(key);
        }
}
