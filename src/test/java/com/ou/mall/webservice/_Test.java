package com.ou.mall.webservice;

import java.util.List;

import com.ou.mall.webservice.ip.IpAddressSearchWebService;
import com.ou.mall.webservice.ip.IpAddressSearchWebServiceSoap;
import com.ou.mall.webservice.weather.ArrayOfString;
import com.ou.mall.webservice.weather.WeatherWS;
import com.ou.mall.webservice.weather.WeatherWSSoap;

public class _Test {
	public static void main(String[] args) {
		IpAddressSearchWebService ipWS = new IpAddressSearchWebService();
		IpAddressSearchWebServiceSoap ipSOAP = ipWS.getIpAddressSearchWebServiceSoap();
		
		WeatherWS weatherWS = new WeatherWS();
		WeatherWSSoap weatherSOAP = weatherWS.getWeatherWSSoap();
		
//		String address = "58.20.17.245";
//		String city = ipSOAP.getCountryCityByIp (address).getString().get(1).substring(0, 2);

		List<String> provinces = weatherSOAP.getRegionProvince().getString();
		for (String t : provinces){
//			if (city.equals(t.substring(0, 2))){
//				System.out.println(t);
//			}
			System.out.println(t);
		}
		System.out.println(provinces);

	}
}
