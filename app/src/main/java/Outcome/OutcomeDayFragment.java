package Outcome;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tarikalovebird.money.EditOutcomeSchedule;
import tarikalovebird.money.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutcomeDayFragment extends Fragment {


    private View myview;
    public OutcomeDayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myview= inflater.inflate(R.layout.fragment_outcome_day, container, false);

        return myview;
    }

}
