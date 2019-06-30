package com.tongfu.mytestapp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView rv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        initCom();
    }

    private void initCom() {
        RecyclerView.Adapter<VH> adapter = new MyRecyclerViewAdapter(this);
        rv.setAdapter(adapter);
        rv.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {

            }
        });

        rv.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int i, int i1) {
                return false;
            }
        });

//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager manager = new GridLayoutManager(this , 2);
        rv.setLayoutManager(manager);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback(){
            @Override
            public int getMovementFlags(RecyclerView recyclerView ,RecyclerView.ViewHolder viewHolder ){
                return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT|ItemTouchHelper.UP|ItemTouchHelper.DOWN);
            }
            @Override public boolean onMove(RecyclerView recyclerView ,RecyclerView.ViewHolder viewHolder,RecyclerView.ViewHolder target ) {
                if(viewHolder!=null && target!=null)
                    rv.getAdapter().notifyItemMoved(viewHolder.getAdapterPosition() , target.getAdapterPosition());
                return true ;
            }
            @Override public void onSwiped(RecyclerView.ViewHolder viewHolder ,int direction ) {
                rv.getAdapter().notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(rv);
    }
}
