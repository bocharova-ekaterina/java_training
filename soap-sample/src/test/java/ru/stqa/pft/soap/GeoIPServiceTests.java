package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIPServiceTests {

    @Test
    public void testMyIP(){
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("5.166.74.134");
        System.out.println(ipLocation);
    }
}
