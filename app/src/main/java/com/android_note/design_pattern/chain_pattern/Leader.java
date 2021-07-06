package com.android_note.design_pattern.chain_pattern;

public class Leader implements Handler{

    public String mName;
    public Handler mNextHandler;
    public int mCouldHandlerNum;

    public Leader(String name, int couldHandlerNum) {
        mName = name;
        mCouldHandlerNum = couldHandlerNum;
    }

    @Override
    public void setSuccessor(Handler handler) {
        mNextHandler = handler;
    }

    @Override
    public Handler getNextSuccessor() {
        return mNextHandler;
    }

    @Override
    public void handleRequest(int dayNum) {
        if (dayNum <= mCouldHandlerNum) {
            System.out.println(mName + " 同意了你的申请， dayNum = " + dayNum);
        } else {
            Handler nextSuccessor = getNextSuccessor();
            if (nextSuccessor != null) {
                nextSuccessor.handleRequest(dayNum);
            } else {
                System.out.println(mName + " 拒绝了你的申请 dayNum = " + dayNum);
            }
        }
    }

}
