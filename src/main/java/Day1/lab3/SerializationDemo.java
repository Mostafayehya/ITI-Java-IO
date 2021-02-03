package Day1.lab3;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {

        SerializationDemo serializationDemo = new SerializationDemo();

        serializationDemo.serialize();
        serializationDemo.deserialize();

    }

    public void serialize() {

        try (ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream("serial"))) {

            MyClass object1 = new MyClass("Hello", -1, 2.222);
            System.out.println("object1: " + object1);

            objectStream.writeObject(object1);

            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception during serialization : " + e);
        }

    }

    public void deserialize() {

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serial.txt"))){

            MyClass object2 = (MyClass) objectInputStream.readObject();
            System.out.println("==========================");
            System.out.println("After deserialization");
            System.out.println(object2);
        }catch (Exception e){
            System.out.println("Exception during deserialziation: " + e);
        }

    }
}
