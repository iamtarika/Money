package tarikalovebird.money;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import outcome_db.Outcome_adepter;
import outcome_db.Outcome_data;
import outcome_db.Outcome_detail;

public class EditOutcomeSchedule extends Activity {

    TextView outcome_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_outcome_schedule);
        print();

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        print();

    }
    void print()
    {
        Outcome_data repo = new Outcome_data(this);
        List<String> outcomeList =  repo.getOutcomeList();

        ArrayList<Outcome_detail> arrayOfOutcome = new ArrayList<Outcome_detail>();
        Outcome_adepter adapter = new Outcome_adepter(this, arrayOfOutcome);

        if(outcomeList.size()!=0) {
            for(int i=0;i<outcomeList.size();i++)
            {
                Outcome_detail newOutcome = new Outcome_detail(outcomeList.get(i));
                adapter.add(newOutcome);

            }
            ListView lv = (ListView) findViewById(R.id.outcomelist);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    outcome_id = (TextView) view.findViewById(R.id.outcome_Id);
                    String outcomeId = outcome_id.getText().toString();
                    Intent objIndent = new Intent(getApplicationContext(),Outcome_edit_item.class);
                    objIndent.putExtra("outcome_Id", Integer.parseInt(outcomeId));
                    startActivityForResult(objIndent,1);
                }
            });

            lv.setAdapter(adapter);


        }
    }
}
