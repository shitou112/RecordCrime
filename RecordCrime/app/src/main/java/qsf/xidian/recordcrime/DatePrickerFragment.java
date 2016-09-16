package qsf.xidian.recordcrime;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Qian Shaofeng on 2016/9/14.
 */
public class DatePrickerFragment extends DialogFragment{
    int year,month,day;
    Date date;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date,null);
        DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);



        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                year = i;
                month = i1;
                day = i2;
                date.setYear(year);
                date.setMonth(month);
                date.setDate(day);


                Toast.makeText(getActivity(),year+" "+month+" "+day,Toast.LENGTH_SHORT).show();
            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Date of crime")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CrimeActivity crimeActivity=(CrimeActivity)getActivity();
                        System.out.println(year+" "+month+" "+day);
                        crimeActivity.setDate(year+" "+month+" "+day);
                        CrimeFragment fragment = (CrimeFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_crime_container);
                        fragment.sendDateInf();
                    }
                }).setNegativeButton("取消",null).create();
    }
}
