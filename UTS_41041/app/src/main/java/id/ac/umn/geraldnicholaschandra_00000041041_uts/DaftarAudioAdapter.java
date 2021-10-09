package id.ac.umn.geraldnicholaschandra_00000041041_uts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

import id.ac.umn.geraldnicholaschandra_00000041041_uts.DetilAudioActivity;
import id.ac.umn.geraldnicholaschandra_00000041041_uts.SumberAudio;

public class DaftarAudioAdapter extends
        RecyclerView.Adapter<DaftarAudioAdapter.ItemAudioViewHolder> {
    private LinkedList<SumberAudio> mDaftarAudio;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarAudioAdapter(Context context, LinkedList<SumberAudio> daftarAudio){
        this.mContext = context;
        this.mDaftarAudio = daftarAudio;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DaftarAudioAdapter.ItemAudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.audio_item_layout,
                parent, false);
        return new ItemAudioViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarAudioAdapter.ItemAudioViewHolder holder, int position) {
        SumberAudio mSumberAudio = mDaftarAudio.get(position);
        holder.tvJudul.setText(mSumberAudio.getJudul());
        holder.tvKeterangan.setText(mSumberAudio.getKeterangan());

    }

    @Override
    public int getItemCount() {
        return mDaftarAudio.size();
    }

    class ItemAudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvJudul;
        private TextView tvKeterangan;
        private DaftarAudioAdapter mAdapter;
        private int mPosisi;
        private SumberAudio mSumberAudio;
        private ImageView delete;

        public ItemAudioViewHolder(@NonNull View itemView, DaftarAudioAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
            itemView.setOnClickListener(this);

            delete = itemView.findViewById(R.id.delete);
            delete.setOnClickListener(view -> delete(getPosition()));
        }

        public void delete(int delete) {
            mDaftarAudio.remove(delete);
            notifyItemRemoved(delete);
            notifyItemRangeChanged(delete, mDaftarAudio.size());
        }

        @Override
        public void onClick(View v) {
            mPosisi = getLayoutPosition();
            mSumberAudio = mDaftarAudio.get(mPosisi);
            Intent detilInten = new Intent(mContext, DetilAudioActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetilAudio", mSumberAudio);
            detilInten.putExtras(bundle);
            mContext.startActivity(detilInten);
        }
    }
}
