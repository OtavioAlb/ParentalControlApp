package br.com.usp.parentalcontrol;

import android.os.Parcel;
import android.os.Parcelable;

public class FaqGroup implements Parcelable {

    public final String answer;

    public FaqGroup(String answer) {
        this.answer = answer;
    }

    protected FaqGroup(Parcel in) {
        answer = in.readString();
    }

    public static final Creator<FaqGroup> CREATOR = new Creator<FaqGroup>() {
        @Override
        public FaqGroup createFromParcel(Parcel in) {
            return new FaqGroup(in);
        }

        @Override
        public FaqGroup[] newArray(int size) {
            return new FaqGroup[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(answer);
    }
}
