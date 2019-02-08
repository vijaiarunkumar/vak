package org.vak.online;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetWork
{
	public void getInterfaces()
	{
		try
		{
			Enumeration e = NetworkInterface.getNetworkInterfaces();

			while (e.hasMoreElements())
			{
				NetworkInterface ni = (NetworkInterface) e.nextElement();
				System.out.println("Net interface: " + ni.getName());

				Enumeration e2 = ni.getInetAddresses();

				while (e2.hasMoreElements())
				{
					InetAddress ip = (InetAddress) e2.nextElement();
					System.out.println("IP address: " + ip.toString());
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		NetWork ip = new NetWork();
		ip.getInterfaces();
	}
}
