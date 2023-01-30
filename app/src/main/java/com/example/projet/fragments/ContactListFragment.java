package com.example.projet.fragments;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projet.R;
import com.example.projet.data.Contact;
import com.example.projet.interfaces.OnClickedItemContactListFragment;
import com.example.projet.data.ContactArrayAdapter;

import java.util.ArrayList;
import java.util.Objects;
/*Fragment pour la liste de contacts*/
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactListFragment extends Fragment implements AdapterView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnClickedItemContactListFragment listener;

    public ContactListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactListFragment newInstance(String param1, String param2) {
        ContactListFragment fragment = new ContactListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }
    @Override
    public void onStart()
    {
        super.onStart();
        ContactArrayAdapter arrayAdapter = new ContactArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, getContactList());
        ListView listView = (ListView) getView().findViewById(R.id.contact_list_list_view);
        ArrayList arrayList = new ArrayList();
        arrayList.add("ok");
        ArrayAdapter<String> a = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        listView.setOnItemClickListener(this);
        listView.setAdapter(arrayAdapter);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        if(listener != null) listener.onItemClick(parent, view, position, id);
        Log.i("okd", "pld");
    }
    public void setOnItemClickListenerContactList(OnClickedItemContactListFragment listener)
    {
        this.listener = listener;
    }

    public ArrayList<Contact> getContactList()
    {
        ArrayList<Contact> result = new ArrayList<>();

        ContentResolver contentResolver = requireContext().getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null
                , null, null, null);
        int id = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
        while(cursor.moveToNext())
        {
            String name = cursor.getString(id);
            int idA = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            String idS = cursor.getString(idA);
            Cursor phones = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ idS, null, null);
            phones.moveToFirst();
            idA = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

            result.add(new Contact(name, phones.getString(idA)));
        }

        return result;
    }
}