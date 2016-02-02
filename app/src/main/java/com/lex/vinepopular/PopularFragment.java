package com.lex.vinepopular;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.lex.vinepopular.adapters.BindingAdapter;
import com.lex.vinepopular.managers.ApiManager;
import com.lex.vinepopular.models.PopularVidsModel;
import com.lex.vinepopular.models.PopularVidsViewModel;
import com.lex.vinepopular.requests.BaseRequest;
import com.lex.vinepopular.vinepopular.R;
import com.lex.vinepopular.vinepopular.databinding.FragmentPopularBinding;


public class PopularFragment extends BaseFragment {

    private FragmentPopularBinding binding;
    private PopularVidsViewModel viewModel;
    private RecyclerView gridRecyclerView;
    private BindingAdapter adapter;


    public static PopularFragment newInstance() {
        PopularFragment fragment = new PopularFragment();
        //set args
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //get args
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false);
        viewModel = new PopularVidsViewModel();
        binding.setPopularVidsViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    protected void setupView(View view) {
        loadData();
    }

    private void loadData() {
        ApiManager.getInstance().getPopularVids(new BaseRequest.RequestCompletion<PopularVidsModel>() {
            @Override
            public void onResponse(PopularVidsModel data) {
                Log.i("PopularFragment", data.toString());
                viewModel.setPopularVids(data);
                setupViewComplete();
            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_LONG).show();
                setupViewComplete();
            }
        });
    }
}
