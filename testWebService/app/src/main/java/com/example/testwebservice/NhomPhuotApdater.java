package com.example.testwebservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NhomPhuotApdater extends RecyclerView.Adapter<NhomPhuotApdater.NhomPhuotViewHolder> {
    private Context mContext;

    private List<NhomPhuotModel> nhomPhuotModelList;

    public NhomPhuotApdater(Context mContext, List<NhomPhuotModel> nhomPhuotModelList) {
        this.mContext = mContext;
        this.nhomPhuotModelList = nhomPhuotModelList;
    }

    @NonNull
    @Override
    public NhomPhuotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View mView = mInflater.inflate(R.layout.item_nhomphuot, parent, false);
        return new NhomPhuotViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull NhomPhuotViewHolder holder, int position) {
        holder.tv_name.setText("Tên nhóm phượt: " + nhomPhuotModelList.get(position).getName());
        holder.tv_ngaydi.setText("Ngày khởi hành: " + nhomPhuotModelList.get(position).getNgaydi());
        if(nhomPhuotModelList.get(position).getStatus() == 1){
            holder.tv_trangthai.setText("Trạng thái: Chuẩn bị khởi hành");
        } else {
            holder.tv_trangthai.setText("Trạng thái: Chưa khởi hành");
        }


    }

    @Override
    public int getItemCount() {
        return nhomPhuotModelList.size();
    }

    public class NhomPhuotViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_ngaydi, tv_trangthai;
        ImageView iv_edit, iv_delete;
        public NhomPhuotViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.name);
            tv_ngaydi = (TextView) itemView.findViewById(R.id.ngaydi);
            tv_trangthai = (TextView) itemView.findViewById(R.id.status);
            iv_edit = (ImageView) itemView.findViewById(R.id.imageViewEdit);
            iv_delete = (ImageView) itemView.findViewById(R.id.imageViewDelete);
        }
    }
}
