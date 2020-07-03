public class Main {
    public static void main(String[] args) {

        String ip = "192.168.1.145";
        String subnetMask = "255.255.255.128";
        IPv4Converter iPv4Converter = new IPv4Converter(ip, subnetMask);

        System.out.println("IP: " + iPv4Converter.getIpAddress());
        System.out.println("Subnet Mask: " + iPv4Converter.getSubnetMask());
        System.out.println("Network Address: " + iPv4Converter.getNetworkAddress());
        System.out.println("Broadcast Address: " + iPv4Converter.getBroadcastAddress());
        System.out.println("First Host Address: " + iPv4Converter.getFirstHostAddress());
        System.out.println("Last Host Address: " + iPv4Converter.getLastHostAddress());

    }
}
