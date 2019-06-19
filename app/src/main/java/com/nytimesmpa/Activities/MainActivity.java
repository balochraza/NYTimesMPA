package com.nytimesmpa.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nytimesmpa.Adapter.MostViewArticleAdapter;
import com.nytimesmpa.BaseClasses.BaseActivity;
import com.nytimesmpa.Model.MostViewArticleModel;
import com.nytimesmpa.R;
import com.nytimesmpa.Retrofit.WebResponse;
import com.nytimesmpa.Retrofit.WebService;
import com.nytimesmpa.Retrofit.WebServiceFactory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {

    private RecyclerView rvArticle;
    private ProgressBar progressBar;
   private MostViewArticleAdapter adapter;


    public ArrayList<MostViewArticleModel> mostViewArticleModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvArticle = findViewById(R.id.rv_articles);
        progressBar = findViewById(R.id.progress_bar);
        init();
    }

    private void init(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvArticle.setLayoutManager(linearLayoutManager);
        adapter = new MostViewArticleAdapter(context,mostViewArticleModelArrayList);
        rvArticle.setAdapter(adapter);
        if (isNetworkConnected()) {
            getDataServer();
        }
        else {
         makeToast("Check Your Internet Connection");
        }
    }

    private void getDataServer() {


        progressBar.setVisibility(View.VISIBLE);

      Call<WebResponse<ArrayList<MostViewArticleModel>>> myCall= WebServiceFactory.getClient().getMostPopularArticles();

      myCall.enqueue(new Callback<WebResponse<ArrayList<MostViewArticleModel>>>() {
          @Override
          public void onResponse(Call<WebResponse<ArrayList<MostViewArticleModel>>> call, Response<WebResponse<ArrayList<MostViewArticleModel>>> response) {
              mostViewArticleModelArrayList.addAll(response.body().results);
             adapter.notifyDataSetChanged();
              progressBar.setVisibility(View.GONE);
          }

          @Override
          public void onFailure(Call<WebResponse<ArrayList<MostViewArticleModel>>> call, Throwable t) {

              progressBar.setVisibility(View.GONE);
          }
      });

    }


}
