package br.com.usp.parentalcontrol;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_intro);

        addSlide(AppIntroFragment.newInstance("Welcome to the parental control tool", "App to assist you in protecting your child's data by creating privacy rules.",
                R.drawable.protection, ContextCompat.getColor(getApplicationContext(), R.color.blue)));

        addSlide(AppIntroFragment.newInstance("Privacy rules!","By creating privacy rules, you can configure, according to your preferences, which data can be collected and who can collect it.",
                R.drawable.rule_intro, ContextCompat.getColor(getApplicationContext(), R.color.blue)));

        addSlide(AppIntroFragment.newInstance("Visit parent area","The parent area has contents and functionalities to help understand this parental control tool " +
                        "and the toy technological environment. Learn about data manipulation, the risks associated with using a toy and more!",
                R.drawable.parent, ContextCompat.getColor(getApplicationContext(), R.color.blue)));

        addSlide(AppIntroFragment.newInstance("Let's go!", "First, you need to create the parent/guardian profile to gain access to the tool.",
                R.drawable.success, ContextCompat.getColor(getApplicationContext(), R.color.blue)));

        showSkipButton(false);

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent profileIntent = new Intent(getApplicationContext(), ParentProfileActivity.class);
        startActivity(profileIntent);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}

