package br.com.usp.parentalcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FaqActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button closeBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        recyclerView = findViewById(R.id.recycler_faq);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<FaqExpand> perguntas = new ArrayList<>();

        ArrayList<FaqGroup> resposta1 = new ArrayList<>();

        resposta1.add(new FaqGroup("Por favor, siga estes passos: "+
                "\n1.Feche todos os outros aplicativos no seu dispositivo." +
                "\n2.Defina o brilho da tela para 75%." +
                "\n3.Certifique-se de que seu dispositivo esteja conectado à mesma rede doméstica com a qual você está emparelhando o seu Talkie." +
                "\n4.Vá às configurações do seu telefone / mesa. Verifique se o PowerSave está desativado." +
                "\n5.Confirme que você digitou sua senha de Wi-Fi no aplicativo Toymail corretamente, observe que as senhas diferenciam maiúsculas de minúsculas." +
                "\n6.Verifique se o LED de status está piscando na caixa do Talkie. Coloque o lado oposto do Talkiebox (o sensor rotulado na lateral) na tela do telefone, com a face para baixo." +
                "\n7.O seu Talkiebox para de piscar enquanto o aplicativo pisca e continua a piscar. Você verá uma luz verde contínua, após o emparelhamento bem-sucedido, o LED de status" +
                "no Talkiebox pulsará em verde."));

        /*resposta1.add(new FaqGroup("Please follow these steps:" +
                "\n1.Close all other apps on your device." +
                "\n2.Set screen brightness to 75%." +
                "\n3.Make sure your device is connected to the same home network you are pairing your Talkie to." +
                "\n4.Go into your phone/table settings.  Make sure powersave is off." +
                "\n5.Confirm you have entered your Wi-Fi password into the Toymail app correctly, please note passwords are case sensitive." +
                "\n6.Ensure the status LED is blinking on the Talkie box. Place the opposite side of the Talkiebox (the side labelled sensor) on the phone screen, facedown." +
                "\n7.Your Talkiebox will stop blinking while your app flashes then resume blinking, you should see a solid green light, after successful pairing, the status LED " +
                "on the Talkiebox will pulse green." +
                "\n\n" +
                "*Please note Talkies are intended to connect to 2.4 GhZ home networks, not 5 GhZ networks." +
                "\n*Pairing may be affected by a device's tempered glass or screen protectors." +
                "\n\n" +
                "If you are still having trouble, please contact us at team@toymailco.com." +
                "\n" +
                "When emailing, please provide your device type and indicate whether or not you saw a solid green light on your Talkiebox and the color it was blinking."));*/

        FaqExpand pergunta1 = new FaqExpand("Como faço para configurar meu brinquedo?", resposta1);
        perguntas.add(pergunta1);

        ArrayList<FaqGroup> resposta2 = new ArrayList<>();
        resposta2.add(new FaqGroup("Não há opção física, mas os pais podem modificar os horários de sono e vigília do " +
                "brinquedo nas configurações da nuvem do Toymail. Basta selecionar o applet Sleep, companheiro de cama e agendar " +
                "a configuração de sono desejada. O Talkie do seu filho não poderá reproduzir mensagens, sussurrará: Estou usando " +
                "o Sleepie e reproduzirá ruído branco se o seu filho pressionar qualquer botão entre os horários de sono e " +
                "vigília definidos. Durante esse período, o Talkie do seu filho não acorda e se conecta ao WIFI."));

        FaqExpand pergunta2 = new FaqExpand("Existe um botão liga/desliga no brinquedo?", resposta2);
        perguntas.add(pergunta2);

        ArrayList<FaqGroup> resposta3 = new ArrayList<>();
        resposta3.add(new FaqGroup("Seu Talkie pode se lembrar de até 5 redes Wi-Fi, permitindo que seu filho leve o Talkie "+
                "para seus locais favoritos, sem a necessidade de reconectar cada vez." +
                "\nPara salvar uma nova rede no Talkie do seu filho, faça o seguinte:"+
                "\n \n" +
                        "1. Verifique se o telefone está conectado à mesma nova rede Wi-Fi que você deseja salvar no seu Talkie." +
                        "\n2. Vá para o menu de configurações no aplicativo Toymail e encontre o perfil do seu filho em 'Meus brinquedos infantis'." +
                        "\n3.Escolha 'Redes Wi-Fi' e clique no botão Adicionar."));

        /*resposta3.add(new FaqGroup("Your Talkie can remember up to 5 Wi-Fi networks, allowing your child to take their Talkie " +
                "to their favorite locations without the need for reconnecting each time." +
                "\nTo save a new network in your child's Talkie please do the following:" +
                "\n\n" +
                "1.Make sure your phone is connected to the same new Wi-Fi network you want to save in your Talkie." +
                "\n2.Go to the settings menu in the Toymail app, then find your child's profile under 'My Kid's Toys'." +
                "\n3.Choose 'Wi-Fi Networks' then click the Add button."));*/

        FaqExpand pergunta3 = new FaqExpand("Como conectar o Talkie a outra rede?", resposta3);
        perguntas.add(pergunta3);

        FaqAdapter faqAdapter = new FaqAdapter(perguntas);
        recyclerView.setAdapter(faqAdapter);

        closeBt = findViewById(R.id.closeBt);
        closeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
