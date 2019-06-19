package com.nytimesmpa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nytimesmpa.Activities.ArticleDetailActivity;
import com.nytimesmpa.BaseClasses.BaseActivity;
import com.nytimesmpa.Model.MostViewArticleModel;
import com.nytimesmpa.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MostViewArticleAdapter  extends RecyclerView.Adapter<MostViewArticleAdapter.ViewHolder> {


    private Context context;
    private ArrayList<MostViewArticleModel> items;

    public MostViewArticleAdapter(Context context, ArrayList<MostViewArticleModel> items) {
        this.context = context;
        this.items = items;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.row_articles, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title,bylineTxt,listDateTxt;
        ImageView imageView;
        ConstraintLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemLayout =  itemView.findViewById(R.id.item_layout);
            title =  itemView.findViewById(R.id.title);
            bylineTxt =  itemView.findViewById(R.id.author);

            listDateTxt =  itemView.findViewById(R.id.date);
            imageView =  itemView.findViewById(R.id.image);

            itemLayout.setOnClickListener(this);

        }

        public void bind(MostViewArticleModel mostViewArticle) {
            title.setText(mostViewArticle.title);
            bylineTxt.setText(mostViewArticle.byline);
            listDateTxt.setText(mostViewArticle.published_date);

            if(mostViewArticle.media!=null && mostViewArticle.media.get(0).mediametadata!=null){
                String imageUrl = mostViewArticle.media.get(0).mediametadata.get(0).url;
                imageView.setVisibility(View.VISIBLE);
                Picasso.with(context)
                        .load(imageUrl)
                        .fit()
                        .into(imageView);

            }else {
                imageView.setVisibility(View.GONE);
            }

            itemView.setTag(mostViewArticle);

        }


        @Override
        public void onClick(View v) {
            if (v==itemLayout){
                Intent intent = new Intent(context,ArticleDetailActivity.class);
                intent.putExtra(BaseActivity.articleDetailURL,items.get(getAdapterPosition()).url);
                context.startActivity(intent);
            }
        }
    }
}
