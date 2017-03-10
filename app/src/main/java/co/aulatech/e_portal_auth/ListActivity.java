package co.aulatech.e_portal_auth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    TextView title, sub_title_1, sub_title_2, home_btn_txt;
    ImageView active_img, home_btn_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_active_list_layout);
        active_img = (ImageView) findViewById(R.id.active_img);

        // BACK BUTTON LOGIC
        // ---------------------------------------------------------------
        home_btn_txt = (TextView) findViewById(R.id.home_btn_txt);
        home_btn_img = (ImageView) findViewById(R.id.home_btn_img);

        home_btn_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_btn_txt.setBackgroundColor(Color.parseColor("#6BB9F0"));
                home_btn_img.setBackgroundColor(Color.parseColor("#6BB9F0"));
                Intent back_to_main = new Intent(getApplicationContext(), MainActivity.class);
                back_to_main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                back_to_main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(back_to_main);
            }
        });
        home_btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_btn_txt.setBackgroundColor(Color.parseColor("#6BB9F0"));
                home_btn_img.setBackgroundColor(Color.parseColor("#6BB9F0"));
                Intent back_to_main = new Intent(getApplicationContext(), MainActivity.class);
                back_to_main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                back_to_main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(back_to_main);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String intent_from_main = (String) extras.get("layout_info");
            assert intent_from_main != null;
            if (intent_from_main.equals("aad")) {
                active_img.setImageResource(R.drawable.ic_allowances_deductions); // active image
                title = (TextView) findViewById(R.id.textView8);
                title.setText(R.string.active_allowances_deductions); // title
                sub_title_1 = (TextView) findViewById(R.id.textView9);
                sub_title_1.setText(R.string.allowances_sub_title); // sub title 1
                sub_title_2 = (TextView) findViewById(R.id.textView10);
                sub_title_2.setText(R.string.allowances_sub_title_2);// sub title 2
                expListView = (ExpandableListView) findViewById(R.id.lvExp); // get the listview
                prepareListData_1(); // preparing list data
                listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
                expListView.setAdapter(listAdapter); // setting list adapter
                // ------------------------------------------------------------------------------- //
            } else if (intent_from_main.equals("ls")) {
                active_img.setImageResource(R.drawable.ic_vacation); // active image
                title = (TextView) findViewById(R.id.textView8);
                title.setText(R.string.employee_leave_summary); // title
                sub_title_1 = (TextView) findViewById(R.id.textView9);
                sub_title_1.setText(R.string.entitlement); // sub title 1
                sub_title_2 = (TextView) findViewById(R.id.textView10);
                sub_title_2.setText(R.string.max_days_vacation);// sub title 2
                expListView = (ExpandableListView) findViewById(R.id.lvExp); // get the listview
                prepareListData_2(); // preparing list data
                listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
                expListView.setAdapter(listAdapter); // setting list adapter
                // ------------------------------------------------------------------------------- //
            } else if (intent_from_main.equals("eadrs")) {
                active_img.setImageResource(R.drawable.ic_eadrs); // active image
                title = (TextView) findViewById(R.id.textView8);
                title.setText(R.string.list_of_my_eadrs); // title
                sub_title_1 = (TextView) findViewById(R.id.textView9);
                sub_title_1.setText("your EADRs are ..."); // sub title 1
                expListView = (ExpandableListView) findViewById(R.id.lvExp); // get the listview
                prepareListData_3(); // preparing list data
                listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
                expListView.setAdapter(listAdapter); // setting list adapter

            }
        }
    }

    /**********************************************************************************
     * Preparing the list data
     *********************************************************************************/
    private void prepareListData_1() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("ID SALARY"); // Adding child data
        listDataHeader.add("ID PAYE");
        listDataHeader.add("ID ADVICE");
        listDataHeader.add("ID SSEMP");
        listDataHeader.add("ID STAMP");
        listDataHeader.add("ID SSEMPL");

        List<String> salary = new ArrayList<>(); // Adding child data
        salary.add("NAME: Monthly Salary");
        salary.add("TYPE: Earnings");
        salary.add("BANK:  ");
        salary.add("ACCOUNT:   ");
        salary.add("SCHEDULE: Every Pay Period");
        salary.add("START DATE: 15-Sept-2016");
        salary.add("STOP DATE: 31-DEC-2999");

        List<String> paye = new ArrayList<>(); // Adding child data
        paye.add("NAME: Income Tax");
        paye.add("TYPE: Deductions");
        paye.add("BANK:  ");
        paye.add("ACCOUNT:   ");
        paye.add("SCHEDULE: Every Pay Period");
        paye.add("START DATE: 15-Sept-2016");
        paye.add("STOP DATE: 31-DEC-2999");

        List<String> advice = new ArrayList<>(); // Adding child data
        advice.add("NAME: Net Pay Deposit");
        advice.add("TYPE: Deductions");
        advice.add("BANK: NCB");
        advice.add("ACCOUNT: 55555555");
        advice.add("SCHEDULE: Every Pay Period");
        advice.add("START DATE: 15-Sept-2016");
        advice.add("STOP DATE: 31-DEC-2999");

        List<String> ssemp = new ArrayList<>(); // Adding child data
        ssemp.add("NAME: Social Security");
        ssemp.add("TYPE: Deductions");
        ssemp.add("BANK:  ");
        ssemp.add("ACCOUNT:  ");
        ssemp.add("SCHEDULE: Every Pay Period");
        ssemp.add("START DATE: 15-Sept-2016");
        ssemp.add("STOP DATE: 31-DEC-2999");

        List<String> stamp = new ArrayList<>(); // Adding child data
        stamp.add("NAME: Stamp Duty");
        stamp.add("TYPE: Deductions");
        stamp.add("BANK:  ");
        stamp.add("ACCOUNT:  ");
        stamp.add("SCHEDULE: Every Pay Period");
        stamp.add("START DATE: 15-Sept-2016");
        stamp.add("STOP DATE: 31-DEC-2999");

        List<String> ssempl = new ArrayList<>(); // Adding child data
        ssempl.add("NAME: Social Security");
        ssempl.add("TYPE: Employee Cost");
        ssempl.add("BANK:  ");
        ssempl.add("ACCOUNT:  ");
        ssempl.add("SCHEDULE: Every Pay Period");
        ssempl.add("START DATE: 15-Sept-2016");
        ssempl.add("STOP DATE: 31-DEC-2999");

        listDataChild.put(listDataHeader.get(0), salary); // Header, Child data
        listDataChild.put(listDataHeader.get(1), paye);
        listDataChild.put(listDataHeader.get(2), advice);
        listDataChild.put(listDataHeader.get(3), ssemp);
        listDataChild.put(listDataHeader.get(4), stamp);
        listDataChild.put(listDataHeader.get(5), ssempl);
    }

    // ---------------------------------------------------------------------------------- //
    private void prepareListData_2() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("VACATION LEAVE"); // Adding child data
        listDataHeader.add("SICK LEAVE");
        listDataHeader.add("OTHER LEAVE");

        List<String> vacation_leave = new ArrayList<>(); // Adding child data
        vacation_leave.add("Leave Total: ");
        vacation_leave.add("Vacation Days: ");
        vacation_leave.add("Period: January 2017");
        vacation_leave.add("Vacation Days: 0.00");

        List<String> sick_leave = new ArrayList<>(); // Adding child data
        sick_leave.add("Leave Total: 0");
        sick_leave.add("Sick Days Total: 0");
        sick_leave.add("Maximum Sick Days: 0");
        sick_leave.add("Remaining Sick Days: 0");

        List<String> other_leave = new ArrayList<>(); // Adding child data
        other_leave.add("Leave Description: ");
        other_leave.add("Days: ");

        listDataChild.put(listDataHeader.get(0), vacation_leave); // Header, Child data
        listDataChild.put(listDataHeader.get(1), sick_leave);
        listDataChild.put(listDataHeader.get(2), other_leave);
    }

    // ---------------------------------------------------------------------------------- //
    private void prepareListData_3() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("REVIEW PERIOD"); // Adding child data
        listDataHeader.add("SERVICE");
        listDataHeader.add("DATE RECEIVED");
        listDataHeader.add("MID-TERM REVIEW");
        listDataHeader.add("RATING");

        List<String> review_period = new ArrayList<>(); // Adding child data
        review_period.add("...");

        List<String> service = new ArrayList<>(); // Adding child data
        service.add("...");

        List<String> date_received = new ArrayList<>(); // Adding child data
        date_received.add("...");

        List<String> mid_term_review = new ArrayList<>(); // Adding child data
        mid_term_review.add("...");

        List<String> rating = new ArrayList<>(); // Adding child data
        rating.add("...");

        listDataChild.put(listDataHeader.get(0), review_period); // Header, Child data
        listDataChild.put(listDataHeader.get(1), service);
        listDataChild.put(listDataHeader.get(2), date_received);
        listDataChild.put(listDataHeader.get(3), mid_term_review);
        listDataChild.put(listDataHeader.get(4), rating);

    }
}
