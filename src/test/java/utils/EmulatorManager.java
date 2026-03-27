package utils;

public class EmulatorManager {
   

    public static void startEmulator(String avdName) {
        try {
            System.out.println("Starting Emulator...");

            String command = "emulator -avd " + avdName;

            Process process = Runtime.getRuntime().exec(command);

            waitForDevice();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForDevice() {
        try {
            System.out.println("Waiting for emulator to boot...");

            Process process = Runtime.getRuntime().exec("adb wait-for-device");

            Thread.sleep(20000); // wait extra time for full boot

            System.out.println("Emulator ready!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


