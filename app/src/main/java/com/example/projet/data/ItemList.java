package com.example.projet.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

/*Item de la liste de contact*/

@SuppressLint("ViewConstructor")
public class ItemList extends LinearLayout implements View.OnClickListener {
    public ItemList(@NonNull Context context, Contact contact){
        super(context);
        TextView contactView = new TextView(context);
        contactView.setText(contact.getName());
        contactView.setOnClickListener(new myOnclickListener(this, contactView));
        addView(contactView);
        setOrientation(LinearLayout.HORIZONTAL);
    }
    @Override
    public void onClick(View view){
        super.callOnClick();
        super.performClick();
    }
    static class myOnclickListener implements View.OnClickListener{
        TextView textView;
        ItemList parentToCall;
        public myOnclickListener(ItemList parentToCall, TextView textView) {
            this.textView = textView;
            this.parentToCall = parentToCall;
        }
        public void onClick(View v){}
    }
}
