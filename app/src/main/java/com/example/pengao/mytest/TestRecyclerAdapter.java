package com.example.pengao.mytest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by PengAo on 2016/12/8.
 */


public class TestRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerView recyclerView;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        recyclerView = (RecyclerView) parent;
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_a, parent, false);
        ABodyViewHolder viewHolder = new ABodyViewHolder(view);
        return viewHolder;
    }

    /**
     * 为控件设置Margin
     *
     * @param view
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public static void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((ABodyViewHolder) holder).aaaTv.setText(position + "");
        ((ABodyViewHolder) holder).aaaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setPadding(0, 900, 0, 0);
                recyclerView.smoothScrollToPosition(position);
//                setMargins(recyclerView,0, 900, 0, 0);

            }
        });
        ((ABodyViewHolder) holder).cccTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setPadding(0, 0, 0, 0);
                recyclerView.smoothScrollToPosition(0);
//                setMargins(recyclerView,0, 0, 0, 0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ABodyViewHolder extends RecyclerView.ViewHolder {
        private TextView aaaTv;
        private TextView bbbTv;
        private TextView cccTv;

        public ABodyViewHolder(View itemView) {
            super(itemView);
            aaaTv = (TextView) itemView.findViewById(R.id.aaaTv);
            bbbTv = (TextView) itemView.findViewById(R.id.bbbTv);
            cccTv = (TextView) itemView.findViewById(R.id.cccTv);
        }
    }

    public class BBodyViewHolder extends RecyclerView.ViewHolder {


        public BBodyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class CBodyViewHolder extends RecyclerView.ViewHolder {


        public CBodyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class DBodyViewHolder extends RecyclerView.ViewHolder {


        public DBodyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
