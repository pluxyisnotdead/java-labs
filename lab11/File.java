package lab11;

import lab9.NoHeaderObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static void mobileConnectionsWriter(List<MobileConnection> mobileConnections, String path){
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (MobileConnection mobileConnection : mobileConnections) {
                out.writeObject(mobileConnection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<MobileConnection> mobileConnectionsReader(String path){
        List<MobileConnection> mobileConnections = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(path)))) {
            while (true) {
                try {
                    mobileConnections.add((MobileConnection) in.readObject());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (StreamCorruptedException ignored) { }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return mobileConnections;
    }

    public static void append(MobileConnection mobileConnection, String path){
        try (lab9.NoHeaderObjectOutputStream out = new lab9.NoHeaderObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(path, true)))) {
            out.writeObject(mobileConnection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void servicesWriter(List<Service> services, String path){
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (Service service : services) {
                out.writeObject(service);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Service> servicesReader(String path){
        List<Service> services = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(path)))) {
            while (true) {
                try {
                    services.add((Service) in.readObject());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (StreamCorruptedException ignored) { }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return services;
    }

    public static void append(Service service, String path){
        try (lab9.NoHeaderObjectOutputStream out = new NoHeaderObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(path, true)))) {
            out.writeObject(service);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
