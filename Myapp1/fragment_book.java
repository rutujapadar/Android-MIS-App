package com.Myapp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
public class fragment_book extends Fragment {

    private static final String[] departmentPaths = {"Computer", "IT", "EnTC"};
    private static final String[] yearPaths = {"First Year", "Second Year", "Third Year", "Fourth Year"};
    private static final String[] subjectPaths = {"Fundamentals of Programming", "Data Structures", "Algorithms", "Database Management Systems"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        // Find Spinners
        Spinner departmentSpinner = (Spinner) view.findViewById(R.id.spinner); // Descriptive names
        Spinner yearSpinner = (Spinner) view.findViewById(R.id.spinner1);
        Spinner subjectSpinner = (Spinner) view.findViewById(R.id.spinner2);

        // Create and set adapters
        ArrayAdapter<String> departmentAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, departmentPaths);
        departmentSpinner.setAdapter(departmentAdapter);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, yearPaths);
        yearSpinner.setAdapter(yearAdapter);

        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, subjectPaths);
        subjectSpinner.setAdapter(subjectAdapter);

        return view;
    }
}
