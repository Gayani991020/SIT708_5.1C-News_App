package com.example.sit708_task_5_1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * MainActivity class managing two RecyclerViews: one for horizontal display and one for grid display.
 */
public class MainActivity extends AppCompatActivity {
    // RecyclerView for horizontal items
    private RecyclerView rv;
    // Data source for the horizontal RecyclerView
    private ArrayList<String> dataSource;
    // LayoutManager for the horizontal RecyclerView
    private LinearLayoutManager linearLayoutManager;
    // LayoutManager for the grid RecyclerView
    private RecyclerView.LayoutManager layoutManager;
    // Adapter for the horizontal RecyclerView
    private MyRvAdapter myRvAdapter;
    // RecyclerView for grid items
    private RecyclerView newsRv;
    // Adapter for the grid RecyclerView
    private RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_main);

        // Initialize the horizontal RecyclerView
        initHorizontalRecyclerView();
        // Initialize the grid RecyclerView
        initGridRecyclerView();
    }

    /**
     * Sets up the horizontal RecyclerView with a LinearLayoutManager and adapter.
     */
    private void initHorizontalRecyclerView() {
        rv = findViewById(R.id.horizontalRv);
        // Initialize the data source for the horizontal RecyclerView
        dataSource = new ArrayList<>(Arrays.asList("News", "News", "News", "News", "News", "News"));
        // Set the layout manager to horizontal LinearLayoutManager
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // Initialize the adapter for the horizontal RecyclerView
        myRvAdapter = new MyRvAdapter(dataSource);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myRvAdapter);

        // Set item click listener for the horizontal RecyclerView
        myRvAdapter.setOnItemClickListener(new MyRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Display the details fragment when an item is clicked
                displayDetailsFragment(dataSource.get(position), "Sample Description", R.drawable.ic_launcher_background);
            }
        });
    }

    /**
     * Sets up the grid RecyclerView with a GridLayoutManager and adapter.
     */
    private void initGridRecyclerView() {
        newsRv = findViewById(R.id.newsRv);
        // Set the layout manager to GridLayoutManager with 2 columns
        layoutManager = new GridLayoutManager(this, 2);
        // Initialize the data source for the grid RecyclerView
        int[] array = new int[6];
        Arrays.fill(array, R.drawable.ic_launcher_background);
        // Initialize the adapter for the grid RecyclerView
        rvAdapter = new RvAdapter(array);
        newsRv.setLayoutManager(layoutManager);
        newsRv.setAdapter(rvAdapter);
        newsRv.setHasFixedSize(true);

        // Set item click listener for the grid RecyclerView
        rvAdapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Display the details fragment when an item is clicked
                displayDetailsFragment("Sample Title", "Sample Description", R.drawable.ic_launcher_background);
            }
        });
    }

    /**
     * Displays the detail fragment for the selected news item.
     *
     * @param title       The title of the news item.
     * @param description The description of the news item.
     * @param imageResId  The resource ID for the image.
     */
    private void displayDetailsFragment(String title, String description, int imageResId) {
        // Log the title of the clicked news item
        Log.d("NewsApp", "News item clicked, title: " + title);
        // Replace the existing fragment with a new instance of NewsDetailFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.newsDetailFragmentContainer, NewsDetailFragment.newInstance(title, description, imageResId))
                .addToBackStack(null)
                .commit();

        // Make the container for the detail fragment visible
        findViewById(R.id.newsDetailFragmentContainer).setVisibility(View.VISIBLE);
    }
}
