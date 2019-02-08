package org.vak.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.log4j.net.SyslogAppender;

public class StreamTest implements FunctionalMethod
{
	int data = 0;
	String dataS = "";

	public static void main(String a[])
	{
		new StreamTest().testStream();
		// (1,5,23,7,9,9,5,8,12)
	}

	public void testStream()
	{
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		Stream.of("a1", 34, new StreamTest()).findFirst().ifPresent(System.out::println);

		Stream.of("a1", "b1", "c2", "a2", "c1").sorted().limit(2).forEach(System.out::println);
		StreamTest streamTest = new StreamTest();

		IntStream.range(5, 10).distinct().sorted().forEach(streamTest::add);

		IntStream.range(5, 10).forEach((x) -> this.add(x));

		IntStream.range(5, 10).map(this::add).forEach((data) -> System.out.println("MAP :: " + data));

		IntStream.range(5, 10).map(streamTest::add).forEach((data) -> System.out.println("MAP :: " + data));
		
		IntStream.range(5, 10).mapToObj(streamTest::add).forEach((data) -> System.out.println("MAP :: " + data));
	}

	@Override
	public int add(int i)
	{
		data += i;
		System.out.println("data  :: " + data);
		return data;
	}

	public String makeString(int i)
	{

		dataS.concat(i + "");
		System.out.println("dataS  :: " + dataS);
		return dataS;
	}

}

interface FunctionalMethod
{
	public int add(int i);
}