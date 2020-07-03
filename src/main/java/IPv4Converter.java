public class IPv4Converter {

    private final String ipAddress;
    private final String subnetMask;
    private final boolean correctIpAddress;
    private final boolean correctSubnetMask;

    public IPv4Converter(String ipAddress, String subnetMask){
        this.ipAddress = ipAddress;
        this.subnetMask = subnetMask;
        correctIpAddress = verifyInternetAddress(ipAddress);
        correctSubnetMask = verifyInternetAddress(subnetMask);
    }

    public String getNetworkAddress(){
        if(this.correctIpAddress && this.correctSubnetMask) {
            String[] ipOctets = this.ipAddress.split("\\.");
            String[] subnetMaskOctets  = this.subnetMask.split("\\.");
            int firstOctet = Integer.parseInt(ipOctets[0]) & Integer.parseInt(subnetMaskOctets[0]);
            int secondOctet = Integer.parseInt(ipOctets[1]) & Integer.parseInt(subnetMaskOctets[1]);
            int thirdOctet = Integer.parseInt(ipOctets[2]) & Integer.parseInt(subnetMaskOctets[2]);
            int fourthOctet = Integer.parseInt(ipOctets[3]) & Integer.parseInt(subnetMaskOctets[3]);
            return firstOctet + "." + secondOctet + "." +thirdOctet + "." +fourthOctet;
        }
        return "invalid addresses!";
    }

    public String getBroadcastAddress(){
        if(this.correctIpAddress && this.correctSubnetMask) {
            String[] subnetMaskOctets  = this.subnetMask.split("\\.");
            int firstMaskOctet = Integer.parseInt(subnetMaskOctets[0]) ^ 255;
            int secondMaskOctet = Integer.parseInt(subnetMaskOctets[1]) ^ 255;
            int thirdMaskOctet = Integer.parseInt(subnetMaskOctets[2]) ^ 255;
            int fourthMaskOctet = Integer.parseInt(subnetMaskOctets[3]) ^ 255;

            String networkAddress = this.getNetworkAddress();
            String[] networkAddressOctets = networkAddress.split("\\.");
            int firstNetworkOctet = Integer.parseInt(networkAddressOctets[0]) + firstMaskOctet;
            int secondNetworkOctet = Integer.parseInt(networkAddressOctets[1]) + secondMaskOctet;
            int thirdNetworkOctet = Integer.parseInt(networkAddressOctets[2]) + thirdMaskOctet;
            int fourthNetworkOctet = Integer.parseInt(networkAddressOctets[3]) + fourthMaskOctet;

            return firstNetworkOctet + "." + secondNetworkOctet + "." +thirdNetworkOctet + "." + fourthNetworkOctet;
        }
        return "invalid addresses!";
    }

    public String getFirstHostAddress(){
        if(this.correctIpAddress && this.correctSubnetMask){
            String networkAddress = this.getNetworkAddress();
            String[] networkAddressOctets = networkAddress.split("\\.");
            int firstOctet = Integer.parseInt(networkAddressOctets[0]);
            int secondOctet = Integer.parseInt(networkAddressOctets[1]);
            int thirdOctet = Integer.parseInt(networkAddressOctets[2]);
            int fourthOctet = Integer.parseInt(networkAddressOctets[3]) + 1;

            return firstOctet + "." +secondOctet + "." + thirdOctet + "." + fourthOctet;
        }
        return "invalid addresses!";
    }

    public String getLastHostAddress(){
        if(this.correctIpAddress && this.correctSubnetMask){
            String broadcastAddress = this.getBroadcastAddress();
            String[] broadcastAddressOctets = broadcastAddress.split("\\.");
            int firstOctet = Integer.parseInt(broadcastAddressOctets[0]);
            int secondOctet = Integer.parseInt(broadcastAddressOctets[1]);
            int thirdOctet = Integer.parseInt(broadcastAddressOctets[2]);
            int fourthOctet = Integer.parseInt(broadcastAddressOctets[3]) -1;

            return firstOctet + "." +secondOctet + "." + thirdOctet + "." + fourthOctet;
        }
        return "invalid addresses!";
    }

    public int getNumberOfHostsAvailable(){
        if(this.correctIpAddress && this.correctSubnetMask)
            return (int) Math.pow(2, 32-getShortenedSubnetMask()) - 2;
        return -1;
    }

    protected boolean verifyInternetAddress(String ipAddress){
        if(ipAddress != null){
        String[] octets = ipAddress.split("\\.");
        if(octets.length != 4)
            return false;
        for (String octet : octets)
            if (!ifStringIsAMaximum3DigitNumber(octet))
                return false;
        return true;
        }
        return false;
    }

    protected boolean ifStringIsAMaximum3DigitNumber(String s){
        char[] tab = s.toCharArray();
        int count = 0;
        for(char c : tab) {
            count++;
            if (count > 3)
                return false;
            if (Character.isLetter(c))
                return false;
        }
        return true;
    }

    public int getShortenedSubnetMask(){
        if(this.correctIpAddress && this.correctSubnetMask){
            int counter = 0;
            String[] subnetMaskTab = this.subnetMask.split("\\.");
            for(int i = 0 ; i < subnetMaskTab.length ; i++){
            char[] maskTab = Integer.toBinaryString(Integer.parseInt(subnetMaskTab[i])).toCharArray();
            for(char c : maskTab){
                if(c == '1')
                    counter++;
            }}
            return counter;
        }
        return -1;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getSubnetMask() {
        return subnetMask;
    }
}
