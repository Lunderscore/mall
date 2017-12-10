package com.ou.mall.webservice;

import java.util.List;

import com.ou.mall.webservice.ip.ArrayOfString;
import com.ou.mall.webservice.ip.IpAddressSearchWebService;
import com.ou.mall.webservice.ip.IpAddressSearchWebServiceSoap;

public class _TestIP {
	public static void main(String[] args) {
		IpAddressSearchWebService ws = new IpAddressSearchWebService();
		IpAddressSearchWebServiceSoap soap = ws.getIpAddressSearchWebServiceSoap();
		
		List<String> countryCityByIp = soap.getCountryCityByIp("58.20.17.245").getString();
		
		for (String s : countryCityByIp){
			System.out.println(s);
		}
	}
}
