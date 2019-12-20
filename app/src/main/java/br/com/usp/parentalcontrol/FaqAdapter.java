package br.com.usp.parentalcontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class FaqAdapter extends ExpandableRecyclerViewAdapter<FaqGroupViewHolder, FaqViewHolder> {

    public FaqAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public FaqGroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer, parent, false);
        return new FaqGroupViewHolder(view);
    }

    @Override
    public FaqViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faq, parent, false);
        return new FaqViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(FaqViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final FaqGroup faqGroup = (FaqGroup) group.getItems().get(childIndex);
        holder.bind(faqGroup);

    }

    @Override
    public void onBindGroupViewHolder(FaqGroupViewHolder holder, int flatPosition, ExpandableGroup group) {
        final FaqExpand faqExpand = (FaqExpand) group;
        holder.bind(faqExpand);
    }
}
