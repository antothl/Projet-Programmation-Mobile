package com.example.projet.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projet.R;
import com.example.projet.data.Contact;

import java.util.Objects;
/*Fragment pour voir un contact*/
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactViewFragment newInstance(String param1, String param2) {
        ContactViewFragment fragment = new ContactViewFragment();
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
        return inflater.inflate(R.layout.fragment_contact_view, container, false);
    }
    public void setPhoneName(String name)
    {
        ((TextView) requireActivity().findViewById(R.id.contact_view_phone_name)).setText(name);
    }
    public void setPhoneNumber(String number)
    {
        ((TextView) requireActivity().findViewById(R.id.contact_view_phone_number)).setText(number);
    }
    public void setPhone(Contact contact)
    {
        setPhoneName(contact.getName());
        setPhoneNumber(contact.getNumber());
    }
}
