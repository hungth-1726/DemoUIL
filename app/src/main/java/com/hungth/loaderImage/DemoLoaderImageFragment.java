package com.hungth.loaderImage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class DemoLoaderImageFragment extends Fragment {
    private static final String URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoun4AJtfk5wAAAacsWpl9vzDX7one70TUoYpnbfjY8mJkazRd";

    private Button buttonShowImage;
    private ImageView imageBackground;
    private ImageLoader imageLoader;

    public static DemoLoaderImageFragment getInstance() {
        return new DemoLoaderImageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_demo_loader_image, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageBackground = getActivity().findViewById(R.id.image_loader);
        buttonShowImage = getActivity().findViewById(R.id.button);
        buttonShowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage();
            }
        });
    }

    private void showImage() {
        imageLoader = ImageLoader.getInstance();
        if (getActivity() != null) {
            imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));
        }
        imageLoader.displayImage(URL, imageBackground);
    }
}
