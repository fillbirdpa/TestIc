/*
 * Copyright (C) 2015 takahirom
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.pengao.mytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pengao.mytest.fragment.ExitFragmentTransition;
import com.example.pengao.mytest.fragment.FragmentTransition;


public class SubFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sub, container, false);
        final ExitFragmentTransition exitFragmentTransition
                = FragmentTransition
                .with(this)
                .interpolator(new LinearOutSlowInInterpolator())
                .to(v.findViewById(R.id.sub_imageView))
                .duration(400)
                .start(savedInstanceState);
//        exitFragmentTransition.exitListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                Log.d("TAG", "onAnimationStart: ");
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                Log.d("TAG", "onAnimationEnd: ");
//            }
//        }).interpolator(new FastOutSlowInInterpolator());n
//        exitFragmentTransition.startExitListening();

        v.findViewById(R.id.sub_imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFragmentTransition.startExitAnimation(400, null);
            }
        });

        return v;
    }
}
