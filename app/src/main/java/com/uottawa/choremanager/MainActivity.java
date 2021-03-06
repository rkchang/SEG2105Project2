/* CITATIONS
* Got Firebase related code from : https://www.firebase.com/docs/android/quickstart.html
*
*
* */

package com.uottawa.choremanager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import java.util.ArrayList;


//taken from tutorial https://www.youtube.com/watch?v=bNpWGI_hGGg
public class MainActivity extends FragmentActivity {
    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;
    static public DataBase dB;
    private SectionPageAdapter adapter;
    private calendarFragment newCalendarFragment;
    private static tasksFragment newTasksFragment;
    private peopleFragment newPeopleFragment;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dB = new DataBase();


        //For some magical fucking reason the following doesn't work... I give up, this team is shit...
        Profile x = null;
        for(Profile prof: dB.getProfiles()){
            if(prof.getName().equals("Default")){
                x = prof;
            }
        }

        if(x == null){
            x = dB.addProfile("Default", true, "password1");
        }
        dB.setCurrentUser(x);

        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);

        //Remove me?
        newCalendarFragment = new calendarFragment();
        newPeopleFragment = new peopleFragment();
        newTasksFragment = new tasksFragment();


        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        fragmentManager = getSupportFragmentManager();
        adapter = new SectionPageAdapter(fragmentManager);

        adapter.addFragment(newCalendarFragment, "Calendar");
        adapter.addFragment(newTasksFragment, "Tasks");
        adapter.addFragment(newPeopleFragment, "People");

        viewPager.setAdapter(adapter);
    }


    //https://stackoverflow.com/questions/41691216/how-to-refresh-second-tab-fragment
    //https://stackoverflow.com/questions/9156406/whats-the-difference-between-detaching-a-fragment-and-removing-it
    public static void updateTaskFragment(){

        fragmentManager.beginTransaction().detach(newTasksFragment).commit();
        fragmentManager.beginTransaction().attach(newTasksFragment).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        //updateTaskFragment();
        mSectionPageAdapter.notifyDataSetChanged();
    }



    static public DataBase getDB(){
        return dB;
    }
}

//End citation