package qsf.xidian.recordcrime;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import qsf.xidian.database.CrimeDataHelper;
import qsf.xidian.database.ManagerDB;
import qsf.xidian.model.Crime;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment{
    private Button mButton;
    private Button mSubmitButton;
    private CheckBox mCheckBox;
    private EditText mEditText;
    private Crime crime;
    CrimeActivity crimeActivity;
    private final int UPDATE_DATE = 1;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==UPDATE_DATE){
                System.out.println(crimeActivity.getDate());
                mButton.setText(crimeActivity.getDate());
            }
        }
    };
    public void sendDateInf(){
        Message message = new Message();
        message.what = UPDATE_DATE;
        mHandler.sendMessage(message);
    }
    public CrimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime,container, false);
        crimeActivity = (CrimeActivity) getActivity();
        System.out.println("_____"+crimeActivity);
        crime =new Crime();

        mButton = (Button) view.findViewById(R.id.show_date_button);

        mButton.setText("选择时间日期");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                DatePrickerFragment dialog = new DatePrickerFragment();
                dialog.show(fm,"DialogDate");

            }

        });

        mEditText = (EditText) view.findViewById(R.id.crime_editText);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                crime.setMtitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mCheckBox = (CheckBox) view.findViewById(R.id.solve);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                crime.setSolved(b);
            }
        });

        mSubmitButton = (Button) view.findViewById(R.id.submit_crime);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        ManagerDB managerDB=ManagerDB.getManagerDB();
                        managerDB.getDatabase(getActivity(),1);

                        crime.setDate(crimeActivity.getDate());

                        int solveValue =0;
                        if(crime.isSolved()==true){
                            solveValue=1;
                        }
                        else{
                            solveValue=0;
                        }
                        System.out.println(crime.getUUID()+"---"+crime.getMtitle()+"---"+crime.getDate()+"---"+crime.isSolved());
                        managerDB.insert(new String[]{crime.getUUID().toString(),crime.getMtitle(),crime.getDate(),solveValue+""});
                    }
                }.start();

            }
        });
        return view;
    }


}
