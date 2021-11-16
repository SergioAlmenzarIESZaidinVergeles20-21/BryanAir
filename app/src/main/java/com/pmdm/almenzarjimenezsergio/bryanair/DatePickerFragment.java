package com.pmdm.almenzarjimenezsergio.bryanair;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    //instance params
    EditText etDate;

    /**
     * DatePicker Constructor
     * @param etDate EditText we want to include a DatePicker
     */
    public DatePickerFragment (EditText etDate){
        this.etDate = etDate;
    }

    /**
     * DatePicker Creation Method
     * @param savedInstanceState (Bundle)
     * @return instance of DatePickerDialog
     */
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    /**
     * EditText date setter.
     * @param datePicker instance of the DatePicker
     * @param year selected
     * @param month selected
     * @param day selected
     */
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        final String selectedDate = day + "/" + (month+1) + "/" + year;
        etDate.setText(selectedDate);
    }
}
