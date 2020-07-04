import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPv4ConverterTest {

    @Test
    @DisplayName("Converter should return correct IPAddress by get-er")
    void test1(){
        //given
        String ipAddress = "89.64.95.67";
        IPv4Converter converter = new IPv4Converter(ipAddress, null);

        //when
        String result = converter.getIpAddress();

        //then
        assertEquals("89.64.95.67", result);
    }

    @Test
    @DisplayName("Converter should return correct SubnetMask by get-er")
    void test2(){
        //given
        String subnetMask = "255.255.255.0";
        IPv4Converter converter = new IPv4Converter(null, subnetMask);

        //when
        String result = converter.getSubnetMask();

        //then
        assertEquals("255.255.255.0", result);
    }

    @Test
    @DisplayName("Converter should return correct Shortened Subnet Mask")
    void test3(){
        //given
        String ipAddress = "89.64.95.67";
        String subnetMask = "255.255.255.0";
        IPv4Converter converter = new IPv4Converter(ipAddress, subnetMask);

        //when
        int result = converter.getShortenedSubnetMask();

        //then
        assertEquals(24, result);
    }

    @Test
    @DisplayName("Converter should return correct Network Address")
    void test4(){
        //given
        String ipAddress = "89.64.95.67";
        String subnetMask = "255.255.255.0";
        IPv4Converter converter = new IPv4Converter(ipAddress, subnetMask);

        //when
        String result = converter.getNetworkAddress();

        //then
        assertEquals("89.64.95.0", result);
    }

    @Test
    @DisplayName("Converter should return correct Broadcast Address")
    void test5(){
        //given
        String ipAddress = "89.64.95.67";
        String subnetMask = "255.255.255.0";
        IPv4Converter converter = new IPv4Converter(ipAddress, subnetMask);

        //when
        String result = converter.getBroadcastAddress();

        //then
        assertEquals("89.64.95.255", result);
    }

    @Test
    @DisplayName("Converter should return correct First Host Address")
    void test6(){
        //given
        String ipAddress = "89.64.95.67";
        String subnetMask = "255.255.255.0";
        IPv4Converter converter = new IPv4Converter(ipAddress, subnetMask);

        //when
        String result = converter.getFirstHostAddress();

        //then
        assertEquals("89.64.95.1", result);
    }

    @Test
    @DisplayName("Converter should return correct Last Host Address")
    void test7(){
        //given
        String ipAddress = "89.64.95.67";
        String subnetMask = "255.255.255.0";
        IPv4Converter converter = new IPv4Converter(ipAddress, subnetMask);

        //when
        String result = converter.getLastHostAddress();

        //then
        assertEquals("89.64.95.254", result);
    }

    @Test
    @DisplayName("Converter should return correct Number Of Hosts Available")
    void test8(){
        //given
        String ipAddress = "89.64.95.67";
        String subnetMask = "255.255.255.0";
        IPv4Converter converter = new IPv4Converter(ipAddress, subnetMask);

        //when
        int result = converter.getNumberOfHostsAvailable();

        //then
        assertEquals(254, result);
    }

    @Test
    @DisplayName("Converter should return True when the IPAddress is correct")
    void test9(){
        //given
        String ipAddress = "89.64.95.67";
        IPv4Converter converter = new IPv4Converter(ipAddress, null);

        //when
        boolean result = converter.verifyInternetAddress(ipAddress);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("Converter should return False when the IPAddress is not correct")
    void test10(){
        //given
        String ipAddress = "89.64.95";
        IPv4Converter converter = new IPv4Converter(ipAddress, null);

        //when
        boolean result = converter.verifyInternetAddress(ipAddress);

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("Converter should return True when the Subnet Mask is correct")
    void test11(){
        //given
        String subnetMask = "255.255.255.0";
        IPv4Converter converter = new IPv4Converter(subnetMask, null);

        //when
        boolean result = converter.verifyInternetAddress(subnetMask);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("Converter should return False when the Subnet Mask is not correct")
    void test12(){
        //given
        String subnetMask = "255.255.255";
        IPv4Converter converter = new IPv4Converter(subnetMask, null);

        //when
        boolean result = converter.verifyInternetAddress(subnetMask);

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("Converter should return true when String contain numbers")
    void test13(){
        //given
        String number = "255";
        IPv4Converter converter = new IPv4Converter(number, null);

        //when
        boolean result = converter.ifStringIsAMaximum3DigitNumber(number);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("Converter should return false when String not contain numbers")
    void test14(){
        //given
        String word = "some_words";
        IPv4Converter converter = new IPv4Converter(word, null);

        //when
        boolean result = converter.ifStringIsAMaximum3DigitNumber(word);

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("NetworkAddress should not be available when IPAddress and SubnetMask are invalid")
    void test15(){
        //given
        String ipAddress = "1";
        String subnetMaskAddress = "2";
        IPv4Converter iPv4Converter = new IPv4Converter(ipAddress, subnetMaskAddress);

        //when
        String result = iPv4Converter.getNetworkAddress();

        //then
        assertEquals("invalid addresses!", result);
    }

    @Test
    @DisplayName("BroadcastAddress should not be available when IPAddress and SubnetMask are invalid")
    void test16(){
        //given
        String ipAddress = "1";
        String subnetMaskAddress = "2";
        IPv4Converter iPv4Converter = new IPv4Converter(ipAddress, subnetMaskAddress);

        //when
        String result = iPv4Converter.getBroadcastAddress();

        //then
        assertEquals("invalid addresses!", result);
    }

    @Test
    @DisplayName("FirstHostAddress should not be available when IPAddress and SubnetMask are invalid")
    void test17(){
        //given
        String ipAddress = "1";
        String subnetMaskAddress = "2";
        IPv4Converter iPv4Converter = new IPv4Converter(ipAddress, subnetMaskAddress);

        //when
        String result = iPv4Converter.getFirstHostAddress();

        //then
        assertEquals("invalid addresses!", result);
    }

    @Test
    @DisplayName("LastHostAddress should not be available when IPAddress and SubnetMask are invalid")
    void test18(){
        //given
        String ipAddress = "1";
        String subnetMaskAddress = "2";
        IPv4Converter iPv4Converter = new IPv4Converter(ipAddress, subnetMaskAddress);

        //when
        String result = iPv4Converter.getLastHostAddress();

        //then
        assertEquals("invalid addresses!", result);
    }

    @Test
    @DisplayName("NumberOfHostsAvailable should not be available when IPAddress and SubnetMask are invalid")
    void test19(){
        //given
        String ipAddress = "1";
        String subnetMaskAddress = "2";
        IPv4Converter iPv4Converter = new IPv4Converter(ipAddress, subnetMaskAddress);

        //when
        int result = iPv4Converter.getNumberOfHostsAvailable();

        //then
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("ShortenedSubnetMask should not be available when IPAddress and SubnetMask are invalid")
    void test20(){
        //given
        String ipAddress = "1";
        String subnetMaskAddress = "2";
        IPv4Converter iPv4Converter = new IPv4Converter(ipAddress, subnetMaskAddress);

        //when
        int result = iPv4Converter.getShortenedSubnetMask();

        //then
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("IpAddress should not be available when IPAddress and SubnetMask are invalid")
    void test21(){
        //given
        String ipAddress = "1";
        String subnetMaskAddress = "2";
        IPv4Converter iPv4Converter = new IPv4Converter(ipAddress, subnetMaskAddress);

        //when
        String result = iPv4Converter.getIpAddress();

        //then
        assertEquals("invalid addresses!", result);
    }

    @Test
    @DisplayName("SubnetMask should not be available when IPAddress and SubnetMask are invalid")
    void test22(){
        //given
        String ipAddress = "1";
        String subnetMaskAddress = "2";
        IPv4Converter iPv4Converter = new IPv4Converter(ipAddress, subnetMaskAddress);

        //when
        String result = iPv4Converter.getSubnetMask();

        //then
        assertEquals("invalid addresses!", result);
    }

    @Test
    @DisplayName("Converter should not allow more then 3 decimal digits in word")
    void test23(){
        //given
        String ipAddress = "1921";
        IPv4Converter iPv4Converter = new IPv4Converter(null, null);

        //when
        boolean result = iPv4Converter.ifStringIsAMaximum3DigitNumber(ipAddress);

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("Converter should not allow more then 3 decimal digits in IPAddress octet")
    void test24(){
        //given
        String ipAddress = "1921.167.10.123";
        IPv4Converter iPv4Converter = new IPv4Converter(null, null);

        //when
        boolean result = iPv4Converter.verifyInternetAddress(ipAddress);

        //then
        assertFalse(result);
    }
}