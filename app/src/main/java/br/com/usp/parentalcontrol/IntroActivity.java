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

        addSlide(AppIntroFragment.newInstance("Bem-vindo à ferramenta de controle parental", "App para auxiliar você na proteção dos dados do seu filho, por meio da criação de regras de privacidade.",
                R.drawable.protection, ContextCompat.getColor(getApplicationContext(), R.color.blue)));

        addSlide(AppIntroFragment.newInstance("Regras de privacidade!","Com a criação de regras de privacidade, é possível configurar, de acordo com as suas preferências, quais dados do brinquedo poderão ser coletados e quem poderá coletá-los.",
                R.drawable.rule_intro, ContextCompat.getColor(getApplicationContext(), R.color.blue)));

        addSlide(AppIntroFragment.newInstance("Acesse a área dos pais","A área dos pais possui conteúdos e funcionalidades para auxiliar a entender esta ferramenta de controle parental e o ambiente tecnológico do brinquedo. Aprenda sobre a manipulação de dados" +
                        ", sobre os riscos associados ao uso do brinquedo e muito mais!",
                R.drawable.parent, ContextCompat.getColor(getApplicationContext(), R.color.blue)));

        addSlide(AppIntroFragment.newInstance("Vamos lá!", "Primeiro, vamos criar o perfil dos pais ou responsáveis para ter acesso à ferramenta.",
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

