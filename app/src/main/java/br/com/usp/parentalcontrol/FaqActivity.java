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

        resposta1.add(new FaqGroup("Please follow these steps: "+
                "\n1.Close all other apps on your device." +
                "\n2.Set screen brightness to 75%." +
                "\n3.Make sure your device is connected to the same home network you are pairing your Toy to." +
                "\n4.Go into your phone/table settings.  Make sure powersave is off." +
                "\n5.Confirm you have entered your Wi-Fi password into the Company app correctly, please note passwords are case sensitive." +
                "\n6. Ensure the status LED is blinking on the Toy box. Place the opposite side of the Toybox (the side labelled sensor) on the phone screen, facedown." +
                "\n7.Your ToyBox will stop blinking while your app flashes then resume blinking, you should see a solid green light, after successful pairing, the status LED " +
                "on the Toybox will pulse green."));

        /*resposta1.add(new FaqGroup("Please follow these steps:" +
                "\n1.Close all other apps on your device." +
                "\n2.Set screen brightness to 75%." +
                "\n3.Make sure your device is connected to the same home network you are pairing your Toy to." +
                "\n4.Go into your phone/table settings.  Make sure powersave is off." +
                "\n5.Confirm you have entered your Wi-Fi password into the Toymail app correctly, please note passwords are case sensitive." +
                "\n6.Ensure the status LED is blinking on the Toy box. Place the opposite side of the Toybox (the side labelled sensor) on the phone screen, facedown." +
                "\n7.Your Toybox will stop blinking while your app flashes then resume blinking, you should see a solid green light, after successful pairing, the status LED " +
                "on the Toybox will pulse green." +
                "\n\n" +
                "*Please note Toys are intended to connect to 2.4 GhZ home networks, not 5 GhZ networks." +
                "\n*Pairing may be affected by a device's tempered glass or screen protectors." +
                "\n\n" +
                "If you are still having trouble, please contact us at team@toymailco.com." +
                "\n" +
                "When emailing, please provide your device type and indicate whether or not you saw a solid green light on your Toy and the color it was blinking."));*/

        FaqExpand pergunta1 = new FaqExpand("How do I set up my toy?", resposta1);
        perguntas.add(pergunta1);

        ArrayList<FaqGroup> resposta2 = new ArrayList<>();
        resposta2.add(new FaqGroup("There is no physical switch, but parents can modify the toy's sleep and wake times in the " +
                "Company Cloud settings. Just select the Sleep applet, bed buddy then schedule the desired sleep setting. Your " +
                "child's Toy will be unable to play messages, will whisper, \"I'm getting Sleepie\" and play white noise if " +
                "your child presses any buttons between the set sleep and wake times. During this time your child's Toy will " +
                "not wake up and connect to WIFI."));

        FaqExpand pergunta2 = new FaqExpand("Is there an on/off switch on the toy?", resposta2);
        perguntas.add(pergunta2);

        ArrayList<FaqGroup> resposta3 = new ArrayList<>();
        resposta3.add(new FaqGroup("Your Toy can remember up to 5 Wi-Fi networks, allowing your child to take their Toy to their " +
                "favorite locations without the need for reconnecting each time." +
                "\n To save a new network in your child's Toy please do the following:"+
                "\n \n" +
                        "1.Make sure your phone is connected to the same new Wi-Fi network you want to save in your Toy." +
                        "\n 2.Go to the settings menu in the Company app, then find your child's profile under 'My Kid's Toys'." +
                        "\n 3.Choose 'Wi-Fi Networks' then click the Add button."));

        /*resposta3.add(new FaqGroup("Your Toy can remember up to 5 Wi-Fi networks, allowing your child to take their Toy " +
                "to their favorite locations without the need for reconnecting each time." +
                "\nTo save a new network in your child's Toy please do the following:" +
                "\n\n" +
                "1.Make sure your phone is connected to the same new Wi-Fi network you want to save in your Toy." +
                "\n2.Go to the settings menu in the Toymail app, then find your child's profile under 'My Kid's Toys'." +
                "\n3.Choose 'Wi-Fi Networks' then click the Add button."));*/

        FaqExpand pergunta3 = new FaqExpand("How can I connect the Toy to another network?", resposta3);
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
