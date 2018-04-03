package com.indtop10.recylerview;

import android.app.Activity;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {



        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager mLayoutManager;
        Button btnGotoTop;
        FloatingActionButton fab;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

            mRecyclerView.setHasFixedSize(true);

            String myDataset [] = {"Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck","Hello","Bye","HI","Never mind","Fake","Goodluck"};
            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            // specify an adapter (see also next example)
            mAdapter = new MyAdapter(myDataset);
            mRecyclerView.setAdapter(mAdapter);


            btnGotoTop = (Button) findViewById(R.id.btn_goto_top);
          //  Const.setTypeFace(btnGotoTop, getApplication());
            btnGotoTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRecyclerView.smoothScrollToPosition(0);
                    view.setVisibility(View.GONE);
                }
            });


            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(final RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    if (dy > 0 && fab.getVisibility() == View.VISIBLE) {
                        fab.hide();
                    } else if (dy < 0 && fab.getVisibility() != View.VISIBLE) {
                        fab.show();
                    }

                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            recyclerView.smoothScrollToPosition(0);

                        }
                    });

                }
            });
        }
    }


