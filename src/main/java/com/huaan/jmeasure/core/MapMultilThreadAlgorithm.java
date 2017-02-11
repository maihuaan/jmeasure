package com.huaan.jmeasure.core;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mai on 2017/2/11 0011.
 * 固定时间内内运行任务：http://stackoverflow.com/questions/2275443/how-to-timeout-a-thread
 */
public class MapMultilThreadAlgorithm implements IAlgorithm {
    private static Map<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
    private static Map<String, String> synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, String>());
    public Result run() {
        Result r = new Result("性能对比");
        initXaxis(r.getxAxisMap());

        doRun("ConcurrentMap", concurrentHashMap, r);
        doRun("SynchronizedHashMap", synchronizedHashMap, r);
        normalization(r);
        return r;

    }

    /**
     * 归一化：线程消耗时间 t(1个线程)/t(n个线程)
     * @param result
     */
    private void normalization(Result result)
    {
        List<TesterData> testers = result.getTesters();
        for (TesterData testData : testers)
        {
            List<Double> notNorms = testData.getyValue();
            Double oneThreadTime = notNorms.get(0);
            List<Double> norms = new ArrayList<Double>();
            for (Double d : notNorms)
            {
                double norm = oneThreadTime / d;
                norms.add(norm);
            }
            testData.setyValue(norms);

        }

    }

    private void doRun(String name, Map<String, String> map, Result r) {
        TesterData testerData = new TesterData(name);
        for (Map.Entry<Integer, String> xAxis : r.getxAxisMap().entrySet())
        {
            int threads = xAxis.getKey();
            long elapsed = runTime(threads, map);
            testerData.getyValue().add((double) elapsed);
        }
        r.getTesters().add(testerData);
    }

    private long runTime(int threads, Map<String, String> map) {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        List<Future<Long>> futures = new ArrayList<Future<Long>>();
        AtomicInteger atomicInteger = new AtomicInteger(2000000);
        for (int i = 0; i < threads; i++)
        {
            Future<Long> future = executor.submit(new Task(map, atomicInteger));
            futures.add(future);
        }
        long times = 0;
        for (int i = 0; i < threads; i++)
        {
            try {
                long iTime = futures.get(i).get();
                if (iTime > times)
                {
                    times = iTime;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        return times;

    }

    class Task implements Callable<Long> {
        private Map<String, String> map;
        private AtomicInteger atomicInteger;

        public Task(Map<String, String> map, AtomicInteger atomicInteger) {
            this.map = map;
            this.atomicInteger = atomicInteger;
        }

        @Override
        public Long call() throws Exception {
            //start
            long lStartTime = System.nanoTime();
            while (atomicInteger.get() > 0)
            {
                randomAccess(map);
                atomicInteger.getAndDecrement();
            }
            //end
            long lEndTime = System.nanoTime();

            //time elapsed
            long output = lEndTime - lStartTime;
            return output;
        }
    }

    private void randomAccess(Map<String, String> map)
    {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        final Integer key = tlr.nextInt(0, Integer.MAX_VALUE);
        if (map.containsKey(key))
        {
            int ran = tlr.nextInt(0, 100);
            // 0.02的机会会删掉这个值
            if (ran < 2)
            {
                map.remove(key);
            }
        }
        else
        {
            int ran = tlr.nextInt(0, 10);
            // 0.6的机会加入这个值
            if (ran < 6)
            {
                map.put(String.valueOf(ran), String.valueOf(ran));
            }
        }

    }

    private void initXaxis(Map<Integer, String> p) {
        p.put(1, "1");
        p.put(2, "2");
        p.put(4, "4");
        p.put(8, "8");
        p.put(16, "16");
        p.put(32, "32");
        p.put(64, "64");
    }
}
