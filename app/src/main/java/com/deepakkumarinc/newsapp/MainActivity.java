package com.deepakkumarinc.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem home,sports,health,science,entertainment,technology;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        header = findViewById(R.id.header);
//        setSupportActionBar(toolbar);

        String api = "a0bb2861e2de4550803fe17a1ab94bd8";

        home = findViewById(R.id.home);
        sports = findViewById(R.id.sports);
        science = findViewById(R.id.science);
        health = findViewById(R.id.health);
        entertainment = findViewById(R.id.entertainment);
        technology = findViewById(R.id.technology);

        ViewPager viewPager;
         viewPager = findViewById(R.id.fragmentContainer);
         tabLayout = findViewById(R.id.include);

         pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
         viewPager.setAdapter(pagerAdapter);

         tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 viewPager.setCurrentItem(tab.getPosition());


                 if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)
                 {
                     if(tab.getPosition()==0){
                         header.setText("NewsFeed");
                     }

                     if(tab.getPosition()==1){
                         header.setText("Sports");
                     }
                     if(tab.getPosition()==2){
                         header.setText("Health");
                     }
                     if(tab.getPosition()==3){
                         header.setText("Science");
                     }
                     if(tab.getPosition()==4){
                         header.setText("Entertainment");
                     }
                     if(tab.getPosition()==5){
                         header.setText("Technology");
                     }

                     pagerAdapter.notifyDataSetChanged();
                 }

             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });

         viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}