package xyz.siavash.storygame.presentation.feature.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.siavash.storygame.R;
import xyz.siavash.storygame.presentation.ComponentProvider;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends MvpFragment<HomeView,HomePresenter> implements HomeView {

  public HomeFragment() {
    // Required empty public constructor
  }

  /**
   * Creates a new presenter instance, if needed. Will reuse the previous presenter instance if
   * {@link #setRetainInstance(boolean)} is set to true. This method will be called from
   * {@link #onViewCreated(View, Bundle)}
   */
  @Override
  public HomePresenter createPresenter() {
    return new HomePresenterInjector(((ComponentProvider)getActivity()).getComponent()).getPresenter();
  }

  public static HomeFragment newInstance() {
    HomeFragment fragment = new HomeFragment();
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    ButterKnife.bind(this,view);
    return view;
  }

  @OnClick(R.id.home_create_game)
  public void onCreateGameClicked() {
    getPresenter().onCreateGameClicked();
  }

  @OnClick(R.id.home_join_game)
  public void onJoinGameClicked(){
    getPresenter().onJoinGameClicked();
  }

  @Override
  public void goToCreateGamePage() {

  }

  @OnClick(R.id.home_join_game)
  @Override
  public void goToMatchesPage() {

  }
}
