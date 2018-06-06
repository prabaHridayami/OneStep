package com.example.praba.a2plans;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SubAdapterGunung extends RecyclerView.Adapter<SubAdapterGunung.ViewHolder> {
    private static final String TAG = "SubAdapterGunung";

    String namaGunung [] = {"Gunung Agung","Gunung Batur","Gunung apada","Gunung Abang"};
    int gunung [] = {R.drawable.gunungagung,
            R.drawable.pantaisanur,
            R.drawable.purauluwatu,
            R.drawable.desa_wisata_penglipuran};
    String detail [] = {"Gunung Agung terletak di Kecamatan Rendang, Karangasem, Bali. Gunung ini memiliki ketinggian 3.031 mdpl, kawah yang sangat besar, melingkar dan lebar. Saat di puncak Gunung Agung dapat melihat puncak Gunung Rinjani yang berada di pulau Lombok di sebelah timur. Jalur pendakiannya bisa melalui Sebudi maupun Besakih.",
            "Gunung Batur terletak di Kecamatan Kintamani, Bangli, Bali. Gunung ini memiliki ketinggian 1.717 mdpl. Gunung Batur mengelilingi danau kaldera Batur seluas 13 km2 . Saat di puncak Gunung Batur dapat melihat puncak Agung, Gunung Abang dan Gunung Rinjani (jika cuaca mendukung). Jalur pendakiannya melalui Pura Jati Toya Bungkah.",
            "Gunung Batukaru terletak di Kecamatan Penebel, Tabanan, Bali. Gunung ini memiliki ketinggian 2.276 mdpl. Gunung Batukaru memiliki curah hujan tinggi dengan keragaman flora dan fauna. Saat di puncak Gunung Batukaru dapat melihat Pura Kedaton yang berada disana. Jalur pendakiannnya melalui desa Pujungan kecamatan Pupuan.",
            "Gunung Abang terletak di Desa Abang Batudinding, Kecamatan Kintamani, Bali. Gunung ini memiliki ketinggian 2.152 mdpl. Jalur pendakiannya melalui Pura Munggu Desa Suter."};

    Context mContext;
    LayoutInflater layoutInflater;

    public SubAdapterGunung(Context mContext) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txt.setText(namaGunung[position]);
        holder.img.setImageResource(gunung[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: DetGunung");
                Intent kirimData = new Intent(mContext,DetailActivity.class);
                kirimData.putExtra("Nama",namaGunung[position]);
                kirimData.putExtra("img",gunung[position]);
                kirimData.putExtra("Detail",detail[position]);
                mContext.startActivity(kirimData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return namaGunung.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView txtDes;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgView);
            txt = itemView.findViewById(R.id.txtView);
            txtDes =itemView.findViewById(R.id.txtDetail);
        }
    }

}
