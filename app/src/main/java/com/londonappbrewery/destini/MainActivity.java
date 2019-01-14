package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;

    String mT1Story;
    String mT1Ans1;
    String mT1Ans2;

    String mT2Story;
    String mT2Ans1;
    String mT2Ans2;

    String mT3Story;
    String mT3Ans1;
    String mT3Ans2;

    String mT4End;
    String mT5End;
    String mT6End;

    // STEP 7: Define an Index variable
    int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryPath");
        } else {
            mStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        mT1Story = getResources().getString(R.string.T1_Story);
        mT1Ans1 = getResources().getString(R.string.T1_Ans1);
        mT1Ans2 = getResources().getString(R.string.T1_Ans2);

        mT2Story = getResources().getString(R.string.T2_Story);
        mT2Ans1 = getResources().getString(R.string.T2_Ans1);
        mT2Ans2 = getResources().getString(R.string.T2_Ans2);

        mT3Story = getResources().getString(R.string.T3_Story);
        mT3Ans1 = getResources().getString(R.string.T3_Ans1);
        mT3Ans2 = getResources().getString(R.string.T3_Ans2);

        mT4End = getResources().getString(R.string.T4_End);
        mT5End = getResources().getString(R.string.T5_End);
        mT6End = getResources().getString(R.string.T6_End);


        updateStory();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topButtonDisplay();
                updateStory();
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomButtonDisplay();
                updateStory();
            }
        });

    }

    private void updateStory() {

        // Step 8: To check the state of the game
        if (mStoryIndex == 1) {
            mStoryTextView.setText(mT1Story);
            mButtonTop.setText(mT1Ans1);
            mButtonBottom.setText(mT1Ans2);
        } else if (mStoryIndex == 2) {
            mStoryTextView.setText(mT2Story);
            mButtonTop.setText(mT2Ans1);
            mButtonBottom.setText(mT2Ans2);
        } else if (mStoryIndex == 3) {
            mStoryTextView.setText(mT3Story);
            mButtonTop.setText(mT3Ans1);
            mButtonBottom.setText(mT3Ans2);
        } else if (mStoryIndex == 4) {
            mStoryTextView.setText(mT4End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else if (mStoryIndex == 5) {
            mStoryTextView.setText(mT5End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else if (mStoryIndex == 6) {
            mStoryTextView.setText(mT6End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else {
            mStoryTextView.setText(mT1Story);
            mButtonTop.setText(mT1Ans1);
            mButtonBottom.setText(mT1Ans2);
        }
    }

    private void topButtonDisplay(){
        // Change the text in story TextView
        // Change the text on top and bottom buttons

        // 1. Top button displaying T1_Ans1 is clicked; change story to T3_Story.
        // 2. Top button display T3_Ans1.
        // 3. Bottom button display T3_Ans2.

        String topButtonText = mButtonTop.getText().toString();

        if (topButtonText.equals(mT1Ans1)) {
            mStoryIndex = 3;
        } else if (topButtonText.equals(mT2Ans1)) {
            mStoryIndex = 3;
        } else {
            mStoryIndex = 6;
        }
    }

    private void bottomButtonDisplay(){
        // Change the text in story TextView
        // Change the text on top and bottom buttons

        // 1. Bottom button displaying T1_Ans2 is clicked; change story to T2_Story.
        // 2. Top button display T2_Ans1.
        // 3. Bottom button display T2_Ans2.

        String bottomButtonText = mButtonBottom.getText().toString();

        if (bottomButtonText.equals(mT1Ans2)) {
            mStoryIndex = 2;
        } else if (bottomButtonText.equals(mT2Ans2)) {
            mStoryIndex = 4;
        } else {
            mStoryIndex = 5;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryPath", mStoryIndex);
    }

}
