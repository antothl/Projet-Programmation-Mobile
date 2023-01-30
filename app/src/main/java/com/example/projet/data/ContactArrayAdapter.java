package com.example.projet.data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projet.data.Contact;

import java.util.ArrayList;
/*Adapter pour pouvoir faire une liste de contact*/
public class ContactArrayAdapter extends ArrayAdapter
{
    ArrayList<Contact> arrayList;

    public ContactArrayAdapter(Context context, int ressource, ArrayList<Contact> objects)
    {
        super(context, ressource, objects);
        arrayList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        super.getView(position, convertView, parent);
        TextView result = (TextView) super.getView(position, convertView, parent);
        result.setText(arrayList.get(position).getName());
        return result;
    }

    public static String getNameAt(AdapterView<?> arrayAdapter, int position)
    {
        return ((Contact)arrayAdapter.getItemAtPosition(position)).getName();
    }

    public static String getNumberAt(AdapterView<?> arrayAdapter, int position)
    {
        return ((Contact)arrayAdapter.getItemAtPosition(position)).getNumber();
    }

    public static Contact getContactAt(AdapterView<?> arrayAdapter, int position)
    {
        return new Contact(getNameAt(arrayAdapter, position), getNumberAt(arrayAdapter, position));
    }
}
