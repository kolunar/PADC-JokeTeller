package com.padc.aml.jokes.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.aml.jokes.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TITLE = "title";
    private static final String ARG_IMAGE_ID = "imageId";
    private static final String ARG_CONTENT = "content";

    // TODO: Rename and change types of parameters
    private String mTitle;
    private int mImageId;
    private String mContent;

    private OnFragmentInteractionListener mListener;

    public ViewFragment() {
        // Required empty public constructor
    }

    public static ViewFragment newInstance(String title, int imageId, String content) {
        ViewFragment fragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putInt(ARG_IMAGE_ID, imageId);
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mImageId = getArguments().getInt(ARG_IMAGE_ID);
            mContent = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_view, container, false);

        final TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);
        final TextView tvContent = (TextView)view.findViewById(R.id.tvContent);
        final ImageView imgContent = (ImageView)view.findViewById(R.id.imgContent);

        tvTitle.setText(mTitle);
        imgContent.setImageResource(mImageId);
        tvContent.setText(mContent);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private ControllerView controller;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ControllerView){
            controller = (ControllerView) context;
        }
        else{
            throw new RuntimeException("Activity is not implementing required controller for ViewFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
        controller = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public interface ControllerView {
        void onFragmentChange();
    }
}
