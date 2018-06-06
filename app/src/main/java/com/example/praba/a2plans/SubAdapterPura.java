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

public class SubAdapterPura extends RecyclerView.Adapter<SubAdapterPura.ViewHolder> {
    private static final String TAG = "SubAdapterPura";

    String namaPura [] = {"Pura Uluwatu","Pura Tanah Lot","Pura Tirta Empul","Pura Lempuyang","Pura Besakih","Pura Beratan"};
    int pura [] = {R.drawable.purauluwatu,
            R.drawable.puratanahlot,
            R.drawable.puratirtaempul,
            R.drawable.puralempuyang,
            R.drawable.purabesakih,
            R.drawable.puraberatan};
    String detail [] = {"Pura Uluwatu terletak terletak di desa Pecatu, kecamatan Kuta, Badung berada di tebing dengan ketinggian sekitar 97 meter. Pura Uluwatu termasuk dalam pura Sad Kahyangan sebagai penyangga 9 mata angin, saat sore hari di Pura Uluwatu selalu menampilkan pertunjukan tari kecak.",
            "Pura Tanah Lot terletak di Beraban, Kediri, Tabana, Bali sekitar 300 m dari bibir pantai. Waktu yang tepat untuk berkunjung ketika air laut sedang surut, jika sedang pasang batu karang yang menopang pura tersebut akan tergenang dengan air dan tidak bisa mendekat ke pura. Pura Tanah lot memiliki gua yang ada di dalamnya ada ular – ular belang. Pura Tanah Lot merupakan bagian dari Pura Kahyangan Jagat di Bali, sebagai tempat memuja dewa penjaga laut.",
            "Pura Tirta Empul terletak di tampak siring, Gianyar, Bali. Di bagian tengah dapat melihat kolam yang memiliki 30 pancuran, kolam ini menjadi kolam suci yang digunakan sebagai tempat mandi untuk mensucikan diri. Pura ini juga memiliki istana presiden Indonesia Ir. Soekarno.",
            "Pura Lempuyang terletakak di Kabupaten Karangasem. Pura Lempuyang memiliki latar belakang Gunung Agung yang memukau dan sebagai tempat Pura Sad Kahyangan Lempuyang Luhur kemurnian alamnya, terutama kawasan hutan, tidak terjamah sehingga keindahan lembah, serta pesisir Bali Timur, terlihat menakjubkan. Pohon-pohon tropis tumbuh subur, cocok menjadi paru-paru Pulau Dewata.",
            "Pura Besakih adalah pura terbesar di Bali terletak di ketinggian 1000 mdpl yang berlokasi di lereng Gunung Agung.",
            "Pura Ulun Danu Beratan terletak di Bedugul, desa Candi Kuning, Tabanan, Bali. Pura Ulun Danu Beratan adalah pura tempat pemujaan Dewi Danu (dewi kemakmuran) di sebelahnya terdapat danau beratan yang memiliki pemandangan indah dengan kedalaman sekitar 23 m."};

    Context mContext;
    LayoutInflater layoutInflater;

    public SubAdapterPura(Context mContext) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list,parent,false);
        SubAdapterPura.ViewHolder holder = new SubAdapterPura.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txt.setText(namaPura[position]);
        holder.img.setImageResource(pura[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kirimData = new Intent(mContext,DetailActivity.class);
                kirimData.putExtra("Nama",namaPura[position]);
                kirimData.putExtra("img",pura[position]);
                kirimData.putExtra("Detail",detail[position]);
                mContext.startActivity(kirimData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return namaPura.length;
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
