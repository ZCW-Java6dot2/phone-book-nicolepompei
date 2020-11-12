package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private String name;
    private String phoneNumber;
    private List<String> phoneNumbersList = new ArrayList<>();
    private LinkedHashMap<String, List<String>> phonebook = new LinkedHashMap<>();

    public PhoneBook(LinkedHashMap<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {

    }

    public void add(String name, String phoneNumber) {
        phoneNumbersList.add(phoneNumber);
        phonebook.put(name, phoneNumbersList);

    }

    /**
     * converts array of phone number strings to an array list, adds array list of phone numbers to
     * appropriate name in phonebook list
     *
     * @param name
     * @param phoneNumbers
     */
    public void addAll(String name, String... phoneNumbers) {
        List<String> allPhoneNumbers =  Arrays.asList(phoneNumbers);
        phonebook.put(name, allPhoneNumbers);
    }


    public void remove(String name) {
        this.phonebook.remove(name);

    }

    /**
     * @param name
     * @return
     */
    public Boolean hasEntry(String name) {
        Boolean result;

        if(this.phonebook.containsKey(name) || this.phoneNumbersList.contains(name)){
            result = true;

        } else result = false;
        return result;
    }



    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

        /**
         * get all treemap entries w/ entrySet
         * define value for which we need to fetch key (param in this case)
         * loop through all values of treemap and return the key that matches the inputted value
         * @param phoneNumber
         * @return
         */
        public String reverseLookup (String phoneNumber){

            for(Map.Entry<String, List<String>> elements: phonebook.entrySet()){
                if(elements.getValue().contains(phoneNumber)){
                    return elements.getKey();
                }

            }
            return null;
        }

        public List<String> getAllContactNames () {
            List<String> listOfNames = new ArrayList(phonebook.keySet());
            return listOfNames;

        }

        public Map<String, List<String>> getMap () {
            return phonebook;
        }

    }

