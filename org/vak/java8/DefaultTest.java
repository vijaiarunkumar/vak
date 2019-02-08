package org.vak.java8;

public class DefaultTest
{
	public static void main(String a[])
	{
		DefaultImplClass defaultImplClass = null;

		defaultImplClass.defaultTest();
		defaultImplClass.staticTest();

	}
}

interface TestDefault
{
	void test();

	default void defaultTest()
	{
		System.out.println("Single Default");
	}

	static void staticTest()
	{
		System.out.println("Interface Static test ");
	}
}

interface TestDefaultOne
{
	void test();

	default void defaultTest()
	{
		System.out.println("Single Default");
	}

	public static void staticTest()
	{
		System.out.println("Interface Static test ");
	}
}

class DefaultImplClass implements TestDefault, TestDefaultOne
{

	@Override
	public void test()
	{
		System.out.println("Test method Override form class");
	}

	@Override
	public void defaultTest()
	{
		TestDefault.super.defaultTest();
	}
	
	public static void staticTest()
	{
		System.out.println("Interface Static test ");
	}

}
