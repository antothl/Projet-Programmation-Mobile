package com.example.projet.fragments;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projet.R;

/*Fragment pour ajouter un contact*/
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactAddFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ContactAddFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText name;
    private EditText number;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactAddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactAddFragment newInstance(String param1, String param2) {
        ContactAddFragment fragment = new ContactAddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ContactAddFragment() {
        // Required empty public constructor
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
    public void onStart()
    {
        super.onStart();

        name = getView().findViewById(R.id.addNameText);
        number = getView().findViewById(R.id.addNumberText);

        Button button = getView().findViewById(R.id.addSubmitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT);

                Uri uri = Uri.fromParts("tel", String.valueOf(number.getText()), null);

                //intent.setDataAndType(uri, ContactsContract.Contacts.CONTENT_TYPE);
                intent.setData(uri);

                //intent.putExtra(ContactsContract.Intents.Insert.NAME, "name.getText()");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE, true);
                intent.putExtra(ContactsContract.Intents.Insert.NAME, String.valueOf(name.getText()));

                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_add, container, false);
    }

}