package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wayne on 2017/8/31.
 */
public class StreamsPrac {

    private static final String[] strs = new String[]{"apple", "pear", "orange"};
    private List<String> stringList = new ArrayList<>();

    public void init() {
        stringList.add("phone");
        stringList.add("phoneb");
        stringList.add("");
        stringList.add("phoneb");
        stringList.add("phonec");
        stringList.add("penc");
    }

    public void fromString() {
        Stream<String> stream = Arrays.stream(strs);
        Stream<String> streamb = Stream.of("jack", "tom", "zero");

        Stream<String> streamc = stringList.stream();
        //parallelStream() allows to run method doWork() in parallel for every element of the stream
        Stream<String> streamPa = stringList.parallelStream();
        System.out.println("distinct elem in stringList is: " + streamPa.distinct().count());
    }

    public void operation() {

        // iterate
        boolean isPhonecExist = stringList.stream().anyMatch(element -> element.contains("phonec"));
        System.out.println(isPhonecExist);

        // filter
        Stream<String> streamFilterd = stringList.stream().filter(element -> element.contains("c"));
        System.out.println(streamFilterd.count());

        // map
        Stream<Integer> strsLength = stringList.stream().map(element -> element.length());
        System.out.println(strsLength.toArray()[0]);

        // flatmap
        List<Detail> details = new ArrayList<>();
        details.add(new Detail());
        details.add(new Detail());
        Stream<String> logos = details.stream().flatMap(detail -> detail.getParts().stream());
//        System.out.println(logos.toArray()[4]);

        // reduce
        List<Integer> nums = Arrays.asList(23,3,93,64,34);
        Integer sum = nums.stream().reduce(1000, (a,b) -> a + b);
        System.out.println(sum);

        // collect
        List<String> logoStrs = logos.map( e -> e.toUpperCase())
                                    .collect(Collectors.toList());
        System.out.println(logoStrs.get(1));

        // reference to the instance method
        long count = stringList.stream().filter(String::isEmpty).count();
        System.out.println(count);
    }

    public static void main(String[] args) {
        StreamsPrac sp = new StreamsPrac();
        sp.init();
//        sp.fromString();
        sp.operation();
    }

    private class Detail {

        public List<String> getParts() {
            return parts;
        }

        private List<String> parts = new ArrayList<>();

        public Detail() {
            this.parts.add("apple");
            this.parts.add("huawei");
            this.parts.add("vivo");
        }

    }
}
