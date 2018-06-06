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

public class SubAdapterDesa extends RecyclerView.Adapter<SubAdapterDesa.ViewHolder> {
    private static final String TAG = "SubAdapterDesa";

    String namaDesa [] = {"Desa Penglipuran","Desa Jati Luwih","Desa Palasari","Desa Pinggan","Desa Tenganan"};
    int desa [] = {R.drawable.desa_wisata_penglipuran,
            R.drawable.desajatiluwih,
            R.drawable.desapalasari,
            R.drawable.desapinggan,
            R.drawable.desatenganan};
    String detail [] = {"Desa Penglipuran memiliki luas sekitar 112 hektar. Desa Penglipuran tidak diperbolehkan motor untuk masuk, jadi udara cukup sejuk dan segar. Selain itu penataan rumah di desa ini juga sangat menarik, yaitu saling berhadapan satu sama lain. Jalan utama Desa Panglipuran menuju ke Pura tengah desa, uniknya Desa Penglipuran tidak pernah mengalami kekeringan walaupun sedang musim kemarau.",
            "Jatiluwih adalah desa yang berada di kecamatan Penebel, Kabupaten Tabanan, Bali. Jatiluwih merupakan desa wisata, dengan panorama yang indah disertai dengan sawah berundak. Udaranya juga sejuk karena berada pada ketinggian rata-rata 700 mdpl. Pengunjung bisa menikmati suasana segar, karena sepanjang hari udara di Jatiluwih tidak pernah panas melebisi 20 derajat celsius. Disamping itu juga sawah dengan sistem terasering memberikan pemandangan yang tiada tara. Sejauh mata memandang yang ada hanyalah hamparan sawah.",
            "Palasari adalah salah satu desa yang terletak di Kabupaten Negara, Bali .Jarak tempuh kurang lebih 25 menit dari pelabuhan Gilimanuk. Sepanjang perjalanan masih terdapat hutan yang membuat Palasari menjadi indah dan nyaman untuk beristirahat ataupun berwisata rohani. Banyak kegiatan Rohani yang telah di lakukan di Desa Palasari ini, baik itu berskala daerah maupun nasional. Mayoritas penduduk asli desa palasari ini menganut agama Katolik. Upacara keagamaannya pun masih menggunakan tradisi bali. Di Desa Palasari ini terdapat 3 objek wisata yang sering dikunjungi yaitu Gereja Hati Kudus Yesus Palasari, Gua Maria Palasari dan Bendungan Palasari.",
            "Desa Pinggan Kintamani menjadi lokasi liburan yang tidak kalah menariknya di Pulau Bali. Apalagi kalau Anda adalah orang yang suka berburu pemandangan sunrise. Tempat ini menyajikan pemandangan matahari terbit di ufuk timur dari lokasinya yang berupa dataran tinggi. Tentu pengalaman ini menjadi pengalaman seru tatkala Anda sengaja datang ke Desa Pinggan. Selama ini hanya pantai yang menjadi lokasi favorit untuk menyaksikan fenomena matahari terbit. Namun anggapan itu seketika berubah tatkala keindahan sunrise yang tak terbantahkan juga terpampang di Desa Pinggan.",
            "Desa Tenganan terletak di Karangasem, Bali termasuk dalam Bali Aga. Bali Aga merupakan desa yang masih memegang teguh pola hidup tradisional yang sudah ada sejak ribuan tahun. Desa Tenganan ini masih menerapkan sistem bertukar barang, sebagian besar masyarakat di desa Tenganan bekerja sebagai petani, namun ada juga yang bekerja membuat kerajinan bambu, lukisan dan menenun kain gringsing."};


    Context mContext;
    LayoutInflater layoutInflater;

    public SubAdapterDesa(Context mContext) {
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
        holder.txt.setText(namaDesa[position]);
        holder.img.setImageResource(desa[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kirimData = new Intent(mContext,DetailActivity.class);
                kirimData.putExtra("Nama",namaDesa[position]);
                kirimData.putExtra("img",desa[position]);
                kirimData.putExtra("Detail",detail[position]);
                mContext.startActivity(kirimData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return namaDesa.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView txtDes;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgView);
            txt =  itemView.findViewById(R.id.txtView);
            txtDes = itemView.findViewById(R.id.txtDetail);
    }
    }
}
