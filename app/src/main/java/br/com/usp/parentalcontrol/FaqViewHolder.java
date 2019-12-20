package br.com.usp.parentalcontrol;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class FaqViewHolder extends ChildViewHolder {

   private TextView txtAnswer;

    public FaqViewHolder(View itemView) {
        super(itemView);
        txtAnswer = itemView.findViewById(R.id.txtFaq);
    }

    public void bind(FaqGroup faqGroup){
        txtAnswer.setText(faqGroup.answer);
    }
}
