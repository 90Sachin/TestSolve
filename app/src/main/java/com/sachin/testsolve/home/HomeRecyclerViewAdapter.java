package com.sachin.testsolve.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sachin.testsolve.R;
import com.sachin.testsolve.util.CommonMethod;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Windows on 19-07-2017.
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = HomeRecyclerViewAdapter.class.getSimpleName();

    private Context context;
    private List<Movie> list;
    private OnItemClickListener onItemClickListener;

    public HomeRecyclerViewAdapter(Context context, List<Movie> list,
                                   OnItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textMovieName)
        TextView textMovieName;
        @BindView(R.id.textMovieUploadTime)
        TextView textMovieUploadTime;
        @BindView(R.id.textMovieDescription)
        TextView textVideoDescription;
        @BindView(R.id.imageMoviePoster)
        ImageView imageMoviePoster;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(final Movie model,
                         final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getLayoutPosition());

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout_media_item, parent, false);
        ButterKnife.bind(this, view);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie item = list.get(position);

        //Todo: Setup viewholder for item 
        holder.bind(item, onItemClickListener);
        holder.textMovieName.setText(item.getTitle());
        holder.textVideoDescription.setText(item.getOverview());
        holder.textMovieUploadTime.setText(item.getReleaseDate());
        //Date date=CommonMethod.convertDate(item.getReleaseDate());
        //DateUtils.getRelativeTimeSpanString (date.getTime(),System.currentTimeMillis(),DateUtils.HOUR_IN_MILLIS,1);
        /* if(date!=null) {
            String strDate =  DateUtils.getRelativeTimeSpanString(date.getTime()).toString();
            strDate= DateUtils.getRelativeDateTimeString(context,date.getTime(),DateUtils.HOUR_IN_MILLIS ,DateUtils.DAY_IN_MILLIS,1).toString();
        }*/
            CommonMethod.ShowImagePicasso(context,"https://image.tmdb.org/t/p/w640"+item.getPosterPath(),R.drawable.loading,holder.imageMoviePoster);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}