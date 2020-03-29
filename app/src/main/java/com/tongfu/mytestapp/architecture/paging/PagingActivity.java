package com.tongfu.mytestapp.architecture.paging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.util.StringUtil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagingActivity extends AppCompatActivity {

    @BindView(R.id.rv_main)
    RecyclerView rvMain ;

    PagingViewModel pagingViewModel ;
    class PagingViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_id)
        TextView tvId ;
        @BindView(R.id.tv_name)
        TextView tvName ;
        public PagingViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        pagingViewModel = new ViewModelProvider(this).get(PagingViewModel.class);
        ButterKnife.bind(this) ;
        PagedListAdapter<Person , PagingViewHolder> adapter = new PagedListAdapter<Person , PagingViewHolder>(new DiffUtil.ItemCallback<Person>() {
            @Override
            public boolean areItemsTheSame(@NonNull Person oldItem, @NonNull Person newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Person oldItem, @NonNull Person newItem) {
                return oldItem.getName().equals(newItem.getName());
            }
        }){

            @NonNull
            @Override
            public PagingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(PagingActivity.this).inflate(R.layout.layout_paging_item , parent , false);
                return new PagingViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull PagingViewHolder holder, int position) {
                Person person = getItem(position) ;
                holder.tvId.setText(person.getId() + ":");
                holder.tvName.setText(person.getName());
            }
        };
        pagingViewModel.personList.observe(this , adapter::submitList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMain.setLayoutManager(manager);
        rvMain.setAdapter(adapter);
    }
}
