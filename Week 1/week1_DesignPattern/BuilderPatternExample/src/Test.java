public class Test {
    public static void main(String[] args) {
        // Creating different configurations of Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA RTX 3080")
            .setPowerSupply("750W")
            .setMotherboard("ASUS ROG")
            .build();

        Computer officePC = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .setGPU("Integrated")
            .setPowerSupply("500W")
            .setMotherboard("Gigabyte")
            .build();

        // Display configurations
        System.out.println("Gaming PC Configuration:");
        System.out.println("CPU: " + gamingPC.getCPU());
        System.out.println("RAM: " + gamingPC.getRAM());
        System.out.println("Storage: " + gamingPC.getStorage());
        System.out.println("GPU: " + gamingPC.getGPU());
        System.out.println("Power Supply: " + gamingPC.getPowerSupply());
        System.out.println("Motherboard: " + gamingPC.getMotherboard());

        System.out.println("\nOffice PC Configuration:");
        System.out.println("CPU: " + officePC.getCPU());
        System.out.println("RAM: " + officePC.getRAM());
        System.out.println("Storage: " + officePC.getStorage());
        System.out.println("GPU: " + officePC.getGPU());
        System.out.println("Power Supply: " + officePC.getPowerSupply());
        System.out.println("Motherboard: " + officePC.getMotherboard());
    }
}
