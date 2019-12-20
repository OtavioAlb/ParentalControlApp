package br.com.usp.parentalcontrol;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class FaqExpand extends ExpandableGroup<FaqGroup> {

    public FaqExpand(String title, List<FaqGroup> items) {
        super(title, items);
    }

}
