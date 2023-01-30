package com.example.projet.data;
/*Données correspondant à un contact*/
import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable{
    private String name;
    private String number;

    public String getName(){

        return name;
    }
    public String getNumber(){

        return number;
    }
    public Contact(String name,String number){
        this.name=name;
        this.number=number;
    }
    @Override
    public int describeContents()
    {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(name);
        dest.writeString(number);
    }
    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
    private Contact(Parcel in)
    {
        name = in.readString();
        number = in.readString();
    }
}
