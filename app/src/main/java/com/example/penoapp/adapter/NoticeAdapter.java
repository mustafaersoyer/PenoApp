package com.example.penoapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.penoapp.R;
import com.example.penoapp.model.Notice;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    Context mCtx;
    List<Notice> noticeList;
    private ItemClickListener mClickListener;


    public NoticeAdapter(Context mCtx) {
        this.mCtx = mCtx;
        this.noticeList = new ArrayList<>();
    }

    @NonNull
    @Override
    final public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.cardview_notice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Notice notice = noticeList.get(position);

        holder.lecName.setText(notice.getLectureName());
        holder.content.setText(notice.getNoticeContent());
        // changeColor(order,holder);

        //holder.cardView.setOnClickListener(v -> mClickListener.onItemClick(holder.layout));

    }

    private String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month - 1];
    } //Ay ismi yazma
   /* private void changeColor(Notice order, ViewHolder holder){
        Drawable[] compoundDrawables=holder.tvProductState.getCompoundDrawables();
        Drawable drawableLeft=compoundDrawables[0].mutate();

        if(order.getProductState().equals("Yolda")){
            holder.tvProductState.setTextColor(mCtx.getResources().getColor(R.color.green));
            drawableLeft.setColorFilter(new PorterDuffColorFilter(mCtx.getResources().getColor(R.color.green), PorterDuff.Mode.SRC_IN));
        } else if (order.getProductState().equals("Hazırlanıyor")){
            holder.tvProductState.setTextColor(mCtx.getResources().getColor(R.color.orange));
            drawableLeft.setColorFilter(new PorterDuffColorFilter(mCtx.getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_IN));
        }else{
            holder.tvProductState.setTextColor(mCtx.getResources().getColor(R.color.textColor));
            drawableLeft.setColorFilter(new PorterDuffColorFilter(mCtx.getResources().getColor(R.color.textColor), PorterDuff.Mode.SRC_IN));
        }
    }//Duruma göre renk değiştirme*/

    public void setItems(List<Notice> noticeList) {
        this.noticeList = noticeList;
        notifyDataSetChanged();
    }

    @Override
    final public int getItemCount() {
        return noticeList.size();
    }

    public void setClickListener(NoticeAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView content, lecName;
        LinearLayout layout;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.notice_content);
            lecName = itemView.findViewById(R.id.lecName);

        }
    }

    public interface ItemClickListener {
        void onItemClick(LinearLayout layout);
    }
}