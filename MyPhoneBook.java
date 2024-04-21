import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MyPhoneBook {
    private HashMap<String, ArrayList<Integer>> phonebook = new HashMap<>();

    public void addName(String name, Integer phoneNumber) {
        if (phonebook.containsKey(name)) {
            phonebook.get(name).add(phoneNumber);
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(phoneNumber);
            phonebook.put(name, values);
        }
    }

    public List<String> getSortedNames() {
        List<HashMap.Entry<String, ArrayList<Integer>>> getSorted = new ArrayList<>(phonebook.entrySet());
        getSorted.sort((element1, element2) -> element2.getValue().size() - element1.getValue().size());

        List<String> sortedPhoneBook = new ArrayList<>();
        for (HashMap.Entry<String, ArrayList<Integer>> numbers : getSorted) {
            sortedPhoneBook.add(numbers.getKey() + " - " + numbers.getValue());
        }
        return sortedPhoneBook;
    }

    
    public static void main(String[] args) {
        MyPhoneBook myPhoneBook = new MyPhoneBook();
        myPhoneBook.addName("Ivan Ivanov", 111);
        myPhoneBook.addName("Semen Semenov", 555);
        myPhoneBook.addName("Petr Petrov", 333);
        myPhoneBook.addName("Ivan Ivanov", 777);
        myPhoneBook.addName("Petr Petrov", 999);
        myPhoneBook.addName("Ivan Ivanov", 5577);

        List<String> result = myPhoneBook.getSortedNames();
        for (String string : result) {
            System.out.println(string);
        }
    }
}

