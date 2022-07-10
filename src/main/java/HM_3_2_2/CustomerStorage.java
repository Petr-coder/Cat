package HM_3_2_2;

import java.util.HashMap;

import static Utils.StringUtils.*;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IncorrectPhoneException, IncorrectMailException, IncorrectCommandException {
        String[] components = data.split("\\s+");
        try {
            if (components.length == 4) {
                if (!isPhoneNumberFormatCorrect(components[3])) {
                    throw new IncorrectPhoneException();
                }
                if (!isEmailCorrect(components[2])) {
                    throw new IncorrectMailException();
                }
            } else {
                throw new IncorrectCommandException();
            }
            String name = components[0] + " " + components[1];
            storage.put(name, new Customer(name, components[3], components[2]));
        } catch (IncorrectCommandException e) {
            System.out.println("Exception: " + e);
        } catch (IncorrectPhoneException e) {
            System.out.println("Exception: " + e);
        } catch (IncorrectMailException e) {
            System.out.println("Exception: " + e);
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
                throw new IncorrectCommandException();
            }
        } catch (IncorrectCommandException e) {
            System.out.println("Exception: " + e);
        }
    }

    public int getCount() {
        return storage.size();
    }
}