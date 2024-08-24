package com.Myapp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class fragment_register extends Fragment {
    private Button clearButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 1. Inflate the layout
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        clearButton = (Button) view.findViewById(R.id.hah);  // Find the button by its ID

        // Set click listener for the button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Zhala", Toast.LENGTH_LONG).show();

                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout); // Get the parent layout
                // Loop through all child views (assuming only CheckBoxes)
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    View childView = linearLayout.getChildAt(i);
                    if (childView instanceof CheckBox) {
                        ((CheckBox) childView).setChecked(false); // Uncheck each CheckBox
                    }
                } // Call the existing clearChecks method when clicked
            }
        });

        return view;
    }

}
