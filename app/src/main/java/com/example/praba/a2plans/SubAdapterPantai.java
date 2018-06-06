package com.example.praba.a2plans;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SubAdapterPantai extends RecyclerView.Adapter<SubAdapterPantai.ViewHolder>{
    private static final String TAG = "SubAdapterPantai";

    String namaPantai [] = {"Pantai Sanur","Pantai Pandawa","Pantai Bias Tugel","Pantai Dreamland","Pantai Angel Billabong"};
    int pantai [] = {R.drawable.pantaisanur,
            R.drawable.pantaipandawa,
            R.drawable.pantaibiastugel,
            R.drawable.pantaidreamland,
            R.drawable.pantaiangelbillabong};
    String detail [] = {"Pantai Sanur terletak di Desa Sanur, Denpasar, Bali. Pantai ini menyajikan keindahan matahari terbit (sunrise) yang mempesona saat pagi hari. Pantai ini mempunyai hamparan pasir putih yang membentang membentuk gugusan pantai yang elok dengan gelombang air laut tidak begitu besar dan keindahan batu karang yang membentang berwarna-warni. Pantai ini cocok untuk berenang, bermain kano, memancing.",
            "Pantai Pandawa terletak di Desa Kutuh, Kuta selatan, Kabupaten Badung, Bali. Pantai ini diapit oleh tebing yang sangat besar dan memiliki 5 patung yang diberi nama Dharma Wangsa, Bima, Arjuna, Nakula, dan Sadewa. Pantai ini cocok untuk snorkeling, main kano, dan budidaya rumput laut.",
            "Pantai Bias Tugel terletak di Desa Padangbai, Kecamatan Manggis, Karangasem, Bali. Pantai ini mempunyai keunikan pasirnya yang tergabung antara pasir hitam dan pasir putih, batu karang di kanan kirinya, gulungan ombak dengan gradasi biru super jernih serta suasanya yang sunyi, cocok untuk kegiatan snorkeling ataupun diving.",
            "Pantai Dreamland terletak di Pecatu, sebelah selatan Bali. Pantai ini dikelilingi tebing-tebing yang menjulang tinggi dan batu karang yang lumayan besar. Pantai ini memiliki pasir putih bersih dengan karang curam cocok untuk menikmati matahari tenggelam (sunset) dan ombaknya yang tinggi cocok untuk penggemar olahraga selancar air (surfing).",
            "Pantai Angel Bilabong terletak di Desa Sakti, Nusapenida, Klungkung, Bali. Pantai ini diapit oleh tebing dan langsung terhubung ke lautan lepas dan memiliki air laut yang sangat jernih. Pantai ini cocok untuk berenang jika air laut sedang surut dan melihat matahari terbenam (sunset)."};


    Context mContext;
    LayoutInflater layoutInflater;

    public SubAdapterPantai(Context mContext) {
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
        holder.txt.setText(namaPantai[position]);
        holder.img.setImageResource(pantai[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kirimData = new Intent(mContext,DetailActivity.class);
                kirimData.putExtra("Nama",namaPantai[position]);
                kirimData.putExtra("img",pantai[position]);
                kirimData.putExtra("Detail",detail[position]);
                mContext.startActivity(kirimData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return namaPantai.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView txtDes;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgView);
            txt = (TextView) itemView.findViewById(R.id.txtView);
            txtDes = (TextView) itemView.findViewById(R.id.txtDetail);
        }
    }
}
