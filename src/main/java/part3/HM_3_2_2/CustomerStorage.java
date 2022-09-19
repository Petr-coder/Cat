package part3.HM_3_2_2;

import java.util.HashMap;

import static Utils.StringUtils.*;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        String[] components = data.split("\\s+");
        try {
            if (components.length == 4) {
                if (!isPhoneNumberFormatCorrect(components[3])) {
                    throw new IncorrectPhoneException("Incorrect phone number format");
                }
                if (!isEmailCorrect(components[2])) {
                    throw new IncorrectMailException("Incorrect email format");
                }
            } else {
                throw new InvalidFormatException("Incorrect number of items in the command");
            }
            String name = components[0] + " " + components[1];
            storage.put(name, new Customer(name, components[3], components[2]));
        } catch (InvalidFormatException | IncorrectPhoneException | IncorrectMailException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        String[] components = name.split("\\s+");

        try {
            if (components.length == 2) {
                storage.remove(name);
            } else {
                throw new InvalidFormatException("Incorrect number of items in the command");
            }
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getCount() {
        return storage.size();
    }
}