package rs.edu.raf.rma.domaci2.model;

public class Contact {

    private int mId;
    private String mName;
    private String mLastName;
    private String mNumber;
    private String mEmail;
    private String mImageUrl;

    public Contact(int id, String name) {
        this.mId = id;
        this.mName = name;
        this.mLastName = "Petrovic";
        this.mNumber = "011/555-333";
        this.mEmail = Character.toLowerCase(name.trim().charAt(0)) + "petrovic@raf.rs";
        this.mImageUrl = "https://picsum.photos/300/300/?random";
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

}
