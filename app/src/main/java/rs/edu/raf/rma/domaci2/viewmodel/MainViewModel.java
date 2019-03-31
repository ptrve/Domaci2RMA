package rs.edu.raf.rma.domaci2.viewmodel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import rs.edu.raf.rma.domaci2.model.Contact;
import rs.edu.raf.rma.domaci2.util.Util;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Contact>> contactsLiveData;

    public MainViewModel() {
        contactsLiveData = new MutableLiveData<>();
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            contacts.add(new Contact(Util.generateId(), Character.toString((char)((int)'A' + i%26)) + " kontakt " + i));
        }
        contactsLiveData.setValue(contacts);
    }

    public LiveData<List<Contact>> getContacts() {
        return contactsLiveData;
    }

    public void setContacts(List<Contact> contacts) {
        this.contactsLiveData.setValue(new ArrayList<>(contacts));
    }
}
