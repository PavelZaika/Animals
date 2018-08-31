package com.example.loki.animals;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class HeadImgFragment extends Fragment {


    public int[] backgroundImg = {R.drawable.one_back, R.drawable.two_back, R.drawable.thirteen_back, R.drawable.four_back, R.drawable.five_back, R.drawable.six_back,
            R.drawable.seven_back, R.drawable.eight_back, R.drawable.nine_back, R.drawable.ten_back, R.drawable.eleven_back, R.drawable.twelve_back, R.drawable.thirteen_back,
            R.drawable.fourteen_back, R.drawable.fifteen_back, R.drawable.sixteen_back, R.drawable.seventeen_back, R.drawable.eighteen_back, R.drawable.nineteen_back, R.drawable.twenty_back,
            R.drawable.twenty_one_back, R.drawable.twenty_two_back, R.drawable.twenty_three_back, R.drawable.twenty_four_back, R.drawable.twenty_five_back, R.drawable.twenty_six_back,
            R.drawable.twenty_seven_back, R.drawable.twenty_eight_back};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.head_img_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        changeBackground();
        changeImg();
        clickableStars();

    }

    private void clickableStars() {

        final ImageView starOneOne = getView().findViewById(R.id.star_line_11);
        final ImageView starOneTwo = getView().findViewById(R.id.star_line_12);
        final ImageView starOneThree = getView().findViewById(R.id.star_line_13);

        final ImageView starTwoOne = getView().findViewById(R.id.star_line_21);
        final ImageView starTwoTwo = getView().findViewById(R.id.star_line_22);
        final ImageView starTwoThree = getView().findViewById(R.id.star_line_23);

        final ImageView starThreeOne = getView().findViewById(R.id.star_line_31);
        final ImageView starThreeTwo = getView().findViewById(R.id.star_line_32);
        final ImageView starThreeThree = getView().findViewById(R.id.star_line_33);

        final ImageView starFourOne = getView().findViewById(R.id.star_line_41);
        final ImageView starFourTwo = getView().findViewById(R.id.star_line_42);
        final ImageView starFourThree = getView().findViewById(R.id.star_line_43);
        final ImageView starFourFour = getView().findViewById(R.id.star_line_44);

        View.OnClickListener onClickListenerStars = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.star_line_11:
                        starOneOne.setVisibility(View.INVISIBLE);
                        changeImg();
                        break;
                    case R.id.star_line_12:
                        starOneTwo.setVisibility(View.INVISIBLE);
                        starThreeOne.setVisibility(View.VISIBLE);


                        break;
                    case R.id.star_line_13:
                        starOneThree.setVisibility(View.INVISIBLE);
                        starThreeTwo.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_21:
                        starTwoOne.setVisibility(View.INVISIBLE);
                        starOneThree.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_22:
                        starTwoTwo.setVisibility(View.INVISIBLE);
                        starThreeThree.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_23:
                        starTwoThree.setVisibility(View.INVISIBLE);
                        starFourFour.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_31:
                        starThreeOne.setVisibility(View.INVISIBLE);
                        starFourThree.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_32:
                        starThreeTwo.setVisibility(View.INVISIBLE);
                        starTwoOne.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_33:
                        starThreeThree.setVisibility(View.INVISIBLE);
                        starFourOne.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_41:
                        starFourOne.setVisibility(View.INVISIBLE);
                        starTwoTwo.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_42:
                        starFourTwo.setVisibility(View.INVISIBLE);
                        starTwoThree.setVisibility(View.VISIBLE);
                        starOneOne.setVisibility(View.VISIBLE);  //подключаем звезду 11, которая делает чейндж имедж
                        break;
                    case R.id.star_line_43:
                        starFourThree.setVisibility(View.INVISIBLE);
                        starOneTwo.setVisibility(View.VISIBLE);
                        break;
                    case R.id.star_line_44:
                        starFourFour.setVisibility(View.INVISIBLE);
                        starFourTwo.setVisibility(View.VISIBLE);
                        break;
                }


            }
        };
        starOneOne.setOnClickListener(onClickListenerStars);
        starOneTwo.setOnClickListener(onClickListenerStars);
        starOneThree.setOnClickListener(onClickListenerStars);

        starTwoOne.setOnClickListener(onClickListenerStars);
        starTwoTwo.setOnClickListener(onClickListenerStars);
        starTwoThree.setOnClickListener(onClickListenerStars);

        starThreeOne.setOnClickListener(onClickListenerStars);
        starThreeTwo.setOnClickListener(onClickListenerStars);
        starThreeThree.setOnClickListener(onClickListenerStars);

        starFourOne.setOnClickListener(onClickListenerStars);
        starFourTwo.setOnClickListener(onClickListenerStars);
        starFourThree.setOnClickListener(onClickListenerStars);
        starFourFour.setOnClickListener(onClickListenerStars);
    }

    private void changeImg() { // клик по объекту для смены животины


        final ImageView headAnimals = getView().findViewById(R.id.img_with_Animals);

        motionImg(headAnimals);

        headAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // клик по объекту для смены животины


                int[] mainImg = {R.drawable.panda, R.drawable.dog, R.drawable.hipo};
                int randImj = (int) Math.floor(Math.random() * mainImg.length);

                headAnimals.setImageResource(mainImg[randImj]);

                Toast.makeText(getContext(), "DoneImj", Toast.LENGTH_SHORT).show();

                motionImg(headAnimals);

            }
        });
    }

    private void motionImg(ImageView view) { // анимация для объекта. прописана в xml
        Animation startRotateAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.translate_img);
        view.startAnimation(startRotateAnimation);
    }

    @SuppressLint("ClickableViewAccessibility")   //свайп экрана для смены фона
    private void changeBackground() {

        final ConstraintLayout constraintLayout = getView().findViewById(R.id.head_img_layout);
        constraintLayout.setBackgroundResource(R.drawable.fifteen_back);
        constraintLayout.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {

            public void onSwipeLeft() {
                //обработка свайпа влево
                int randBackImj = (int) Math.floor(Math.random() * backgroundImg.length);

             //   constraintLayout.setBackgroundColor(backgroundImg[randBackImj]);
                constraintLayout.setBackgroundResource(backgroundImg[randBackImj]);
                Toast.makeText(getContext(), "left"+randBackImj, Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                //обработка свайпа вправо
                int randBackImj = (int) Math.floor(Math.random() * backgroundImg.length);
              //  constraintLayout.setBackgroundColor(backgroundImg[randBackImj]);
                constraintLayout.setBackgroundResource(backgroundImg[randBackImj]);
                Toast.makeText(getContext(), "right"+randBackImj, Toast.LENGTH_SHORT).show();
            }
        });


    }


}