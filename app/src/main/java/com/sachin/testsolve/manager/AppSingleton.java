package com.sachin.testsolve.manager;

import com.sachin.testsolve.interfaces.ImageInterface;
import com.sachin.testsolve.interfaces.MilestoneInterface;
import com.sachin.testsolve.interfaces.VideoInterface;

/**
 * Created by Windows on 19-07-2017.
 */
public class AppSingleton {
    private VideoInterface videoInterface;
    private ImageInterface imageInterface;
    private MilestoneInterface milestoneInterface;
    private static AppSingleton ourInstance = new AppSingleton();

    public static AppSingleton getInstance() {
        return ourInstance;
    }

    private AppSingleton() {
    }

    public ImageInterface getImageInterface() {
        return imageInterface;
    }

    public void setImageInterface(ImageInterface imageInterface) {
        this.imageInterface = imageInterface;
    }

    public MilestoneInterface getMilestoneInterface() {
        return milestoneInterface;
    }

    public void setMilestoneInterface(MilestoneInterface milestoneInterface) {
        this.milestoneInterface = milestoneInterface;
    }

    public VideoInterface getVideoInterface() {
        return videoInterface;
    }

    public void setVideoInterface(VideoInterface videoInterface) {
        this.videoInterface = videoInterface;
    }
}
