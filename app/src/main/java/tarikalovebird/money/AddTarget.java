package tarikalovebird.money;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Calendar;

/**
 * Created by TunasanG on 15/3/2560.
 */

public class AddTarget extends Activity{


    public Target t;
    private EditText targetPrice;
    private EditText targetName;
    private EditText targetDay;
    private Button okbut;
    private Button cancelbut;
    private RadioGroup typegroup;
    private Calendar c;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtarget);

        typegroup=(RadioGroup) findViewById(R.id.Type);
        targetName=(EditText) findViewById(R.id.TargetName);
        targetPrice=(EditText)findViewById(R.id.TargetPrice);
        targetDay=(EditText)findViewById(R.id.DayTargey) ;
        okbut=(Button)findViewById(R.id.OkbuttonTarget);
        cancelbut=(Button)findViewById(R.id.CancelbuttonTarget);

        c = Calendar.getInstance();
        t=new Target(this);

        final AlertDialog.Builder Error = new AlertDialog.Builder(this);
        Error.setTitle("Error! ");
        Error.setIcon(android.R.drawable.btn_dialog);
        Error.setPositiveButton("Close", null);

        okbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean FLAG=true;
                if(targetDay.getText().toString().isEmpty()){
                      /*Error.setMessage("Please input Day ");
                        Error.show();*/
                    targetDay.setError("Please input Day");
                    FLAG=false;
                }
                if(targetPrice.getText().toString().isEmpty()){
                        /*Error.setMessage("Please input Price ");
                        Error.show();*/
                    targetPrice.setError("Please input Price");
                    FLAG=false;
                }
                if(targetDay.getText().toString().contains(".")){
                    targetDay.setError("Day must be an Integer");
                    FLAG=false;
                }
               if(FLAG){

                   FLAG=t.setNameTarget(targetName.getText().toString());
                   FLAG=t.setTargetDay(Integer.parseInt(targetDay.getText().toString()));
                   FLAG=t.setTargetPrice(Float.parseFloat(targetDay.getText().toString()));
                   FLAG=t.setTargetType(typegroup.getCheckedRadioButtonId());
                   FLAG = t.setTargetDay(c.get(Calendar.DAY_OF_MONTH));
                   FLAG = t.setTargetMonth(c.get(Calendar.MONTH));
                   FLAG = t.setTargetYear(c.get(Calendar.YEAR));
                    if(!FLAG){
                        Error.setMessage("Save Target Error");
                        Error.show();
                    }
                    else{
                        Intent returnIntent = new Intent();
                        setResult(RESULT_OK, returnIntent);
                        finish();
                    }
             }
            }
        });
        cancelbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);
                finish();
            }
        });


    }
}
