package com.ut.mis49m.phonebooklab;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public final static String POSITION = "pos";
    public Contact mContact;

    TextView name, email;
    View view;
    LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mContact = MainActivity.CONTACTS.get(getIntent().getIntExtra(POSITION, 0));

        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        view = (View) findViewById(R.id.circle);
        back = (LinearLayout) findViewById(R.id.back);

        name.setText(mContact.name);
        email.setText(mContact.eMail);
        GradientDrawable bgShape = (GradientDrawable) view.getBackground();
        bgShape.setColor(Color.parseColor(mContact.color));

        back.setBackgroundColor(Color.parseColor(mContact.color));
    }

}
