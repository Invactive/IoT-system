package com.example.sensehat.ui.leds;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.sensehat.databinding.FragmentLedsBinding;
import com.example.sensehat.ui.charts.ChartsViewModel;

public class LedsFragment extends Fragment {

    private FragmentLedsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LedsViewModel LedsViewModel =
                new ViewModelProvider(requireActivity()).get(LedsViewModel.class);

        binding = FragmentLedsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Get grid layout
        final GridLayout gridLayout = binding.gridLayout;

        //append buttons to grid to create 8x8 matrix
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button button = new Button(requireContext());
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.height = GridLayout.LayoutParams.WRAP_CONTENT;
                params.columnSpec = GridLayout.spec(j);
                params.rowSpec = GridLayout.spec(i);
                params.width = 115;
                button.setLayoutParams(params);
                button.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                button.setId(i * 8 + j);
                gridLayout.addView(button);
            }
            }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button button = (Button) gridLayout.getChildAt(i * 8 + j);
                button.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(30,53,73)));
            }
        }

        Button button = (Button) gridLayout.getChildAt(3 * 8 + 2);
        button.setBackgroundTintList(ColorStateList.valueOf(Color.rgb( 252,53,73)));

//        LedsViewModel.getText().observe(getViewLifecycleOwner(), data -> {
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    Button button = (Button) gridLayout.getChildAt(i * 8 + j);
//                    button.setBackgroundColor(Color.argb(100,251,127,127));
////                    button.setText(data[i][j]);
////                    if (data[i][j].equals("A")) {
////                        button.setBackgroundColor(Color.RED);
////                    } else {
////                        button.setBackgroundColor(Color.GREEN);
////                    }
//                }
//            }
//        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}